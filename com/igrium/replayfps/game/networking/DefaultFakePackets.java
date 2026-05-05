/*    */ package com.igrium.replayfps.game.networking;
/*    */ 
/*    */ import com.igrium.replayfps.core.networking.FakePacketHandlers;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.class_2960;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultFakePackets
/*    */ {
/*    */   public static void registerDefaults() {
/* 12 */     FakePacketHandlers.register(new class_2960("replayfps:update_hotbar"), com.igrium.replayfps.game.networking.fake_packet.UpdateHotbarFakePacket::new);
/* 13 */     FakePacketHandlers.register(new class_2960("replayfps:update_slot"), com.igrium.replayfps.game.networking.fake_packet.UpdateSelectedSlotFakePacket::new);
/* 14 */     FakePacketHandlers.register(new class_2960("replayfps:set_gamemode"), com.igrium.replayfps.game.networking.fake_packet.SetGamemodeFakePacket::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\networking\DefaultFakePackets.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */