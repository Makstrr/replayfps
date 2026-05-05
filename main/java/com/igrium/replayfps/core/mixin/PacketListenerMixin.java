/*    */ package com.igrium.replayfps.core.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.core.events.RecordingEvents;
/*    */ import com.igrium.replayfps.core.util.TimecodeProvider;
/*    */ import com.replaymod.recording.packet.PacketListener;
/*    */ import com.replaymod.replaystudio.replay.ReplayFile;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({PacketListener.class})
/*    */ public class PacketListenerMixin
/*    */   implements TimecodeProvider
/*    */ {
/*    */   @Shadow(remap = false)
/*    */   private ReplayFile replayFile;
/*    */   @Shadow(remap = false)
/*    */   private ExecutorService saveService;
/*    */   @Shadow(remap = false)
/*    */   private long startTime;
/*    */   @Shadow(remap = false)
/*    */   private long timePassedWhilePaused;
/*    */   @Shadow(remap = false)
/*    */   private volatile boolean serverWasPaused;
/*    */   
/*    */   @Inject(method = {"channelInactive"}, at = {@At("HEAD")}, remap = false)
/*    */   void channelInactive(ChannelHandlerContext ctx, CallbackInfo ci) {
/* 38 */     this.saveService.submit(() -> ((RecordingEvents.StopRecording)RecordingEvents.STOP_RECORDING.invoker()).onStopRecording((PacketListener)this, this.replayFile));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getStartTime() {
/* 45 */     return this.startTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getTimePassedWhilePaused() {
/* 50 */     return this.timePassedWhilePaused;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getServerWasPaused() {
/* 55 */     return this.serverWasPaused;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\PacketListenerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */