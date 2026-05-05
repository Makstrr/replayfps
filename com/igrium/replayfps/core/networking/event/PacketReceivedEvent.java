/*    */ package com.igrium.replayfps.core.networking.event;
/*    */ 
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ import net.minecraft.class_2547;
/*    */ import net.minecraft.class_2596;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface PacketReceivedEvent
/*    */ {
/* 13 */   public static final Event<PacketReceivedEvent> EVENT = EventFactory.createArrayBacked(PacketReceivedEvent.class, listeners -> ());
/*    */   
/*    */   boolean onPacketReceived(class_2596<?> paramclass_2596, class_2547 paramclass_2547);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\event\PacketReceivedEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */