/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.event.PacketReceivedEvent;
/*    */ import net.minecraft.class_2535;
/*    */ import net.minecraft.class_2547;
/*    */ import net.minecraft.class_2596;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_2535.class})
/*    */ public class ClientConnectionMixin
/*    */ {
/*    */   @Inject(method = {"handlePacket"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void replayfps$onHandlePacket(class_2596<?> packet, class_2547 listener, CallbackInfo ci) {
/* 19 */     if (((PacketReceivedEvent)PacketReceivedEvent.EVENT.invoker()).onPacketReceived(packet, listener))
/* 20 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ClientConnectionMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */