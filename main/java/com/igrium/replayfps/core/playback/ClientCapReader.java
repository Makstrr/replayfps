/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.google.common.io.CountingInputStream;
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.recording.ClientCapHeader;
/*     */ import com.igrium.replayfps.core.util.NoHeaderException;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.EOFException;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.channels.Channels;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public class ClientCapReader
/*     */   implements Closeable
/*     */ {
/*     */   private int headerLength;
/*     */   private int frameLength;
/*     */   private final RandomAccessFile file;
/*     */   private ClientCapHeader header;
/*     */   private int playhead;
/*     */   private boolean endOfFile;
/*     */   
/*     */   public ClientCapReader(InputStream stream) throws IOException {
/*  43 */     File tempFile = File.createTempFile("client", ".ccap");
/*  44 */     OutputStream out = new BufferedOutputStream(new FileOutputStream(tempFile)); 
/*  45 */     try { stream.transferTo(out);
/*  46 */       out.close(); } catch (Throwable throwable) { try { out.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */        throw throwable; }
/*  48 */      tempFile.deleteOnExit();
/*  49 */     this.file = new RandomAccessFile(tempFile, "r");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientCapReader(RandomAccessFile file) {
/*  57 */     this.file = file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientCapReader(File file) throws FileNotFoundException {
/*  66 */     this.file = new RandomAccessFile(file, "r");
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final ClientCapHeader getHeader() {
/*  71 */     return this.header;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void readHeader() throws IOException, IllegalStateException {
/*  81 */     if (this.header != null) {
/*  82 */       throw new IllegalStateException("The header has already been read!");
/*     */     }
/*     */     
/*  85 */     CountingInputStream counter = new CountingInputStream(Channels.newInputStream(this.file.getChannel()));
/*  86 */     this.header = new ClientCapHeader();
/*  87 */     this.header.readHeader((InputStream)counter);
/*  88 */     this.frameLength = this.header.calculateFrameLength();
/*  89 */     this.headerLength = (int)counter.getCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlayhead() {
/*  99 */     return this.playhead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEndOfFile() {
/* 108 */     return this.endOfFile;
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
/*     */   public synchronized UnserializedFrame readFrame() throws IOException, NoHeaderException {
/* 120 */     assertHeaderRead();
/* 121 */     if (this.endOfFile) return new UnserializedFrame(this.header);
/*     */     
/* 123 */     Object[] channels = new Object[this.header.numChannels()];
/*     */     try {
/* 125 */       int i = 0;
/* 126 */       for (ChannelHandler<?> handler : (Iterable<ChannelHandler<?>>)this.header.getChannels()) {
/* 127 */         channels[i] = handler.getChannelType().read(this.file);
/* 128 */         i++;
/*     */       } 
/* 130 */     } catch (EOFException e) {
/* 131 */       this.endOfFile = true;
/* 132 */       return new UnserializedFrame(this.header);
/*     */     } 
/*     */     
/* 135 */     this.playhead++;
/* 136 */     return new UnserializedFrame(this.header, channels);
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
/*     */   public long getFrameOffset(int frame) throws NoHeaderException {
/* 149 */     assertHeaderRead();
/* 150 */     return frame * this.frameLength + this.headerLength;
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
/*     */   public int countFrames() throws NoHeaderException {
/*     */     try {
/* 163 */       return countFramesOrThrow();
/* 164 */     } catch (IOException e) {
/* 165 */       LogUtils.getLogger().error("Error getting length of file.", e);
/* 166 */       return -1;
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
/*     */   public synchronized int countFramesOrThrow() throws NoHeaderException, IOException {
/* 179 */     assertHeaderRead();
/* 180 */     return (int)((this.file.length() - this.headerLength) / this.frameLength);
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
/*     */   public synchronized void seek(int frame) throws NoHeaderException, IndexOutOfBoundsException, IOException {
/* 193 */     assertHeaderRead();
/* 194 */     if (frame == this.playhead)
/* 195 */       return;  if (frame < 0) {
/* 196 */       throw new IndexOutOfBoundsException(frame);
/*     */     }
/*     */     
/* 199 */     long offset = getFrameOffset(frame);
/* 200 */     this.file.seek(offset);
/* 201 */     this.endOfFile = (offset > this.file.length());
/*     */     
/* 203 */     this.playhead = frame;
/*     */   }
/*     */   
/*     */   private void assertHeaderRead() throws NoHeaderException {
/* 207 */     if (this.header == null) {
/* 208 */       throw new NoHeaderException("The header has not been read!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void close() throws IOException {
/* 219 */     this.file.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientCapReader.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */