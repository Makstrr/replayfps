/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import com.replaymod.replay.FullReplaySender;
/*    */ import com.replaymod.replay.ReplayHandler;
/*    */ import com.replaymod.replay.ReplaySender;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_338;
/*    */ import net.minecraft.class_7469;
/*    */ import net.minecraft.class_7591;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_338.class})
/*    */ public class ChatHudMixin
/*    */ {
/*    */   @Inject(method = {"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   void replayfps$onAddMessage(class_2561 message, class_7469 signature, int ticks, class_7591 indicator, boolean refresh, CallbackInfo ci) {
/* 25 */     ReplayHandler handler = ClientPlaybackModule.getInstance().getCurrentReplay();
/* 26 */     if (handler != null) { ReplaySender replaySender = handler.getReplaySender(); if (replaySender instanceof FullReplaySender) { FullReplaySender sender = (FullReplaySender)replaySender;
/* 27 */         if (sender.isHurrying()) ci.cancel();  }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ChatHudMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */