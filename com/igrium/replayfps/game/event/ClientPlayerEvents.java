/*    */ package com.igrium.replayfps.game.event;
/*    */ 
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1934;
/*    */ import net.minecraft.class_746;
/*    */ 
/*    */ public class ClientPlayerEvents {
/* 10 */   public static final Event<SetGamemodeEvent> SET_GAMEMODE = EventFactory.createArrayBacked(SetGamemodeEvent.class, listeners -> ());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 17 */   public static final Event<SelectSlotEvent> SELECT_SLOT = EventFactory.createArrayBacked(SelectSlotEvent.class, listeners -> ());
/*    */   
/*    */   public static interface SelectSlotEvent {
/*    */     void onSelectSlot(class_1661 param1class_1661, int param1Int);
/*    */   }
/*    */   
/*    */   public static interface SetGamemodeEvent {
/*    */     void onSetGamemode(class_746 param1class_746, class_1934 param1class_19341, class_1934 param1class_19342);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\event\ClientPlayerEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */