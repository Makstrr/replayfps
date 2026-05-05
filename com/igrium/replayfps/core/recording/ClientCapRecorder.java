/*     */ package com.igrium.replayfps.core.recording;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.playback.UnserializedFrame;
/*     */ import com.igrium.replayfps.core.util.AnimationUtils;
/*     */ import com.igrium.replayfps.core.util.NoHeaderException;
/*     */ import com.igrium.replayfps.core.util.TimecodeProvider;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import com.replaymod.recording.packet.PacketListener;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Optional;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientCapRecorder
/*     */   implements Closeable
/*     */ {
/*  24 */   private static final Logger LOGGER = LogUtils.getLogger();
/*     */   
/*     */   private final BufferedOutputStream out;
/*     */   
/*     */   private final ClientCapWriter writer;
/*     */   
/*     */   private final PacketListener packetListener;
/*     */   
/*     */   @Nullable
/*     */   private ClientCapHeader header;
/*  34 */   private int saveInterval = 512; private int framesSinceLastSave; private boolean isRecording; private Optional<Exception> error;
/*     */   
/*     */   public int getSaveInterval() {
/*  37 */     return this.saveInterval;
/*     */   }
/*     */   
/*     */   public void setSaveInterval(int saveInterval) {
/*  41 */     this.saveInterval = saveInterval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PacketListener getPacketListener() {
/*  51 */     return this.packetListener;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public ClientCapHeader getHeader() {
/*  56 */     return this.header;
/*     */   }
/*     */   
/*     */   public ClientCapWriter getWriter() {
/*  60 */     return this.writer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeHeader(ClientCapHeader header) throws IllegalStateException {
/*  69 */     if (this.header != null) {
/*  70 */       throw new IllegalStateException("Header has already been written.");
/*     */     }
/*     */     
/*  73 */     this.header = header;
/*     */     try {
/*  75 */       header.writeHeader(this.out);
/*  76 */       this.out.flush();
/*  77 */     } catch (IOException e) {
/*  78 */       LOGGER.error("Error writing clientcap header. Recording will be aborted.", e);
/*  79 */       this.error = Optional.of(e);
/*     */       return;
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
/*     */   public UnserializedFrame captureFrame(ClientCaptureContext context) throws Exception {
/*  94 */     assertHeaderWritten();
/*  95 */     Object[] values = new Object[this.header.numChannels()];
/*     */     
/*  97 */     int i = 0;
/*  98 */     for (ChannelHandler<?> handler : this.header.getChannels()) {
/*  99 */       values[i] = handler.capture(context);
/* 100 */       i++;
/*     */     } 
/*     */     
/* 103 */     return new UnserializedFrame(this.header, values);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected UnserializedFrame writeFrame(ClientCaptureContext context) throws Exception {
/* 109 */     assertHeaderWritten();
/*     */     
/* 111 */     UnserializedFrame frame = captureFrame(context);
/* 112 */     this.writer.writeFrame(frame);
/*     */     
/* 114 */     this.framesSinceLastSave++;
/* 115 */     if (this.framesSinceLastSave > this.saveInterval) {
/* 116 */       this.out.flush();
/* 117 */       this.framesSinceLastSave = 0;
/*     */     } 
/*     */     
/* 120 */     return frame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRecording() {
/* 127 */     return this.isRecording;
/*     */   }
/*     */   
/*     */   public void startRecording() throws IllegalStateException {
/* 131 */     if (this.isRecording) throw new IllegalStateException("We are already recording."); 
/* 132 */     this.isRecording = true;
/*     */   }
/*     */   
/* 135 */   public ClientCapRecorder(OutputStream out, PacketListener packetListener) { this.error = Optional.empty(); this.out = new BufferedOutputStream(out);
/*     */     this.writer = new ClientCapWriter(out);
/* 137 */     this.packetListener = packetListener; } public Optional<Exception> getError() { return this.error; }
/*     */ 
/*     */   
/*     */   public boolean hasErrored() {
/* 141 */     return this.error.isPresent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tick(ClientCaptureContext context) {
/* 149 */     if (this.header == null || !this.isRecording)
/* 150 */       return;  if (hasErrored()) {
/*     */       return;
/*     */     }
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
/* 166 */     if (((TimecodeProvider)this.packetListener).getServerWasPaused()) {
/*     */       return;
/*     */     }
/*     */     
/* 170 */     long timeRecording = System.currentTimeMillis() - ((TimecodeProvider)this.packetListener).getStartTime();
/* 171 */     long timestamp = timeRecording - ((TimecodeProvider)this.packetListener).getTimePassedWhilePaused();
/*     */     
/* 173 */     int currentFrame = AnimationUtils.countFrames((int)timestamp, this.header.getFramerate(), this.header.getFramerateBase());
/*     */     
/* 175 */     int framesToCapture = currentFrame - this.writer.getWrittenFrames();
/*     */     
/* 177 */     if (framesToCapture > 100) {
/* 178 */       LOGGER.warn("%d frames have been captured on this tick. This might be a mistake.".formatted(new Object[] { Integer.valueOf(framesToCapture) }));
/*     */     }
/*     */     
/* 181 */     if (framesToCapture < 0) {
/* 182 */       LOGGER.warn(String.format("More frames have been captured than the current timestamp suggests. (%d > %d)", new Object[] {
/* 183 */               Integer.valueOf(this.writer.getWrittenFrames()), Integer.valueOf(currentFrame)
/*     */             }));
/*     */     }
/* 186 */     for (int i = 0; i < framesToCapture; i++) {
/*     */       try {
/* 188 */         writeFrame(context);
/* 189 */       } catch (Exception e) {
/* 190 */         LOGGER.error(String.format("Error capturing frame %d. Capture will be aborted.", new Object[] {
/* 191 */                 Integer.valueOf(this.writer.getWrittenFrames()) }), e);
/* 192 */         this.error = Optional.of(e);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void assertHeaderWritten() throws NoHeaderException {
/* 199 */     if (this.header == null) {
/* 200 */       throw new NoHeaderException("Header has not been written.");
/*     */     }
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 205 */     this.out.flush();
/* 206 */     this.out.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientCapRecorder.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */