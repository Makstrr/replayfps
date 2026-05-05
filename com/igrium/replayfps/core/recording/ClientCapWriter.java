/*    */ package com.igrium.replayfps.core.recording;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.playback.UnserializedFrame;
/*    */ import java.io.DataOutput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientCapWriter
/*    */ {
/*    */   private final OutputStream out;
/*    */   private int writtenFrames;
/*    */   
/*    */   public ClientCapWriter(OutputStream out) {
/* 22 */     this.out = out;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeFrame(UnserializedFrame frame) throws IOException {
/*    */     try {
/* 33 */       DataOutputStream dataOut = new DataOutputStream(this.out);
/* 34 */       for (Map.Entry<ChannelHandler<?>, Object> entry : (Iterable<Map.Entry<ChannelHandler<?>, Object>>)frame.getValues().entrySet()) {
/* 35 */         writeChannel(((ChannelHandler)entry.getKey()).getChannelType(), dataOut, entry.getValue());
/*    */       }
/*    */     } finally {
/* 38 */       this.writtenFrames++;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private <T> void writeChannel(ChannelType<T> channelType, DataOutput out, Object value) throws IOException {
/* 45 */     T val = channelType.getType().cast(value);
/* 46 */     channelType.write(out, val);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWrittenFrames() {
/* 55 */     return this.writtenFrames;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientCapWriter.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */