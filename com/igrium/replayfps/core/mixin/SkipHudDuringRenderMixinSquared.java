/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.bawnorton.mixinsquared.TargetHandler;
/*    */ import com.igrium.replayfps.ReplayFPS;
/*    */ import com.igrium.replayfps.core.util.PlaybackUtils;
/*    */ import net.minecraft.class_329;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {class_329.class}, priority = 1500)
/*    */ public class SkipHudDuringRenderMixinSquared
/*    */ {
/*    */   @TargetHandler(mixin = "com.replaymod.render.mixin.Mixin_SkipHudDuringRender", name = "replayModRender_skipHudDuringRender")
/*    */   @Inject(method = {"@MixinSquared:Handler"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void replayfps$dontSkipHudDuringRender(CallbackInfo ci) {
/* 22 */     if (PlaybackUtils.isViewingPlaybackPlayer() && ReplayFPS.getConfig().shouldDrawHud())
/* 23 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\SkipHudDuringRenderMixinSquared.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */