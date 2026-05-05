/*    */ package com.igrium.replayfps.game.networking;
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import com.igrium.replayfps.core.networking.PacketRedirectors;
/*    */ import com.igrium.replayfps.game.networking.redirector.EntityEquipmentUpdateRedirector;
/*    */ import com.igrium.replayfps.game.networking.redirector.ExperienceUpdateRedirector;
/*    */ import com.igrium.replayfps.game.networking.redirector.HealthHungerRedirector;
/*    */ 
/*    */ public class DefaultPacketRedirectors {
/*    */   public static void registerDefaults() {
/* 10 */     PacketRedirectors.register((PacketRedirector)new HealthHungerRedirector());
/* 11 */     PacketRedirectors.register((PacketRedirector)new ExperienceUpdateRedirector());
/*    */     
/* 13 */     PacketRedirectors.register((PacketRedirector)new EntityEquipmentUpdateRedirector());
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\DefaultPacketRedirectors.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */