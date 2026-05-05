/*     */ package com.igrium.replayfps.core.util;
/*     */ 
/*     */ import com.mojang.logging.LogUtils;
/*     */ import java.util.Optional;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedDeque;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.Executor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ConcurrentBuffer<T>
/*     */ {
/*     */   private final Executor executor;
/*     */   private volatile int bufferSize;
/*     */   private volatile int bufferThreshold;
/*     */   private final Queue<T> buffer;
/*     */   private volatile int startIndex;
/*     */   private volatile Optional<Exception> error;
/*     */   private volatile CountDownLatch bufferingLatch;
/*     */   private boolean hasReachedEnd;
/*     */   private volatile boolean isBuffering;
/*     */   private volatile boolean interruptBuffer;
/*     */   
/*     */   public ConcurrentBuffer(Executor executor) {
/*  37 */     this.bufferSize = 1024;
/*  38 */     this.bufferThreshold = 512;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.buffer = new ConcurrentLinkedDeque<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     this.error = Optional.empty();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.bufferingLatch = new CountDownLatch(1); this.executor = executor; buffer();
/*     */   }
/*     */   protected Executor getExecutor() { return this.executor; }
/*     */   public int getBufferSize() { return this.bufferSize; }
/* 106 */   public void setBufferSize(int bufferSize) { this.bufferSize = bufferSize; } public int getBufferThreshold() { return this.bufferThreshold; } public boolean hasReachedEnd() { return this.hasReachedEnd; }
/*     */   public void setBufferThreshold(int bufferThreshold) { this.bufferThreshold = bufferThreshold; }
/*     */   protected abstract T load(int paramInt) throws Exception;
/*     */   private T tryLoad(int index) { if (hasErrored()) return null;  try { return load(index); } catch (Exception e) { this.error = Optional.of(e); return null; }  }
/* 110 */   public Optional<Exception> getError() { return this.error; } public boolean hasErrored() { return this.error.isPresent(); } private boolean shouldBlock() { return (this.buffer.isEmpty() && this.bufferingLatch != null && !this.hasReachedEnd && !hasErrored()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean waitForBuffer() {
/* 118 */     if (shouldBlock()) {
/* 119 */       buffer();
/* 120 */       awaitBufferLatch();
/* 121 */       return true;
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   protected void awaitBufferLatch() {
/*     */     try {
/* 128 */       this.bufferingLatch.await();
/* 129 */     } catch (InterruptedException e) {
/* 130 */       LogUtils.getLogger().error("Thread was inturrupted while waiting for buffer.", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buffer() {
/* 138 */     if (!this.isBuffering) this.executor.execute(this::doBuffer);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doBuffer() {
/* 145 */     if (this.isBuffering || hasErrored())
/*     */       return; 
/* 147 */     this.isBuffering = true;
/* 148 */     synchronized (this.buffer) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 153 */         int index = this.startIndex + this.buffer.size();
/* 154 */         if (hasErrored()) {
/*     */           return;
/*     */         }
/* 157 */         this.interruptBuffer = false;
/* 158 */         int i = 0;
/* 159 */         while (this.buffer.size() <= this.bufferSize && i <= this.bufferSize && !this.interruptBuffer && !this.hasReachedEnd) {
/* 160 */           T val = tryLoad(index);
/* 161 */           if (val == null) {
/* 162 */             this.hasReachedEnd = true;
/*     */           } else {
/* 164 */             this.buffer.add(val);
/*     */           } 
/*     */           
/* 167 */           index++;
/* 168 */           i++;
/* 169 */           openLatch();
/*     */         } 
/* 171 */         this.interruptBuffer = false;
/* 172 */       } catch (Exception e) {
/* 173 */         e.printStackTrace();
/* 174 */         this.error = Optional.of(e);
/*     */       } 
/* 176 */       openLatch();
/* 177 */       this.isBuffering = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void interruptBuffer() {
/* 183 */     if (this.isBuffering) this.interruptBuffer = true; 
/*     */   }
/*     */   
/*     */   public final boolean isBuffering() {
/* 187 */     return this.isBuffering;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void openLatch() {
/* 193 */     if (this.bufferingLatch != null && this.bufferingLatch.getCount() == 0L)
/*     */       return; 
/* 195 */     CountDownLatch oldLatch = this.bufferingLatch;
/* 196 */     this.bufferingLatch = new CountDownLatch(1);
/* 197 */     if (oldLatch != null)
/* 198 */       oldLatch.countDown(); 
/*     */   }
/*     */   
/*     */   public synchronized T poll() {
/* 202 */     if (waitForBuffer())
/*     */     {
/* 204 */       return poll();
/*     */     }
/* 206 */     return pollImmediately();
/*     */   }
/*     */   
/*     */   public synchronized T pollImmediately() {
/* 210 */     this.startIndex++;
/* 211 */     T val = this.buffer.poll();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     return val;
/*     */   }
/*     */   
/*     */   public synchronized T peek() {
/* 220 */     if (waitForBuffer())
/*     */     {
/* 222 */       return peek();
/*     */     }
/* 224 */     return peekImmediately();
/*     */   }
/*     */   
/*     */   public T peekImmediately() {
/* 228 */     return this.buffer.peek();
/*     */   }
/*     */   
/*     */   public synchronized void seek(int index) {
/* 232 */     if (index < 0) {
/* 233 */       throw new IndexOutOfBoundsException(index);
/*     */     }
/*     */     
/* 236 */     if (this.isBuffering) {
/* 237 */       interruptBuffer();
/*     */     }
/*     */     
/* 240 */     synchronized (this.buffer) {
/* 241 */       this.buffer.clear();
/* 242 */       this.startIndex = index;
/* 243 */       this.hasReachedEnd = false;
/*     */     } 
/*     */     
/* 246 */     buffer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndex() {
/* 253 */     return this.startIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 261 */     if (this.isBuffering) {
/* 262 */       interruptBuffer();
/*     */     }
/*     */     
/* 265 */     synchronized (this.buffer) {
/* 266 */       this.buffer.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\ConcurrentBuffer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */