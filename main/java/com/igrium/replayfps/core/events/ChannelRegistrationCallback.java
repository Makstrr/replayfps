/*    */ package com.igrium.replayfps.core.events;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import java.util.function.Consumer;
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ChannelRegistrationCallback
/*    */ {
/* 17 */   public static final Event<ChannelRegistrationCallback> EVENT = EventFactory.createArrayBacked(ChannelRegistrationCallback.class, listeners -> ());
/*    */   
/*    */   void createChannels(Consumer<ChannelHandler<?>> paramConsumer);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\events\ChannelRegistrationCallback.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */