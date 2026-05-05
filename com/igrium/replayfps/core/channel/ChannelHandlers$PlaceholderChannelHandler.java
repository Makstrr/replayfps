/*    */ package com.igrium.replayfps.core.channel;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.PlaceholderChannel;
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
/*    */ public class PlaceholderChannelHandler
/*    */   implements ChannelHandler<Object>
/*    */ {
/*    */   private final ChannelType<Object> type;
/*    */   
/*    */   public PlaceholderChannelHandler(int size) {
/* 25 */     this.type = (ChannelType<Object>)new PlaceholderChannel(size);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChannelType<Object> getChannelType() {
/* 30 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object capture(ClientCaptureContext context) {
/* 35 */     return null;
/*    */   }
/*    */   
/*    */   public void apply(Object val, ClientPlaybackContext context) {}
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\ChannelHandlers$PlaceholderChannelHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */