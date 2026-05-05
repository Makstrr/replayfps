/*    */ package com.igrium.replayfps.game.networking.redirector;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirector;
/*    */ import com.igrium.replayfps.game.mixin.LivingEntityAccessor;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2749;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class HealthHungerRedirector
/*    */   implements PacketRedirector<class_2749>
/*    */ {
/*    */   public Class<class_2749> getPacketClass() {
/* 14 */     return class_2749.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldRedirect(class_2749 packet, class_1657 localPlayer, class_310 client) {
/* 19 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void redirect(class_2749 packet, class_1657 localPlayer, class_310 client) {
/* 24 */     client.execute(() -> {
/*    */           doUpdateHealth(packet.method_11833(), localPlayer);
/*    */           localPlayer.method_7344().method_7580(packet.method_11831());
/*    */           localPlayer.method_7344().method_7581(packet.method_11834());
/*    */         });
/*    */   }
/*    */   
/*    */   private void doUpdateHealth(float health, class_1657 player) {
/* 32 */     if (health == player.method_6032())
/* 33 */       return;  float f = player.method_6032() - health;
/* 34 */     if (f < 0.0F) {
/* 35 */       player.method_6033(health);
/* 36 */       player.field_6008 = 10;
/*    */     } else {
/* 38 */       ((LivingEntityAccessor)player).setLastDamageTaken(f);
/* 39 */       player.field_6008 = 20;
/* 40 */       player.method_6033(health);
/* 41 */       player.field_6254 = 10;
/* 42 */       player.field_6235 = player.field_6254;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\redirector\HealthHungerRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */