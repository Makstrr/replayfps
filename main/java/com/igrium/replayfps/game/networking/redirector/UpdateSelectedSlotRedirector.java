/*    */ package com.igrium.replayfps.game.networking.redirector;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2735;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class UpdateSelectedSlotRedirector
/*    */   implements PacketRedirector<class_2735>
/*    */ {
/*    */   public Class<class_2735> getPacketClass() {
/* 14 */     return class_2735.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRedirect(class_2735 packet, class_1657 localPlayer, class_310 client) {
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void redirect(class_2735 packet, class_1657 localPlayer, class_310 client) {
/* 25 */     client.execute(() -> {
/*    */           if (class_1661.method_7380(packet.method_11803()))
/*    */             (localPlayer.method_31548()).field_7545 = packet.method_11803(); 
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\redirector\UpdateSelectedSlotRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */