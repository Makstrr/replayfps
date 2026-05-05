/*    */ package com.igrium.replayfps.game.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.game.event.ClientJoinedWorldEvent;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_638;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({class_310.class})
/*    */ public class MinecraftClientMixin
/*    */ {
/*    */   void replayfps$onJoinWorld(class_638 world, CallbackInfo ci) {
/* 14 */     ((ClientJoinedWorldEvent)ClientJoinedWorldEvent.EVENT.invoker()).onJoinedWorld((class_310)this, world);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\mixin\MinecraftClientMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */