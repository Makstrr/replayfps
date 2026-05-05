/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
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
/*    */ public class ByteChannel
/*    */   extends NumberChannel<Byte>
/*    */ {
/*    */   public Class<Byte> getType() {
/* 43 */     return Byte.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 48 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public Byte read(DataInput in) throws IOException {
/* 53 */     return Byte.valueOf(in.readByte());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Byte val) throws IOException {
/* 58 */     out.writeByte(val.byteValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public Byte defaultValue() {
/* 63 */     return Byte.valueOf((byte)0);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\NumberChannel$ByteChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */