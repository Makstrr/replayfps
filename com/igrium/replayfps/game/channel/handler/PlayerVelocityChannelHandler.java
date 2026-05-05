/*    */ package com.igrium.replayfps.game.channel.handler;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelTypes;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_742;
/*    */ 
/*    */ public class PlayerVelocityChannelHandler
/*    */   implements ChannelHandler<class_243>
/*    */ {
/*    */   public ChannelType<class_243> getChannelType() {
/* 15 */     return (ChannelType<class_243>)ChannelTypes.VEC3D;
/*    */   }
/*    */ 
/*    */   
/*    */   public class_243 capture(ClientCaptureContext context) throws Exception {
/* 20 */     return context.localPlayer().method_18798();
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(class_243 val, ClientPlaybackContext context) throws Exception {
/* 25 */     context.localPlayer().ifPresent(player -> player.method_18799(val));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldInterpolate() {
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\channel\handler\PlayerVelocityChannelHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */