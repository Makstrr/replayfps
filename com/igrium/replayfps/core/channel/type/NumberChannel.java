/*     */ package com.igrium.replayfps.core.channel.type;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public abstract class NumberChannel<T extends Number>
/*     */   implements ChannelType<T>
/*     */ {
/*     */   public int readInt(DataInput in) throws IOException {
/*  11 */     return ((Number)read(in)).intValue();
/*     */   }
/*     */   
/*     */   public long readLong(DataInput in) throws IOException {
/*  15 */     return ((Number)read(in)).longValue();
/*     */   }
/*     */   
/*     */   public short readShort(DataInput in) throws IOException {
/*  19 */     return ((Number)read(in)).shortValue();
/*     */   }
/*     */   
/*     */   public byte readByte(DataInput in) throws IOException {
/*  23 */     return ((Number)read(in)).byteValue();
/*     */   }
/*     */   
/*     */   public float readFloat(DataInput in) throws IOException {
/*  27 */     return ((Number)read(in)).floatValue();
/*     */   }
/*     */   
/*     */   public double readDouble(DataInput in) throws IOException {
/*  31 */     return ((Number)read(in)).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getRawValues(T value) {
/*  36 */     return new float[] { value.floatValue() };
/*     */   }
/*     */   
/*     */   public static class ByteChannel
/*     */     extends NumberChannel<Byte>
/*     */   {
/*     */     public Class<Byte> getType() {
/*  43 */       return Byte.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/*  48 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Byte read(DataInput in) throws IOException {
/*  53 */       return Byte.valueOf(in.readByte());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Byte val) throws IOException {
/*  58 */       out.writeByte(val.byteValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Byte defaultValue() {
/*  63 */       return Byte.valueOf((byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ShortChannel
/*     */     extends NumberChannel<Short>
/*     */   {
/*     */     public Class<Short> getType() {
/*  72 */       return Short.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/*  77 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public Short read(DataInput in) throws IOException {
/*  82 */       return Short.valueOf(in.readShort());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Short val) throws IOException {
/*  87 */       out.writeShort(val.shortValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Short defaultValue() {
/*  92 */       return Short.valueOf((short)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Short interpolate(Short from, Short to, float delta) {
/*  97 */       return Short.valueOf((short)(int)(delta * (to.shortValue() - from.shortValue()) + from.shortValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IntegerChannel
/*     */     extends NumberChannel<Integer>
/*     */   {
/*     */     public Class<Integer> getType() {
/* 105 */       return Integer.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 110 */       return 4;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer read(DataInput in) throws IOException {
/* 115 */       return Integer.valueOf(in.readInt());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Integer val) throws IOException {
/* 120 */       out.writeInt(val.intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer defaultValue() {
/* 125 */       return Integer.valueOf(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer interpolate(Integer from, Integer to, float delta) {
/* 130 */       return Integer.valueOf((int)(delta * (to.intValue() - from.intValue()) + from.intValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LongChannel
/*     */     extends NumberChannel<Long>
/*     */   {
/*     */     public Class<Long> getType() {
/* 138 */       return Long.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 143 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public Long read(DataInput in) throws IOException {
/* 148 */       return Long.valueOf(in.readLong());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Long val) throws IOException {
/* 153 */       out.writeLong(val.longValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Long defaultValue() {
/* 158 */       return Long.valueOf(0L);
/*     */     }
/*     */ 
/*     */     
/*     */     public Long interpolate(Long from, Long to, float delta) {
/* 163 */       return Long.valueOf((long)(delta * (float)(to.longValue() - from.longValue()) + (float)from.longValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FloatChannel
/*     */     extends NumberChannel<Float>
/*     */   {
/*     */     public Class<Float> getType() {
/* 171 */       return Float.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 176 */       return 4;
/*     */     }
/*     */ 
/*     */     
/*     */     public Float read(DataInput in) throws IOException {
/* 181 */       return Float.valueOf(in.readFloat());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Float val) throws IOException {
/* 186 */       out.writeFloat(val.floatValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Float defaultValue() {
/* 191 */       return Float.valueOf(0.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public Float interpolate(Float from, Float to, float delta) {
/* 196 */       return Float.valueOf(delta * (to.floatValue() - from.floatValue()) + from.floatValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DoubleChannel
/*     */     extends NumberChannel<Double>
/*     */   {
/*     */     public Class<Double> getType() {
/* 204 */       return Double.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 209 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public Double read(DataInput in) throws IOException {
/* 214 */       return Double.valueOf(in.readDouble());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Double val) throws IOException {
/* 219 */       out.writeDouble(val.doubleValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Double defaultValue() {
/* 224 */       return Double.valueOf(0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public Double interpolate(Double from, Double to, float delta) {
/* 229 */       return Double.valueOf(delta * (to.doubleValue() - from.doubleValue()) + from.doubleValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class UnsignedShortChannel
/*     */     extends NumberChannel<Integer>
/*     */   {
/*     */     public Class<Integer> getType() {
/* 237 */       return Integer.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 242 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer read(DataInput in) throws IOException {
/* 247 */       return Integer.valueOf(in.readUnsignedShort());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Integer val) throws IOException {
/* 252 */       out.writeShort(val.intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer defaultValue() {
/* 257 */       return Integer.valueOf(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class UnsignedByteChannel
/*     */     extends NumberChannel<Integer>
/*     */   {
/*     */     public Class<Integer> getType() {
/* 266 */       return Integer.class;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 271 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer read(DataInput in) throws IOException {
/* 276 */       return Integer.valueOf(in.readUnsignedByte());
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(DataOutput out, Integer val) throws IOException {
/* 281 */       out.writeByte(val.intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer defaultValue() {
/* 286 */       return Integer.valueOf(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\NumberChannel.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */