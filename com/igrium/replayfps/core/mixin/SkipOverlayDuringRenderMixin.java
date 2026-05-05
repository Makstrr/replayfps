/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
/*    */ import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
/*    */ import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
/*    */ import com.replaymod.render.hooks.EntityRendererHandler;
/*    */ import com.replaymod.replay.gui.overlay.GuiReplayOverlay;
/*    */ import net.minecraft.class_310;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({GuiReplayOverlay.class})
/*    */ public class SkipOverlayDuringRenderMixin
/*    */ {
/*    */   @Inject(method = {"draw"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*    */   void replayfps$dontDrawIfRendering(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo, CallbackInfo ci) {
/* 22 */     if (((EntityRendererHandler.IEntityRenderer)(class_310.method_1551()).field_1773)
/* 23 */       .replayModRender_getHandler() != null)
/* 24 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\SkipOverlayDuringRenderMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */