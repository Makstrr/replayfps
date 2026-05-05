/*    */ package com.igrium.replayfps.game.networking.fake_packet;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.FakePacketHandler;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import com.igrium.replayfps.game.event.ClientJoinedWorldEvent;
/*    */ import com.igrium.replayfps.game.event.ClientPlayerEvents;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1934;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_638;
/*    */ import net.minecraft.class_746;
/*    */ 
/*    */ public class SetGamemodeFakePacket
/*    */   extends FakePacketHandler<class_1934> {
/*    */   public SetGamemodeFakePacket(class_2960 id) {
/* 19 */     super(id);
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<class_1934> getType() {
/* 24 */     return class_1934.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerListener(Consumer<class_1934> consumer) {
/* 29 */     ClientPlayerEvents.SET_GAMEMODE.register((player, oldGamemode, newGamemode) -> consumer.accept(newGamemode));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     ClientJoinedWorldEvent.EVENT.register((client, world) -> consumer.accept(client.field_1761.method_2920()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(class_1934 value, class_2540 buf) {
/* 41 */     buf.method_10817((Enum)value);
/*    */   }
/*    */ 
/*    */   
/*    */   public class_1934 parse(class_2540 buf) {
/* 46 */     return (class_1934)buf.method_10818(class_1934.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(class_1934 value, class_310 client, class_1657 player) {
/* 51 */     ClientPlaybackModule.getInstance().setHudGamemode(value);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\fake_packet\SetGamemodeFakePacket.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */