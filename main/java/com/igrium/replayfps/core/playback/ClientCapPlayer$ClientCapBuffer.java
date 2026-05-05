/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.igrium.replayfps.core.util.ConcurrentBuffer;
/*     */ import java.io.Closeable;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
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
/*     */ public class ClientCapBuffer
/*     */   extends ConcurrentBuffer<UnserializedFrame>
/*     */   implements Closeable
/*     */ {
/* 192 */   private ExecutorService executor = Executors.newSingleThreadExecutor();
/*     */   private final ClientCapReader reader;
/*     */   
/*     */   public ClientCapBuffer(ExecutorService executor, ClientCapReader reader) {
/* 196 */     super(executor);
/* 197 */     this.executor = executor;
/* 198 */     this.reader = reader;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutorService getExecutor() {
/* 203 */     return this.executor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected UnserializedFrame load(int index) throws Exception {
/* 208 */     if (index != this.reader.getPlayhead()) {
/* 209 */       this.reader.seek(index);
/*     */     }
/* 211 */     return this.reader.readFrame();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 216 */     this.executor.shutdown();
/*     */   }
/*     */   
/*     */   public static ClientCapBuffer create(ClientCapReader reader) {
/* 220 */     return new ClientCapBuffer(Executors.newSingleThreadExecutor(r -> new Thread(r, "ClientCap Buffer")), reader);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientCapPlayer$ClientCapBuffer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */