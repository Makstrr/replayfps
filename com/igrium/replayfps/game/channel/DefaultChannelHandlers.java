/*    */ package com.igrium.replayfps.game.channel;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import com.igrium.replayfps.core.channel.ChannelHandlers;
/*    */ import com.igrium.replayfps.core.events.ChannelRegistrationCallback;
/*    */ import com.igrium.replayfps.game.channel.handler.HorizontalSpeedHandler;
/*    */ import com.igrium.replayfps.game.channel.handler.PlayerPosChannelHandler;
/*    */ import com.igrium.replayfps.game.channel.handler.PlayerRotChannelHandler;
/*    */ import com.igrium.replayfps.game.channel.handler.PlayerStrideChannelHandler;
/*    */ import com.igrium.replayfps.game.channel.handler.PlayerVelocityChannelHandler;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.class_2960;
/*    */ 
/*    */ public class DefaultChannelHandlers {
/* 15 */   public static final PlayerPosChannelHandler PLAYER_POS = (PlayerPosChannelHandler)ChannelHandlers.register((ChannelHandler)new PlayerPosChannelHandler(), new class_2960("replayfps:player_pos"));
/* 16 */   public static final PlayerRotChannelHandler PLAYER_ROT = (PlayerRotChannelHandler)ChannelHandlers.register((ChannelHandler)new PlayerRotChannelHandler(), new class_2960("replayfps:player_rot"));
/* 17 */   public static final PlayerVelocityChannelHandler PLAYER_VELOCITY = (PlayerVelocityChannelHandler)ChannelHandlers.register((ChannelHandler)new PlayerVelocityChannelHandler(), new class_2960("replayfps:player_velocity"));
/* 18 */   public static final PlayerStrideChannelHandler PLAYER_STRIDE = (PlayerStrideChannelHandler)ChannelHandlers.register((ChannelHandler)new PlayerStrideChannelHandler(), new class_2960("replayfps:player_stride"));
/* 19 */   public static final HorizontalSpeedHandler HORIZONTAL_SPEED = (HorizontalSpeedHandler)ChannelHandlers.register((ChannelHandler)new HorizontalSpeedHandler(), new class_2960("replayfps:horizontal_speed"));
/*    */   
/*    */   public static void registerDefaults() {
/* 22 */     ChannelRegistrationCallback.EVENT.register(consumer -> {
/*    */           consumer.accept(PLAYER_POS);
/*    */           consumer.accept(PLAYER_ROT);
/*    */           consumer.accept(PLAYER_VELOCITY);
/*    */           consumer.accept(PLAYER_STRIDE);
/*    */           consumer.accept(HORIZONTAL_SPEED);
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\channel\DefaultChannelHandlers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */