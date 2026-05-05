/*    */ package com.igrium.replayfps.game.networking.redirector;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import com.mojang.datafixers.util.Pair;
/*    */ import net.minecraft.class_1304;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2744;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class EntityEquipmentUpdateRedirector implements PacketRedirector<class_2744> {
/*    */   public Class<class_2744> getPacketClass() {
/* 14 */     return class_2744.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRedirect(class_2744 packet, class_1657 localPlayer, class_310 client) {
/* 20 */     return (localPlayer != null && packet.method_11820() == localPlayer.method_5628());
/*    */   }
/*    */ 
/*    */   
/*    */   public void redirect(class_2744 packet, class_1657 localPlayer, class_310 client) {
/* 25 */     client.execute(() -> doRedirect(packet, localPlayer, client));
/*    */   }
/*    */   
/*    */   private void doRedirect(class_2744 packet, class_1657 localPlayer, class_310 client) {
/* 29 */     if (packet.method_11820() != localPlayer.method_5628()) {
/* 30 */       throw new IllegalStateException("This packet should not redirect for entities other than the local player.");
/*    */     }
/*    */     
/* 33 */     for (Pair<class_1304, class_1799> pair : (Iterable<Pair<class_1304, class_1799>>)packet.method_30145()) {
/* 34 */       if (pair.getFirst() != class_1304.field_6173)
/* 35 */         localPlayer.method_5673((class_1304)pair.getFirst(), (class_1799)pair.getSecond()); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\redirector\EntityEquipmentUpdateRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */