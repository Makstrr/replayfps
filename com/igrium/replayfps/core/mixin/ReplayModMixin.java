/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.util.ReplayModHooks;
/*    */ import com.replaymod.core.ReplayMod;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({ReplayMod.class})
/*    */ public class ReplayModMixin
/*    */ {
/*    */   @Inject(method = {"initModules"}, at = {@At("RETURN")}, remap = false)
/*    */   void afterInit(CallbackInfo ci) {
/* 15 */     ReplayModHooks.waitForInit().complete((ReplayMod)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ReplayModMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */