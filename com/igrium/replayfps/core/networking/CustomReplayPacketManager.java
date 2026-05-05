/*     */ package com.igrium.replayfps.core.networking;
/*     */ 
/*     */ import com.igrium.replayfps.core.mixin.ClientConnectionAccessor;
/*     */ import com.igrium.replayfps.core.util.PlaybackUtils;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.Channel;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedDeque;
/*     */ import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_2540;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2658;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_634;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomReplayPacketManager
/*     */ {
/*     */   public static final String PREFIX = "rp_";
/*     */   
/*     */   public static interface ReplayPacketConsumer
/*     */   {
/*     */     void onPacket(class_310 param1class_310, class_2540 param1class_2540, class_1657 param1class_1657) throws Exception;
/*     */   }
/*     */   
/*     */   protected static final class CachedValue
/*     */     extends Record
/*     */   {
/*     */     private final FakePacketHandler<?> handler;
/*     */     private final Object val;
/*     */     
/*     */     protected CachedValue(FakePacketHandler<?> handler, Object val) {
/*  41 */       this.handler = handler; this.val = val; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #41	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #41	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #41	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;
/*  41 */       //   0	8	1	o	Ljava/lang/Object; } public FakePacketHandler<?> handler() { return this.handler; } public Object val() { return this.val; }
/*     */      }
/*  43 */   protected final Map<class_2960, ReplayPacketConsumer> listeners = new HashMap<>();
/*  44 */   protected final Queue<CachedValue> queue = new ConcurrentLinkedDeque<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onPacketReceived(class_2960 channel, class_2540 nettyPayload) {
/*  55 */     if (!channel.method_12836().startsWith("rp_")) {
/*  56 */       return false;
/*     */     }
/*  58 */     class_310 client = class_310.method_1551();
/*  59 */     class_2540 payload = PacketByteBufs.copy((ByteBuf)nettyPayload);
/*     */     
/*  61 */     String namespace = channel.method_12836().substring("rp_".length());
/*  62 */     class_2960 finalID = new class_2960(namespace, channel.method_12832());
/*     */ 
/*     */     
/*  65 */     ReplayPacketConsumer receiver = this.listeners.get(finalID);
/*     */     
/*  67 */     if (receiver == null) {
/*  68 */       LogUtils.getLogger().warn("Unknown replay packet channel: " + finalID);
/*  69 */       return true;
/*     */     } 
/*     */     
/*  72 */     if (receiver instanceof FakePacketHandler) { FakePacketHandler<?> handler = (FakePacketHandler)receiver;
/*  73 */       onFakePacketReceived(client, handler, payload); }
/*     */     else
/*  75 */     { client.execute(() -> {
/*     */             try {
/*     */               receiver.onPacket(client, payload, null);
/*  78 */             } catch (Exception e) {
/*     */               LogUtils.getLogger().error("Error applying custom replay packet: " + finalID, e);
/*     */             } 
/*     */           }); }
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
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   private <T> void onFakePacketReceived(class_310 client, FakePacketHandler<T> handler, class_2540 buffer) {
/* 125 */     T val = handler.parse(buffer);
/*     */     
/* 127 */     client.execute(() -> {
/*     */           FakePacketHandler.SpectatorBehavior spectatorBehavior = handler.getSpectatorBehavior();
/*     */           class_1657 localPlayer = PlaybackUtils.getCurrentPlaybackPlayer();
/*     */           if (localPlayer == null)
/*     */             return; 
/* 132 */           boolean shouldRun = (localPlayer.equals(client.field_1719) || spectatorBehavior == FakePacketHandler.SpectatorBehavior.APPLY);
/*     */           if (shouldRun) {
/*     */             handler.apply(val, client, localPlayer);
/*     */           } else if (spectatorBehavior == FakePacketHandler.SpectatorBehavior.QUEUE) {
/*     */             this.queue.add(new CachedValue(handler, val));
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearQueue() {
/* 144 */     this.queue.clear();
/*     */   }
/*     */   
/*     */   public void flushQueue(class_310 client, class_1657 localPlayer) {
/* 148 */     class_310.method_1551().execute(() -> {
/*     */           CachedValue cached;
/*     */           while ((cached = this.queue.poll()) != null) {
/*     */             cached.handler.castAndApply(cached.val, client, localPlayer);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void registerReceiver(class_2960 id, ReplayPacketConsumer receiver) {
/* 157 */     this.listeners.put(id, receiver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendReplayPacket(class_2960 id, class_2540 payload) {
/* 166 */     class_310 client = class_310.method_1551();
/* 167 */     class_634 netHandler = client.method_1562();
/* 168 */     if (netHandler == null) {
/* 169 */       throw new IllegalStateException("Replay packets can only be sent while a game is active.");
/*     */     }
/*     */     
/* 172 */     class_2658 packet = new class_2658(new class_2960("rp_" + id.method_12836(), id.method_12832()), payload);
/* 173 */     sendFakePacket((class_2596<?>)packet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendFakePacket(class_2596<?> packet) {
/* 182 */     class_310 client = class_310.method_1551();
/* 183 */     class_634 netHandler = client.method_1562();
/* 184 */     if (netHandler == null) {
/* 185 */       throw new IllegalStateException("Replay packets can only be sent while a game is active.");
/*     */     }
/*     */     
/* 188 */     if (PlaybackUtils.isPlayingReplay()) {
/*     */       return;
/*     */     }
/*     */     
/* 192 */     Channel channel = ((ClientConnectionAccessor)netHandler.method_48296()).replayfps$getChannel();
/* 193 */     if (channel.eventLoop().inEventLoop()) {
/* 194 */       sendFakePacketInternal(channel, packet);
/*     */     } else {
/* 196 */       channel.eventLoop().execute(() -> sendFakePacketInternal(channel, packet));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void sendFakePacketInternal(Channel channel, class_2596<?> packet) {
/* 201 */     channel.pipeline().fireChannelRead(packet);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\CustomReplayPacketManager.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */