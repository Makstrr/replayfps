/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.PacketRedirectors;
/*    */ import com.replaymod.lib.com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import com.replaymod.replay.FullReplaySender;
/*    */ import net.minecraft.class_2596;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({FullReplaySender.class})
/*    */ public class FullReplaySenderMixin
/*    */ {
/*    */   @ModifyExpressionValue(method = {"processPacket"}, at = {@At(value = "INVOKE", target = "Ljava/util/List;contains(Ljava/lang/Object;)Z")})
/*    */   private boolean replayfps$checkForRedirect(boolean original, class_2596<?> packet) {
/* 19 */     if (PacketRedirectors.shouldRedirect(packet)) {
/* 20 */       PacketRedirectors.REDIRECT_QUEUED.add(packet);
/* 21 */       return false;
/*    */     } 
/* 23 */     return original;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\FullReplaySenderMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */