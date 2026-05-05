/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.ReplayFPS;
/*    */ import com.igrium.replayfps.core.util.PlaybackUtils;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin(targets = {"com.replaymod.replay.camera.CameraEntity$EventHandler"})
/*    */ public class ShowHotbarDuringRenderMixin
/*    */ {
/*    */   @Inject(method = {"shouldRenderHotbar"}, at = {@At("HEAD")}, remap = false, cancellable = true)
/*    */   void replayfps$forceShowHotbar(CallbackInfoReturnable<Boolean> cir) {
/* 16 */     if (PlaybackUtils.isViewingPlaybackPlayer() && ReplayFPS.getConfig().shouldDrawHotbar())
/* 17 */       cir.setReturnValue(Boolean.valueOf(true)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ShowHotbarDuringRenderMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */