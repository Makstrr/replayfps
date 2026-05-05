/*     */ package com.igrium.replayfps.core.util;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SeekableInputStream
/*     */   extends InputStream
/*     */ {
/*     */   protected final InputStreamSupplier supplier;
/*     */   private long head;
/*     */   private long mark;
/*     */   private long prevMark;
/*     */   private InputStream inputStream;
/*  19 */   private int bufferSize = 65536;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SeekableInputStream(InputStreamSupplier supplier) throws IOException {
/*  30 */     this.supplier = supplier;
/*  31 */     genStream();
/*     */   }
/*     */   
/*     */   public SeekableInputStream(InputStreamSupplier supplier, int bufferSize) throws IOException {
/*  35 */     this.supplier = supplier;
/*  36 */     this.bufferSize = bufferSize;
/*  37 */     genStream();
/*     */   }
/*     */   
/*     */   private void genStream() throws IOException {
/*  41 */     if (this.inputStream != null) this.inputStream.close(); 
/*  42 */     this.inputStream = new BufferedInputStream(this.inputStream, this.bufferSize);
/*  43 */     this.prevMark = -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read() throws IOException {
/*  48 */     int result = this.inputStream.read();
/*  49 */     if (result != -1) {
/*  50 */       this.head++;
/*     */     }
/*  52 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read(byte[] b, int off, int len) throws IOException {
/*  57 */     int result = this.inputStream.read(b, off, len);
/*  58 */     this.head += result;
/*  59 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized long skip(long n) throws IOException {
/*  64 */     long result = this.inputStream.skip(n);
/*  65 */     this.head += result;
/*  66 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getHead() {
/*  73 */     return this.head;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/*  78 */     return true;
/*     */   }
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
/*     */   public synchronized void mark(int readlimit) {
/*  99 */     this.mark = this.head;
/* 100 */     if (this.inputStream.markSupported()) {
/* 101 */       this.inputStream.mark(readlimit);
/* 102 */       this.prevMark = this.head;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 108 */     jumpTo(this.mark);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized long jumpTo(long address) throws IOException {
/* 118 */     if (address == this.head) return this.head; 
/* 119 */     if (address > this.head) {
/* 120 */       skip(address - this.head);
/* 121 */       return this.head;
/*     */     } 
/* 123 */     boolean resetSuccess = false;
/*     */     
/* 125 */     if (this.inputStream.markSupported() && this.prevMark >= 0L && address >= this.prevMark) {
/*     */       try {
/* 127 */         this.inputStream.reset();
/* 128 */         this.head = this.prevMark + this.inputStream.skip(address - this.prevMark);
/* 129 */         resetSuccess = true;
/* 130 */       } catch (IOException iOException) {}
/*     */     }
/*     */     
/* 133 */     if (!resetSuccess) {
/* 134 */       genStream();
/* 135 */       this.head = this.inputStream.skip(address);
/*     */     } 
/* 137 */     return this.head;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 143 */     if (this.inputStream != null) this.inputStream.close(); 
/*     */   }
/*     */   
/*     */   public static interface InputStreamSupplier {
/*     */     InputStream get() throws IOException;
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\SeekableInputStream.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */