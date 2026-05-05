/*    */ package com.igrium.replayfps.core.channel;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ChannelHandler<T>
/*    */ {
/*    */   ChannelType<T> getChannelType();
/*    */   
/*    */   T capture(ClientCaptureContext paramClientCaptureContext) throws Exception;
/*    */   
/*    */   void apply(T paramT, ClientPlaybackContext paramClientPlaybackContext) throws Exception;
/*    */   
/*    */   default Class<T> getType() {
/* 23 */     return getChannelType().getType();
/*    */   }
/*    */   
/*    */   default boolean shouldInterpolate() {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean applyPerTick() {
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   static <T> void writeChannel(ClientCaptureContext context, DataOutput out, ChannelHandler<T> handler) throws Exception {
/* 38 */     T val = handler.capture(context);
/* 39 */     handler.getChannelType().write(out, val);
/*    */   }
/*    */   
/*    */   static <T> void readChannel(DataInput in, ChannelHandler<T> handler, ClientPlaybackContext context) throws Exception {
/* 43 */     T val = (T)handler.getChannelType().read(in);
/* 44 */     handler.apply(val, context);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\ChannelHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */