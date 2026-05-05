/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.event.CustomPacketReceivedEvent;
/*    */ import net.fabricmc.fabric.impl.networking.AbstractChanneledNetworkAddon;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({AbstractChanneledNetworkAddon.class})
/*    */ public class ClientPacketListenerMixin
/*    */ {
/*    */   @Inject(method = {"handle"}, at = {@At(value = "INVOKE", target = "Lnet/fabricmc/fabric/impl/networking/AbstractChanneledNetworkAddon;getHandler(Lnet/minecraft/util/Identifier;)Ljava/lang/Object;")}, cancellable = true)
/*    */   protected void replayfps$handle(class_2960 channelName, class_2540 originalBuf, CallbackInfoReturnable<Boolean> ci) {
/* 23 */     if (((CustomPacketReceivedEvent)CustomPacketReceivedEvent.EVENT.invoker()).onPacketReceived(channelName, originalBuf))
/* 24 */       ci.setReturnValue(Boolean.valueOf(true)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ClientPacketListenerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */