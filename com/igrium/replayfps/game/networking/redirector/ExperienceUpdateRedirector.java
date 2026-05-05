/*    */ package com.igrium.replayfps.game.networking.redirector;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2748;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class ExperienceUpdateRedirector
/*    */   implements PacketRedirector<class_2748>
/*    */ {
/*    */   public Class<class_2748> getPacketClass() {
/* 13 */     return class_2748.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRedirect(class_2748 packet, class_1657 localPlayer, class_310 client) {
/* 19 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void redirect(class_2748 packet, class_1657 localPlayer, class_310 client) {
/* 25 */     client.execute(() -> {
/*    */           localPlayer.field_7510 = packet.method_11830();
/*    */           localPlayer.field_7495 = packet.method_11827();
/*    */           localPlayer.field_7520 = packet.method_11828();
/*    */           client.field_1724.method_3145(packet.method_11830(), packet.method_11827(), packet.method_11828());
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\redirector\ExperienceUpdateRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */