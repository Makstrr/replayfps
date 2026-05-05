/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.events.ReplayEvents;
/*    */ import com.replaymod.replay.ReplayHandler;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({ReplayHandler.class})
/*    */ public class ReplayHandlerMixin
/*    */ {
/*    */   @Inject(method = {"setup"}, at = {@At("HEAD")}, remap = false)
/*    */   private void replayfps$onSetup(CallbackInfo ci) {
/* 16 */     ((ReplayEvents.ReplaySetup)ReplayEvents.REPLAY_SETUP.invoker()).onReplaySetup((ReplayHandler)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ReplayHandlerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */