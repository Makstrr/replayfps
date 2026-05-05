/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.ReplayFPS;
/*    */ import com.igrium.replayfps.core.playback.ClientCapPlayer;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1934;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_757;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({class_757.class})
/*    */ public class GameRendererMixin
/*    */ {
/* 20 */   private class_1934 replayfps$prevGamemode = null;
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"render"}, at = {@At("HEAD")})
/*    */   void replayfps$onStartRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
/* 26 */     ClientCapPlayer playback = ClientPlaybackModule.getInstance().getCurrentPlayer();
/* 27 */     class_310 client = class_310.method_1551();
/* 28 */     if (playback == null || client.field_1687 == null || !ReplayFPS.getInstance().config().shouldDrawHud()) {
/* 29 */       this.replayfps$prevGamemode = null;
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     int localPlayerID = playback.getReader().getHeader().getLocalPlayerID();
/* 34 */     class_1297 localPlayer = client.field_1687.method_8469(localPlayerID);
/* 35 */     if (localPlayer == null) {
/* 36 */       this.replayfps$prevGamemode = null;
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     if (localPlayer.equals(client.method_1560()) && localPlayer instanceof class_1657) { class_1657 localPlayerEnt = (class_1657)localPlayer;
/*    */       
/* 42 */       this.replayfps$prevGamemode = client.field_1761.method_2920();
/* 43 */       client.field_1761.method_2907(ClientPlaybackModule.getInstance().getHudGamemode()); }
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"render"}, at = {@At("RETURN")})
/*    */   void replayfps$onEndRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
/* 49 */     if (this.replayfps$prevGamemode != null) {
/* 50 */       class_310 client = class_310.method_1551();
/* 51 */       client.field_1761.method_2907(this.replayfps$prevGamemode);
/*    */     } 
/* 53 */     this.replayfps$prevGamemode = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\GameRendererMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */