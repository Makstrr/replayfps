/*     */ package com.igrium.replayfps.core.util;
/*     */ 
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataWriter
/*     */ {
/*  13 */   private final byte[] writeBuffer = new byte[8];
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
/*     */   public final void writeBoolean(OutputStream out, boolean v) throws IOException {
/*  26 */     out.write(v ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeShort(OutputStream out, int v) throws IOException {
/*  38 */     this.writeBuffer[0] = (byte)(v >>> 8);
/*  39 */     this.writeBuffer[1] = (byte)(v >>> 0);
/*  40 */     out.write(this.writeBuffer, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeChar(OutputStream out, int v) throws IOException {
/*  52 */     this.writeBuffer[0] = (byte)(v >>> 8);
/*  53 */     this.writeBuffer[1] = (byte)(v >>> 0);
/*  54 */     out.write(this.writeBuffer, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeInt(OutputStream out, int v) throws IOException {
/*  66 */     this.writeBuffer[0] = (byte)(v >>> 24);
/*  67 */     this.writeBuffer[1] = (byte)(v >>> 16);
/*  68 */     this.writeBuffer[2] = (byte)(v >>> 8);
/*  69 */     this.writeBuffer[3] = (byte)(v >>> 0);
/*  70 */     out.write(this.writeBuffer, 0, 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void writeLong(OutputStream out, long v) throws IOException {
/*  82 */     this.writeBuffer[0] = (byte)(int)(v >>> 56L);
/*  83 */     this.writeBuffer[1] = (byte)(int)(v >>> 48L);
/*  84 */     this.writeBuffer[2] = (byte)(int)(v >>> 40L);
/*  85 */     this.writeBuffer[3] = (byte)(int)(v >>> 32L);
/*  86 */     this.writeBuffer[4] = (byte)(int)(v >>> 24L);
/*  87 */     this.writeBuffer[5] = (byte)(int)(v >>> 16L);
/*  88 */     this.writeBuffer[6] = (byte)(int)(v >>> 8L);
/*  89 */     this.writeBuffer[7] = (byte)(int)(v >>> 0L);
/*  90 */     out.write(this.writeBuffer, 0, 8);
/*     */   }
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
/*     */   public final void writeFloat(OutputStream out, float v) throws IOException {
/* 104 */     writeInt(out, Float.floatToIntBits(v));
/*     */   }
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
/*     */   public final void writeDouble(OutputStream out, double v) throws IOException {
/* 118 */     writeLong(out, Double.doubleToLongBits(v));
/*     */   }
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
/*     */   public final void writeBytes(OutputStream out, String s) throws IOException {
/* 131 */     int len = s.length();
/* 132 */     for (int i = 0; i < len; i++) {
/* 133 */       out.write((byte)s.charAt(i));
/*     */     }
/*     */   }
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
/*     */   public final void writeChars(OutputStream out, String s) throws IOException {
/* 147 */     int len = s.length();
/* 148 */     for (int i = 0; i < len; i++) {
/* 149 */       int v = s.charAt(i);
/* 150 */       this.writeBuffer[0] = (byte)(v >>> 8);
/* 151 */       this.writeBuffer[1] = (byte)(v >>> 0);
/* 152 */       out.write(this.writeBuffer, 0, 2);
/*     */     } 
/*     */   }
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
/*     */   public final void writeUTF(OutputStream out, String str) throws IOException {
/* 176 */     (new DataOutputStream(out)).writeUTF(str);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\DataWriter.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */