/*     */ package com.igrium.replayfps.core.util;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UTFDataFormatException;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataReader
/*     */ {
/*     */   public final void readFully(InputStream in, byte[] b, int off, int len) throws EOFException, IOException {
/*  17 */     Objects.checkFromIndexSize(off, len, b.length);
/*  18 */     int n = 0;
/*  19 */     while (n < len) {
/*  20 */       int count = in.read(b, off + n, len - n);
/*  21 */       if (count < 0)
/*  22 */         throw new EOFException(); 
/*  23 */       n += count;
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
/*     */   public final boolean readBoolean(InputStream in) throws EOFException, IOException {
/*  39 */     int ch = in.read();
/*  40 */     if (ch < 0)
/*  41 */       throw new EOFException(); 
/*  42 */     return (ch != 0);
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
/*     */   public final int readUnsignedByte(InputStream in) throws EOFException, IOException {
/*  56 */     int ch = in.read();
/*  57 */     if (ch < 0)
/*  58 */       throw new EOFException(); 
/*  59 */     return ch;
/*     */   }
/*     */   
/*     */   public final short readShort(InputStream in) throws EOFException, IOException {
/*  63 */     int ch1 = in.read();
/*  64 */     int ch2 = in.read();
/*  65 */     if ((ch1 | ch2) < 0)
/*  66 */       throw new EOFException(); 
/*  67 */     return (short)((ch1 << 8) + (ch2 << 0));
/*     */   }
/*     */   
/*     */   public final char readChar(InputStream in) throws EOFException, IOException {
/*  71 */     int ch1 = in.read();
/*  72 */     int ch2 = in.read();
/*  73 */     if ((ch1 | ch2) < 0)
/*  74 */       throw new EOFException(); 
/*  75 */     return (char)((ch1 << 8) + (ch2 << 0));
/*     */   }
/*     */   
/*     */   public final int readInt(InputStream in) throws EOFException, IOException {
/*  79 */     int ch1 = in.read();
/*  80 */     int ch2 = in.read();
/*  81 */     int ch3 = in.read();
/*  82 */     int ch4 = in.read();
/*  83 */     if ((ch1 | ch2 | ch3 | ch4) < 0)
/*  84 */       throw new EOFException(); 
/*  85 */     return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
/*     */   }
/*     */   
/*  88 */   private byte[] readBuffer = new byte[8];
/*     */   
/*     */   public final long readLong(InputStream in) throws IOException {
/*  91 */     readFully(in, this.readBuffer, 0, 8);
/*  92 */     return (this.readBuffer[0] << 56L) + ((this.readBuffer[1] & 0xFF) << 48L) + ((this.readBuffer[2] & 0xFF) << 40L) + ((this.readBuffer[3] & 0xFF) << 32L) + ((this.readBuffer[4] & 0xFF) << 24L) + ((this.readBuffer[5] & 0xFF) << 16) + ((this.readBuffer[6] & 0xFF) << 8) + ((this.readBuffer[7] & 0xFF) << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float readFloat(InputStream in) throws EOFException, IOException {
/* 103 */     return Float.intBitsToFloat(readInt(in));
/*     */   }
/*     */   
/*     */   public final double readDouble(InputStream in) throws EOFException, IOException {
/* 107 */     return Double.longBitsToDouble(readLong(in));
/*     */   }
/*     */   
/*     */   public final String readUTF(InputStream in) throws EOFException, IOException, UTFDataFormatException {
/* 111 */     return (new DataInputStream(in)).readUTF();
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\DataReader.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */