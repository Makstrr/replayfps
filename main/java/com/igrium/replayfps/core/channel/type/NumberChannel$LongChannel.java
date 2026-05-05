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
/*     */ public class LongChannel
/*     */   extends NumberChannel<Long>
/*     */ {
/*     */   public Class<Long> getType() {
/* 138 */     return Long.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 143 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public Long read(DataInput in) throws IOException {
/* 148 */     return Long.valueOf(in.readLong());
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(DataOutput out, Long val) throws IOException {
/* 153 */     out.writeLong(val.longValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public Long defaultValue() {
/* 158 */     return Long.valueOf(0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long interpolate(Long from, Long to, float delta) {
/* 163 */     return Long.valueOf((long)(delta * (float)(to.longValue() - from.longValue()) + (float)from.longValue()));
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\NumberChannel$LongChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */