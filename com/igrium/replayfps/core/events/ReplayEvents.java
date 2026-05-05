/*   */ package com.igrium.replayfps.core.events;
/*   */ import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
/*   */ import com.replaymod.replay.ReplayHandler;
/*   */ import java.util.List;
/*   */ 
/*   */ public class ReplayEvents {
/* 7 */   public static final Event<ReplaySetup> REPLAY_SETUP = Event.create(listeners -> ());
/*   */   
/*   */   public static interface ReplaySetup {
/*   */     void onReplaySetup(ReplayHandler param1ReplayHandler);
/*   */   }
/*   */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\events\ReplayEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */