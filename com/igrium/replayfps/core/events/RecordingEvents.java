/*    */ package com.igrium.replayfps.core.events;
/*    */ 
/*    */ import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
/*    */ import com.replaymod.recording.packet.PacketListener;
/*    */ import com.replaymod.replaystudio.replay.ReplayFile;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RecordingEvents
/*    */ {
/* 12 */   public static final Event<StartedRecording> STARTED_RECORDING = Event.create(listeners -> ());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 21 */   public static final Event<StopRecording> STOP_RECORDING = Event.create(listeners -> ());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   public static final Event<StoppedRecording> STOPPED_RECORDING = Event.create(listeners -> ());
/*    */   
/*    */   public static interface StoppedRecording {
/*    */     void onStoppedRecording();
/*    */   }
/*    */   
/*    */   public static interface StopRecording {
/*    */     void onStopRecording(PacketListener param1PacketListener, ReplayFile param1ReplayFile);
/*    */   }
/*    */   
/*    */   public static interface StartedRecording {
/*    */     void onStartRecording(PacketListener param1PacketListener, ReplayFile param1ReplayFile);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\events\RecordingEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */