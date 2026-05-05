/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.igrium.replayfps.ReplayFPS;
/*     */ import com.igrium.replayfps.core.events.ReplayEvents;
/*     */ import com.igrium.replayfps.core.networking.CustomReplayPacketManager;
/*     */ import com.igrium.replayfps.core.networking.FakePacketHandler;
/*     */ import com.igrium.replayfps.core.networking.FakePacketHandlers;
/*     */ import com.igrium.replayfps.core.networking.PacketRedirectors;
/*     */ import com.igrium.replayfps.core.networking.event.CustomPacketReceivedEvent;
/*     */ import com.igrium.replayfps.core.networking.event.PacketReceivedEvent;
/*     */ import com.igrium.replayfps.core.util.GlobalReplayContext;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import com.replaymod.core.Module;
/*     */ import com.replaymod.core.events.PreRenderCallback;
/*     */ import com.replaymod.lib.de.johni0702.minecraft.gui.utils.EventRegistrations;
/*     */ import com.replaymod.replay.ReplayHandler;
/*     */ import com.replaymod.replay.events.ReplayClosingCallback;
/*     */ import com.replaymod.replay.events.ReplayOpenedCallback;
/*     */ import com.replaymod.replaystudio.lib.guava.base.Optional;
/*     */ import com.replaymod.replaystudio.replay.ReplayFile;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Optional;
/*     */ import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1934;
/*     */ import net.minecraft.class_2540;
/*     */ import net.minecraft.class_2547;
/*     */ import net.minecraft.class_2596;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_638;
/*     */ import net.minecraft.class_742;
/*     */ 
/*     */ public class ClientPlaybackModule extends EventRegistrations implements Module {
/*     */   private static ClientPlaybackModule instance;
/*     */   private ReplayHandler currentReplay;
/*     */   private ClientCapPlayer currentPlayer;
/*     */   private CustomReplayPacketManager customPacketManager;
/*     */   private final class_310 client;
/*     */   private class_1934 hudGamemode;
/*     */   
/*  46 */   public ClientPlaybackModule() { this.client = class_310.method_1551();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     this.hudGamemode = class_1934.field_9215;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     on(ReplayOpenedCallback.EVENT, this::onReplayOpened);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     on(ReplayEvents.REPLAY_SETUP, this::onReplaySetup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     on(ReplayClosingCallback.EVENT, this::onReplayClosing);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     on(PreRenderCallback.EVENT, this::tickRender);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     ClientTickEvents.END_WORLD_TICK.register(this::tickClient);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     CustomPacketReceivedEvent.EVENT.register(this::onCustomPacketReceived);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     PacketReceivedEvent.EVENT.register(this::onPacketReceived); }
/*     */   public static ClientPlaybackModule getInstance() { return instance; }
/* 170 */   public void initCommon() { instance = this; } public ReplayHandler getCurrentReplay() { return this.currentReplay; } public ClientCapPlayer getCurrentPlayer() { return this.currentPlayer; } public CustomReplayPacketManager getCustomPacketManager() { return this.customPacketManager; } public void setHudGamemode(class_1934 localPlayerGamemode) { this.hudGamemode = localPlayerGamemode; } private boolean onPacketReceived(class_2596<?> packet, class_2547 l) { if (this.currentPlayer == null || this.client.field_1687 == null) return false; 
/* 171 */     class_1657 localPlayer = (class_1657)this.client.field_1687.method_8469(this.currentPlayer.getReader().getHeader().getLocalPlayerID());
/* 172 */     if (localPlayer == null) return false;
/*     */     
/* 174 */     if (PacketRedirectors.REDIRECT_QUEUED.contains(packet)) {
/* 175 */       PacketRedirectors.applyRedirect(packet, localPlayer, this.client);
/* 176 */       return true;
/*     */     } 
/* 178 */     return false; }
/*     */   public class_1934 getHudGamemode() { return this.hudGamemode; }
/*     */   private void onReplayOpened(ReplayHandler handler) { this.currentReplay = handler; this.hudGamemode = class_1934.field_9215; ReplayFile file = handler.getReplayFile(); if (!ReplayFPS.getConfig().shouldPlayClientCap()) return;  try { Optional<InputStream> opt = file.get("client.ccap"); if (!opt.isPresent()) return;  InputStream stream = new BufferedInputStream((InputStream)opt.get()); this.currentPlayer = new ClientCapPlayer(new ClientCapReader((InputStream)opt.get())); stream.close(); } catch (IOException e) { LogUtils.getLogger().error("Error loading client capture.", e); }  this.customPacketManager = new CustomReplayPacketManager(); for (FakePacketHandler<?> h : (Iterable<FakePacketHandler<?>>)FakePacketHandlers.REGISTRY.values()) this.customPacketManager.registerReceiver(h.getId(), (CustomReplayPacketManager.ReplayPacketConsumer)h);  }
/*     */   private void onReplaySetup(ReplayHandler handler) { if (this.customPacketManager != null) this.customPacketManager.clearQueue();  }
/* 182 */   private void onReplayClosing(ReplayHandler handler) { if (this.currentReplay != handler) { LogUtils.getLogger().warn("Client playback module had the wrong replay when close event was fired. This should not happen."); return; }  this.currentReplay = null; if (this.currentPlayer != null) { try { this.currentPlayer.close(); } catch (IOException e) { LogUtils.getLogger().error("Error closing client capture.", e); }  this.currentPlayer = null; }  this.customPacketManager = null; } private void tickRender() { if (this.currentPlayer == null || this.client.field_1687 == null || this.client.method_1560() == null) return;  int timestamp = this.currentReplay.getReplaySender().currentTimeStamp(); ClientPlaybackContext context = genContext(timestamp); if (!Objects.equals(this.client.method_1560(), context.localPlayer().orElse(null))) return;  this.currentPlayer.tickPlayer(genContext(timestamp)); } private void tickClient(class_638 world) { if (this.currentPlayer == null) { GlobalReplayContext.ENTITY_POS_OVERRIDES.clear(); return; }  ClientPlaybackContext context = genContext(this.currentReplay.getReplaySender().currentTimeStamp()); this.currentPlayer.tickClient(context); if (this.client.field_1719.equals(context.localPlayer().orElse(null)) && this.customPacketManager != null) this.customPacketManager.flushQueue(this.client, (class_1657)context.localPlayer().get());  } private boolean onCustomPacketReceived(class_2960 channel, class_2540 payload) { if (this.customPacketManager != null) return this.customPacketManager.onPacketReceived(channel, payload);  return false; } private ClientPlaybackContext genContext(int timestamp) { return new ClientPlaybackContextImpl(this.client, this.currentReplay, timestamp, this.currentPlayer.getReader().getHeader().getLocalPlayerID()); }
/*     */ 
/*     */   
/*     */   private static class ClientPlaybackContextImpl
/*     */     implements ClientPlaybackContext
/*     */   {
/*     */     final class_310 client;
/*     */     final ReplayHandler handler;
/*     */     final int timestamp;
/*     */     final class_742 localPlayer;
/*     */     
/*     */     public ClientPlaybackContextImpl(class_310 client, ReplayHandler handler, int timestamp, int localPlayerId) {
/* 194 */       this.client = client;
/* 195 */       this.handler = handler;
/* 196 */       this.timestamp = timestamp;
/* 197 */       if (client.field_1687 != null) {
/* 198 */         this.localPlayer = (class_742)client.field_1687.method_8469(localPlayerId);
/*     */       } else {
/* 200 */         this.localPlayer = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public class_310 client() {
/* 206 */       return this.client;
/*     */     }
/*     */ 
/*     */     
/*     */     public ReplayHandler replayHandler() {
/* 211 */       return this.handler;
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<class_1297> cameraEntity() {
/* 216 */       return Optional.ofNullable(this.client.field_1719);
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<class_742> localPlayer() {
/* 221 */       return Optional.ofNullable(this.localPlayer);
/*     */     }
/*     */ 
/*     */     
/*     */     public class_4184 camera() {
/* 226 */       return this.client.field_1773.method_19418();
/*     */     }
/*     */ 
/*     */     
/*     */     public int timestamp() {
/* 231 */       return this.timestamp;
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<class_638> world() {
/* 236 */       return Optional.ofNullable(this.client.field_1687);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientPlaybackModule.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */