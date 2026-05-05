/*   */ package com.igrium.replayfps.game.event;
/*   */ 
/*   */ import net.fabricmc.fabric.api.event.Event;
/*   */ import net.fabricmc.fabric.api.event.EventFactory;
/*   */ import net.minecraft.class_310;
/*   */ import net.minecraft.class_638;
/*   */ 
/*   */ public interface ClientJoinedWorldEvent {
/* 9 */   public static final Event<ClientJoinedWorldEvent> EVENT = EventFactory.createArrayBacked(ClientJoinedWorldEvent.class, listeners -> ());
/*   */   
/*   */   void onJoinedWorld(class_310 paramclass_310, class_638 paramclass_638);
/*   */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\event\ClientJoinedWorldEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */