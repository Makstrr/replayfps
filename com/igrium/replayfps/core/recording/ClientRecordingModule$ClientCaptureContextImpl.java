/*     */ package com.igrium.replayfps.core.recording;
/*     */ 
/*     */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_638;
/*     */ import net.minecraft.class_746;
/*     */ import net.minecraft.class_757;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ClientCaptureContextImpl
/*     */   implements ClientCaptureContext
/*     */ {
/*     */   private final WorldRenderContext renderContext;
/*     */   private final class_310 client;
/*     */   
/*     */   public ClientCaptureContextImpl(WorldRenderContext renderContext, class_310 client) {
/* 156 */     this.renderContext = renderContext;
/* 157 */     this.client = client;
/*     */   }
/*     */ 
/*     */   
/*     */   public class_310 client() {
/* 162 */     return this.client;
/*     */   }
/*     */ 
/*     */   
/*     */   public float tickDelta() {
/* 167 */     return this.renderContext.tickDelta();
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1297 cameraEntity() {
/* 172 */     return this.client.field_1719;
/*     */   }
/*     */ 
/*     */   
/*     */   public class_4184 camera() {
/* 177 */     return this.renderContext.camera();
/*     */   }
/*     */ 
/*     */   
/*     */   public class_746 localPlayer() {
/* 182 */     return this.client.field_1724;
/*     */   }
/*     */ 
/*     */   
/*     */   public class_757 gameRenderer() {
/* 187 */     return this.renderContext.gameRenderer();
/*     */   }
/*     */ 
/*     */   
/*     */   public class_638 world() {
/* 192 */     return this.renderContext.world();
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldRenderContext renderContext() {
/* 197 */     return this.renderContext;
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientRecordingModule$ClientCaptureContextImpl.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */