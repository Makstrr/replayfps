/*    */ package com.igrium.replayfps.game.networking.fake_packet;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.FakePacketHandler;
/*    */ import com.igrium.replayfps.game.event.InventoryModifiedEvent;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
/*    */ import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class UpdateHotbarFakePacket
/*    */   extends FakePacketHandler<UpdateHotbarValue>
/*    */ {
/*    */   public UpdateHotbarFakePacket(class_2960 id) {
/* 19 */     super(id);
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<UpdateHotbarValue> getType() {
/* 24 */     return UpdateHotbarValue.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerListener(Consumer<UpdateHotbarValue> consumer) {
/* 30 */     InventoryModifiedEvent.EVENT.register((inv, map) -> {
/*    */           if (!(inv.field_7546.method_37908()).field_9236) {
/*    */             return;
/*    */           }
/*    */           Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(inv.field_7547.size());
/*    */           int i = 0;
/*    */           for (class_1799 stack : inv.field_7547) {
/*    */             int2ObjectArrayMap.put(i, stack);
/*    */             i++;
/*    */           } 
/*    */           consumer.accept(new UpdateHotbarValue((Int2ObjectMap<class_1799>)int2ObjectArrayMap));
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(UpdateHotbarValue value, class_2540 buf) {
/* 50 */     Int2ObjectMap<class_1799> map = value.map();
/* 51 */     buf.writeInt(map.size());
/* 52 */     map.forEach((slot, stack) -> {
/*    */           buf.writeInt(slot.intValue());
/*    */           buf.method_10793(stack);
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public UpdateHotbarValue parse(class_2540 buf) {
/* 60 */     int size = buf.readInt();
/* 61 */     Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(size);
/* 62 */     for (int i = 0; i < size; i++) {
/* 63 */       int slot = buf.readInt();
/* 64 */       class_1799 stack = buf.method_10819();
/* 65 */       int2ObjectArrayMap.put(slot, stack);
/*    */     } 
/*    */     
/* 68 */     return new UpdateHotbarValue((Int2ObjectMap<class_1799>)int2ObjectArrayMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(UpdateHotbarValue value, class_310 client, class_1657 player) {
/* 73 */     value.map().forEach((slot, stack) -> player.method_31548().method_5447(slot.intValue(), stack));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FakePacketHandler.SpectatorBehavior getSpectatorBehavior() {
/* 80 */     return FakePacketHandler.SpectatorBehavior.APPLY;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\fake_packet\UpdateHotbarFakePacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */