/*    */ package com.igrium.replayfps.game.networking.fake_packet;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.FakePacketHandler;
/*    */ import com.igrium.replayfps.game.event.ClientPlayerEvents;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ public class UpdateSelectedSlotFakePacket
/*    */   extends FakePacketHandler<Integer>
/*    */ {
/*    */   public UpdateSelectedSlotFakePacket(class_2960 id) {
/* 16 */     super(id);
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<Integer> getType() {
/* 21 */     return Integer.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerListener(Consumer<Integer> consumer) {
/* 27 */     ClientPlayerEvents.SELECT_SLOT.register((inv, slot) -> {
/*    */           if (!(inv.field_7546.method_37908()).field_9236)
/*    */             return; 
/*    */           consumer.accept(Integer.valueOf(slot));
/*    */         });
/*    */   }
/*    */   
/*    */   public void write(Integer value, class_2540 buf) {
/* 35 */     buf.writeInt(value.intValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer parse(class_2540 buf) {
/* 40 */     return Integer.valueOf(buf.readInt());
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(Integer value, class_310 client, class_1657 player) {
/* 45 */     (player.method_31548()).field_7545 = value.intValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public FakePacketHandler.SpectatorBehavior getSpectatorBehavior() {
/* 50 */     return FakePacketHandler.SpectatorBehavior.APPLY;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\fake_packet\UpdateSelectedSlotFakePacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */