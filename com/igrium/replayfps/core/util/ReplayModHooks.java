/*    */ package com.igrium.replayfps.core.util;
/*    */ 
/*    */ import com.replaymod.core.ReplayMod;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ 
/*    */ public final class ReplayModHooks
/*    */ {
/* 10 */   private static CompletableFuture<ReplayMod> future = new CompletableFuture<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static CompletableFuture<ReplayMod> waitForInit() {
/* 19 */     return future;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void onReplayModInit(Consumer<ReplayMod> r) {
/* 29 */     future.thenAccept(r);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\ReplayModHooks.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */