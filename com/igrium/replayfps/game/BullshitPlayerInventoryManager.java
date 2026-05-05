/*    */ package com.igrium.replayfps.game;
/*    */ 
/*    */ import com.igrium.replayfps.game.event.ClientJoinedWorldEvent;
/*    */ import com.igrium.replayfps.game.event.InventoryModifiedEvent;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_638;
/*    */ import net.minecraft.class_746;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BullshitPlayerInventoryManager
/*    */ {
/*    */   public static void register() {
/* 19 */     ClientTickEvents.END_CLIENT_TICK.register(BullshitPlayerInventoryManager::onEndTick);
/* 20 */     ClientJoinedWorldEvent.EVENT.register((client, world) -> reset());
/*    */   }
/*    */   
/* 23 */   private static class_1799[] prevInventory = new class_1799[36];
/*    */   
/*    */   private static void onEndTick(class_310 client) {
/* 26 */     class_746 class_746 = client.field_1724;
/* 27 */     if (class_746 == null)
/*    */       return; 
/* 29 */     Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(36);
/*    */     
/* 31 */     class_1661 inventory = class_746.method_31548();
/* 32 */     for (int i = 0; i < prevInventory.length; i++) {
/* 33 */       class_1799 newStack = inventory.method_5438(i);
/* 34 */       if (prevInventory[i] == null || !class_1799.method_7973(prevInventory[i], newStack)) {
/* 35 */         int2ObjectArrayMap.put(i, newStack);
/*    */       }
/*    */       
/* 38 */       prevInventory[i] = newStack.method_7972();
/*    */     } 
/*    */     
/* 41 */     if (!int2ObjectArrayMap.isEmpty()) {
/* 42 */       ((InventoryModifiedEvent)InventoryModifiedEvent.EVENT.invoker()).onInventoryModified(class_746.method_31548(), (Int2ObjectMap)int2ObjectArrayMap);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private static void reset() {
/* 48 */     for (int i = 0; i < prevInventory.length; i++)
/* 49 */       prevInventory[i] = null; 
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\BullshitPlayerInventoryManager.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */