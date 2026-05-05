/*    */ package com.igrium.replayfps.game.channel.handler;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelTypes;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ import net.minecraft.class_742;
/*    */ 
/*    */ public class HorizontalSpeedHandler
/*    */   implements ChannelHandler<Float> {
/*    */   public ChannelType<Float> getChannelType() {
/* 13 */     return (ChannelType<Float>)ChannelTypes.FLOAT;
/*    */   }
/*    */ 
/*    */   
/*    */   public Float capture(ClientCaptureContext context) throws Exception {
/* 18 */     return Float.valueOf((context.localPlayer()).field_5973);
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(Float val, ClientPlaybackContext context) throws Exception {
/* 23 */     context.localPlayer().ifPresent(player -> {
/*    */           player.field_6039 = player.field_5973;
/*    */           player.field_5973 = val.floatValue();
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean applyPerTick() {
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\channel\handler\HorizontalSpeedHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */