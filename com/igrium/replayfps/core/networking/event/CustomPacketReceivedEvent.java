/*    */ package com.igrium.replayfps.core.networking.event;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface CustomPacketReceivedEvent
/*    */ {
/* 14 */   public static final Event<CustomPacketReceivedEvent> EVENT = EventFactory.createArrayBacked(CustomPacketReceivedEvent.class, listeners -> ());
/*    */   
/*    */   boolean onPacketReceived(class_2960 paramclass_2960, class_2540 paramclass_2540);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\event\CustomPacketReceivedEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */