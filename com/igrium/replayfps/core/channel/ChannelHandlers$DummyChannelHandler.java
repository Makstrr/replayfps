/*    */ package com.igrium.replayfps.core.channel;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelTypes;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DummyChannelHandler
/*    */   implements ChannelHandler<Short>
/*    */ {
/*    */   public ChannelType<Short> getChannelType() {
/* 59 */     return (ChannelType<Short>)ChannelTypes.SHORT;
/*    */   }
/*    */ 
/*    */   
/*    */   public Short capture(ClientCaptureContext context) {
/* 64 */     return Short.valueOf((short)4031);
/*    */   }
/*    */   
/*    */   public void apply(Short val, ClientPlaybackContext context) {}
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\ChannelHandlers$DummyChannelHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */