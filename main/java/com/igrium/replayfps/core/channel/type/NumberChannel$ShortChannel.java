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
/*    */ public class ShortChannel
/*    */   extends NumberChannel<Short>
/*    */ {
/*    */   public Class<Short> getType() {
/* 72 */     return Short.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 77 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public Short read(DataInput in) throws IOException {
/* 82 */     return Short.valueOf(in.readShort());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Short val) throws IOException {
/* 87 */     out.writeShort(val.shortValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public Short defaultValue() {
/* 92 */     return Short.valueOf((short)0);
/*    */   }
/*    */ 
/*    */   
/*    */   public Short interpolate(Short from, Short to, float delta) {
/* 97 */     return Short.valueOf((short)(int)(delta * (to.shortValue() - from.shortValue()) + from.shortValue()));
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\NumberChannel$ShortChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */