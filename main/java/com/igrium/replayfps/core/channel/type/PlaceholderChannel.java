/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlaceholderChannel
/*    */   implements ChannelType<Object>
/*    */ {
/*    */   private final int size;
/*    */   private final byte[] buffer;
/*    */   
/*    */   public PlaceholderChannel(int size) {
/* 16 */     this.size = size;
/* 17 */     this.buffer = new byte[size];
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<Object> getType() {
/* 22 */     return Object.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 27 */     return this.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object read(DataInput in) throws IOException {
/* 32 */     in.readFully(this.buffer);
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Object val) throws IOException {
/* 38 */     for (int i = 0; i < this.buffer.length; i++) {
/* 39 */       this.buffer[i] = 0;
/*    */     }
/* 41 */     out.write(this.buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object defaultValue() {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 51 */     return "[unknown]";
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\PlaceholderChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */