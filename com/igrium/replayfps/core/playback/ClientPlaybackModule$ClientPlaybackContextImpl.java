/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.replaymod.replay.ReplayHandler;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_638;
/*     */ import net.minecraft.class_742;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ClientPlaybackContextImpl
/*     */   implements ClientPlaybackContext
/*     */ {
/*     */   final class_310 client;
/*     */   final ReplayHandler handler;
/*     */   final int timestamp;
/*     */   final class_742 localPlayer;
/*     */   
/*     */   public ClientPlaybackContextImpl(class_310 client, ReplayHandler handler, int timestamp, int localPlayerId) {
/* 194 */     this.client = client;
/* 195 */     this.handler = handler;
/* 196 */     this.timestamp = timestamp;
/* 197 */     if (client.field_1687 != null) {
/* 198 */       this.localPlayer = (class_742)client.field_1687.method_8469(localPlayerId);
/*     */     } else {
/* 200 */       this.localPlayer = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public class_310 client() {
/* 206 */     return this.client;
/*     */   }
/*     */ 
/*     */   
/*     */   public ReplayHandler replayHandler() {
/* 211 */     return this.handler;
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<class_1297> cameraEntity() {
/* 216 */     return Optional.ofNullable(this.client.field_1719);
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<class_742> localPlayer() {
/* 221 */     return Optional.ofNullable(this.localPlayer);
/*     */   }
/*     */ 
/*     */   
/*     */   public class_4184 camera() {
/* 226 */     return this.client.field_1773.method_19418();
/*     */   }
/*     */ 
/*     */   
/*     */   public int timestamp() {
/* 231 */     return this.timestamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<class_638> world() {
/* 236 */     return Optional.ofNullable(this.client.field_1687);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientPlaybackModule$ClientPlaybackContextImpl.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */