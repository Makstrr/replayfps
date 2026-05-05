/*    */ package com.igrium.replayfps.game.event;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import net.fabricmc.fabric.api.event.Event;
/*    */ import net.fabricmc.fabric.api.event.EventFactory;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1799;
/*    */ 
/*    */ public interface InventoryModifiedEvent
/*    */ {
/* 11 */   public static final Event<InventoryModifiedEvent> EVENT = EventFactory.createArrayBacked(InventoryModifiedEvent.class, listeners -> ());
/*    */   
/*    */   void onInventoryModified(class_1661 paramclass_1661, Int2ObjectMap<class_1799> paramInt2ObjectMap);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\event\InventoryModifiedEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */