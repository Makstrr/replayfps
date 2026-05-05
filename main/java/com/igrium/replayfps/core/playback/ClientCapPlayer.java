/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.util.AnimationUtils;
/*     */ import com.igrium.replayfps.core.util.ConcurrentBuffer;
/*     */ import com.igrium.replayfps.core.util.GlobalReplayContext;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_742;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ public class ClientCapPlayer
/*     */   implements Closeable {
/*     */   private final ClientCapReader reader;
/*  22 */   private int lastFrameAIndex = -1;
/*  23 */   private int lastFrameBIndex = -1;
/*     */ 
/*     */   
/*     */   private UnserializedFrame lastFrameA;
/*     */ 
/*     */   
/*     */   private UnserializedFrame lastFrameB;
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private UnserializedFrame lastFrame;
/*     */ 
/*     */   
/*     */   private ClientCapBuffer buffer;
/*     */ 
/*     */   
/*     */   private Optional<Exception> error;
/*     */ 
/*     */   
/*     */   private ChannelValueCache valueCache;
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientCapReader getReader() {
/*  47 */     return this.reader;
/*     */   }
/*     */   
/*  50 */   public ClientCapPlayer(ClientCapReader reader) throws IOException { this.error = Optional.empty();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.valueCache = new ChannelValueCache();
/*     */     this.reader = reader;
/*     */     if (reader.getHeader() == null)
/*     */       reader.readHeader(); 
/*     */     this.buffer = ClientCapBuffer.create(reader); }
/*     */   
/*     */   public void tickPlayer(ClientPlaybackContext context) {
/*  67 */     if (hasErrored())
/*     */       return; 
/*  69 */     int frameNumber = -1;
/*     */     try {
/*     */       float delta;
/*  72 */       int timestamp = context.timestamp();
/*  73 */       int framerate = this.reader.getHeader().getFramerate();
/*  74 */       int framerateBase = this.reader.getHeader().getFramerateBase();
/*     */       
/*  76 */       frameNumber = AnimationUtils.countFrames(timestamp, framerate, framerateBase);
/*     */       
/*  78 */       if (frameNumber < 0)
/*     */         return; 
/*  80 */       long prevFrameTime = AnimationUtils.getDuration(frameNumber, framerate, framerateBase);
/*  81 */       long nextFrameTime = AnimationUtils.getDuration(frameNumber + 1, framerate, framerateBase);
/*     */ 
/*     */       
/*  84 */       if (nextFrameTime == prevFrameTime) {
/*  85 */         delta = 0.0F;
/*     */       } else {
/*  87 */         delta = (float)(timestamp - prevFrameTime) / (float)(nextFrameTime - prevFrameTime);
/*     */       } 
/*     */       
/*  90 */       UnserializedFrame prevFrame = getFrame(frameNumber, true);
/*  91 */       UnserializedFrame nextFrame = getFrame(frameNumber + 1, true);
/*     */ 
/*     */       
/*  94 */       this.lastFrameAIndex = frameNumber;
/*  95 */       this.lastFrameA = prevFrame;
/*     */       
/*  97 */       this.lastFrameBIndex = frameNumber + 1;
/*  98 */       this.lastFrameB = nextFrame;
/*     */       
/* 100 */       if (context.localPlayer().isPresent() && ((class_742)context
/* 101 */         .localPlayer().get()).equals((class_310.method_1551()).field_1719)) {
/* 102 */         for (Map.Entry<ChannelHandler<?>, Object> entry : prevFrame.getValues().entrySet()) {
/* 103 */           Object other = (nextFrame != null) ? nextFrame.getValue(entry.getKey()) : null;
/* 104 */           interpolateAndApply(entry.getKey(), entry.getValue(), other, delta, context);
/*     */         } 
/*     */       } else {
/* 107 */         GlobalReplayContext.ENTITY_POS_OVERRIDES.clear();
/*     */       }
/*     */     
/* 110 */     } catch (Exception e) {
/* 111 */       LogUtils.getLogger().error("An error occured while reading animation frame " + frameNumber, e);
/* 112 */       this.error = Optional.of(e);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Optional<Exception> getError() {
/*     */     return this.error;
/*     */   }
/*     */   
/*     */   public void tickClient(ClientPlaybackContext context) {
/*     */     try {
/* 124 */       for (Map.Entry<ChannelHandler<?>, Object> entry : this.valueCache.map().entrySet()) {
/* 125 */         castAndApplyChannel(entry.getKey(), entry.getValue(), context);
/*     */       }
/* 127 */     } catch (Exception e) {
/* 128 */       LogUtils.getLogger().error("An error occured while applying a cached channel value.", e);
/* 129 */       this.error = Optional.of(e);
/*     */     } finally {
/* 131 */       this.valueCache.clear();
/*     */     } 
/*     */   } public boolean hasErrored() {
/*     */     return this.error.isPresent();
/*     */   }
/*     */   private <T> void castAndApplyChannel(ChannelHandler<T> handler, Object value, ClientPlaybackContext context) throws Exception {
/* 137 */     handler.apply(handler.getType().cast(value), context);
/*     */   }
/*     */   
/*     */   private UnserializedFrame getFrame(int index, boolean poll) {
/* 141 */     if (index == this.lastFrameAIndex && this.lastFrameA != null)
/* 142 */       return this.lastFrameA; 
/* 143 */     if (index == this.lastFrameBIndex && this.lastFrameB != null) {
/* 144 */       return this.lastFrameB;
/*     */     }
/* 146 */     if (index != this.buffer.getIndex()) {
/* 147 */       this.buffer.seek(index);
/* 148 */       LogUtils.getLogger().info("Seeking frame " + index);
/*     */     } 
/*     */     
/* 151 */     return poll ? (UnserializedFrame)this.buffer.poll() : (UnserializedFrame)this.buffer.peek();
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> void interpolateAndApply(ChannelHandler<T> handler, Object value, @Nullable Object value2, float delta, ClientPlaybackContext context) throws Exception, ClassCastException {
/* 156 */     if (value == null)
/*     */       return; 
/* 158 */     T casted = handler.getType().cast(value);
/*     */     
/* 160 */     if (delta < 0.0F) delta = 0.0F; 
/* 161 */     if (delta > 1.0F) delta = 1.0F;
/*     */     
/* 163 */     if (handler.shouldInterpolate() && value2 != null) {
/* 164 */       T casted2 = handler.getType().cast(value2);
/* 165 */       applyChannelOrCache(handler, (T)handler.getChannelType().interpolate(casted, casted2, delta), context);
/*     */     } else {
/*     */       
/* 168 */       applyChannelOrCache(handler, casted, context);
/*     */     } 
/*     */   }
/*     */   
/*     */   private <T> void applyChannelOrCache(ChannelHandler<T> handler, T value, ClientPlaybackContext context) throws Exception {
/* 173 */     if (handler.applyPerTick()) {
/* 174 */       this.valueCache.put(handler, value);
/*     */     } else {
/* 176 */       handler.apply(value, context);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 186 */     this.reader.close();
/* 187 */     this.buffer.close();
/*     */   }
/*     */   
/*     */   public static class ClientCapBuffer
/*     */     extends ConcurrentBuffer<UnserializedFrame> implements Closeable {
/* 192 */     private ExecutorService executor = Executors.newSingleThreadExecutor();
/*     */     private final ClientCapReader reader;
/*     */     
/*     */     public ClientCapBuffer(ExecutorService executor, ClientCapReader reader) {
/* 196 */       super(executor);
/* 197 */       this.executor = executor;
/* 198 */       this.reader = reader;
/*     */     }
/*     */ 
/*     */     
/*     */     public ExecutorService getExecutor() {
/* 203 */       return this.executor;
/*     */     }
/*     */ 
/*     */     
/*     */     protected UnserializedFrame load(int index) throws Exception {
/* 208 */       if (index != this.reader.getPlayhead()) {
/* 209 */         this.reader.seek(index);
/*     */       }
/* 211 */       return this.reader.readFrame();
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() {
/* 216 */       this.executor.shutdown();
/*     */     }
/*     */     
/*     */     public static ClientCapBuffer create(ClientCapReader reader) {
/* 220 */       return new ClientCapBuffer(Executors.newSingleThreadExecutor(r -> new Thread(r, "ClientCap Buffer")), reader);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientCapPlayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */