/*    */ package com.igrium.replayfps.core.networking.event;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.FakePacketHandler;
/*    */ import java.util.function.Consumer;
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface FakePacketRegistrationCallback
/*    */ {
/* 12 */   public static final Event<FakePacketRegistrationCallback> EVENT = EventFactory.createArrayBacked(FakePacketRegistrationCallback.class, listeners -> ());
/*    */   
/*    */   void register(Consumer<FakePacketHandler<?>> paramConsumer);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\event\FakePacketRegistrationCallback.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */