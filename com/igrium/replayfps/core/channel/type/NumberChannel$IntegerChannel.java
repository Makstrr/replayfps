/*     */ package com.igrium.replayfps.core.channel.type;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntegerChannel
/*     */   extends NumberChannel<Integer>
/*     */ {
/*     */   public Class<Integer> getType() {
/* 105 */     return Integer.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 110 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer read(DataInput in) throws IOException {
/* 115 */     return Integer.valueOf(in.readInt());
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(DataOutput out, Integer val) throws IOException {
/* 120 */     out.writeInt(val.intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer defaultValue() {
/* 125 */     return Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer interpolate(Integer from, Integer to, float delta) {
/* 130 */     return Integer.valueOf((int)(delta * (to.intValue() - from.intValue()) + from.intValue()));
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\NumberChannel$IntegerChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */