/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.events.RecordingEvents;
/*    */ import com.replaymod.recording.handler.ConnectionEventHandler;
/*    */ import com.replaymod.recording.packet.PacketListener;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Mixin({ConnectionEventHandler.class})
/*    */ public class ConnectionEventHandlerMixin
/*    */ {
/*    */   @Shadow(remap = false)
/*    */   private PacketListener packetListener;
/*    */   
/*    */   @Inject(method = {"onConnectedToServerEvent"}, at = {@At("TAIL")}, remap = false)
/*    */   void finishReplaySetup(CallbackInfo ci) {
/* 21 */     ((RecordingEvents.StartedRecording)RecordingEvents.STARTED_RECORDING.invoker()).onStartRecording(this.packetListener, ((PacketListenerAccessor)this.packetListener).getReplayFile());
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"reset"}, at = {@At("HEAD")}, remap = false)
/*    */   void reset(CallbackInfo ci) {
/* 27 */     if (this.packetListener != null)
/* 28 */       ((RecordingEvents.StoppedRecording)RecordingEvents.STOPPED_RECORDING.invoker()).onStoppedRecording(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ConnectionEventHandlerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */