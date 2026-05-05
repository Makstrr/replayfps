/*    */ package com.igrium.replayfps.game.networking.redirector;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1723;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2653;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class ScreenHandlerSlotUpdateRedirector
/*    */   implements PacketRedirector<class_2653>
/*    */ {
/*    */   public Class<class_2653> getPacketClass() {
/* 15 */     return class_2653.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRedirect(class_2653 packet, class_1657 localPlayer, class_310 client) {
/* 21 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void redirect(class_2653 packet, class_1657 localPlayer, class_310 client) {
/* 26 */     client.execute(() -> doRedirect(packet, localPlayer, client));
/*    */   }
/*    */   
/*    */   private void doRedirect(class_2653 packet, class_1657 localPlayer, class_310 client) {
/* 30 */     class_1799 itemStack = packet.method_11449();
/* 31 */     int slot = packet.method_11450();
/*    */     
/* 33 */     if (packet.method_11452() == -2) {
/* 34 */       localPlayer.method_31548().method_5447(slot, itemStack);
/*    */     }
/* 36 */     else if (packet.method_11452() == 0 && class_1723.method_36211(slot)) {
/* 37 */       if (!itemStack.method_7960()) {
/* 38 */         class_1799 prevStack = localPlayer.field_7498.method_7611(slot).method_7677();
/* 39 */         if (prevStack.method_7960() || prevStack.method_7947() < itemStack.method_7947()) {
/* 40 */           itemStack.method_7912(5);
/*    */         }
/*    */       } 
/*    */       
/* 44 */       localPlayer.field_7498.method_7619(slot, packet.method_37439(), itemStack);
/*    */ 
/*    */       
/* 47 */       localPlayer.method_31548().method_5447(slot, itemStack);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\redirector\ScreenHandlerSlotUpdateRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */