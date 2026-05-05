/*     */ package com.igrium.replayfps.core.recording;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.channel.ChannelHandlers;
/*     */ import com.igrium.replayfps.core.events.ChannelRegistrationCallback;
/*     */ import com.igrium.replayfps.core.events.RecordingEvents;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import com.replaymod.core.Module;
/*     */ import com.replaymod.core.ReplayMod;
/*     */ import com.replaymod.lib.de.johni0702.minecraft.gui.utils.EventRegistrations;
/*     */ import com.replaymod.recording.packet.PacketListener;
/*     */ import com.replaymod.replaystudio.replay.ReplayFile;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.fabricmc.api.Environment;
/*     */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
/*     */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_638;
/*     */ import net.minecraft.class_746;
/*     */ import net.minecraft.class_757;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ public class ClientRecordingModule
/*     */   extends EventRegistrations
/*     */   implements Module
/*     */ {
/*     */   public static final String ENTRY = "client.ccap";
/*     */   private static ClientRecordingModule instance;
/*     */   private final ReplayMod replayMod;
/*     */   
/*     */   public static ClientRecordingModule getInstance() {
/*  39 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  44 */   private Optional<ClientCapRecorder> activeRecording = Optional.empty();
/*     */ 
/*     */   
/*     */   private ClientCapHeader queuedHeader;
/*     */ 
/*     */   
/*     */   public ReplayMod getReplayMod() {
/*  51 */     return this.replayMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initCommon() {
/*  56 */     instance = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void register() {
/*  61 */     super.register();
/*  62 */     WorldRenderEvents.END.register(this::onFrame);
/*     */   }
/*     */   
/*     */   public ClientRecordingModule(ReplayMod replayMod)
/*     */   {
/*  67 */     on(RecordingEvents.STARTED_RECORDING, this::onStartedRecording);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     on(RecordingEvents.STOP_RECORDING, this::onStoppingRecording);
/*     */     this.replayMod = replayMod; }
/*  93 */   protected void onStoppingRecording(PacketListener listener, ReplayFile file) { if (isRecording()) stopRecording();
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onFrame(WorldRenderContext context) {
/* 108 */     if (this.activeRecording.isPresent())
/* 109 */     { ClientCapRecorder recording = this.activeRecording.get();
/* 110 */       ClientCaptureContext clientContext = new ClientCaptureContextImpl(context, class_310.method_1551());
/*     */       
/* 112 */       if (recording.getHeader() == null) {
/* 113 */         initRecording(recording, clientContext.localPlayer().method_5628());
/*     */       }
/* 115 */       recording.tick(clientContext); } 
/*     */   } protected void onStartedRecording(PacketListener listener, ReplayFile file) { List<ChannelHandler<?>> channels = new LinkedList<>(); ((ChannelRegistrationCallback)ChannelRegistrationCallback.EVENT.invoker()).createChannels(handler -> { if (!ChannelHandlers.REGISTRY.inverse().containsKey(handler))
/*     */             throw new IllegalArgumentException("The supplied channel handler has not been registered!");  channels.add(handler);
/*     */         }); LogUtils.getLogger().info("Starting client-cap recording!"); ClientCapHeader header = new ClientCapHeader(channels); try { OutputStream out = file.write("client.ccap"); ClientCapRecorder recorder = new ClientCapRecorder(out, listener); this.activeRecording = Optional.of(recorder); this.queuedHeader = header; LogUtils.getLogger().info("Header has %d channels".formatted(new Object[] { Integer.valueOf(channels.size()) })); }
/*     */     catch (Exception e) { LogUtils.getLogger().error("Unable to initialize client-cap recording.", e); }
/* 120 */      } private void initRecording(ClientCapRecorder recording, int localPlayerId) { this.queuedHeader.setLocalPlayerID(localPlayerId);
/* 121 */     recording.writeHeader(this.queuedHeader);
/* 122 */     recording.startRecording(); }
/*     */ 
/*     */   
/*     */   public Optional<ClientCapRecorder> getActiveRecording() {
/* 126 */     return this.activeRecording;
/*     */   }
/*     */   
/*     */   public boolean isRecording() {
/* 130 */     return this.activeRecording.isPresent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopRecording() throws IllegalStateException {
/* 138 */     if (!isRecording()) {
/* 139 */       throw new IllegalStateException("We are not recording.");
/*     */     }
/*     */     
/*     */     try {
/* 143 */       ((ClientCapRecorder)this.activeRecording.get()).close();
/* 144 */     } catch (IOException e) {
/* 145 */       LogUtils.getLogger().error("Error closing recording stream.", e);
/*     */     } 
/* 147 */     this.activeRecording = Optional.empty();
/*     */   }
/*     */   
/*     */   private static class ClientCaptureContextImpl
/*     */     implements ClientCaptureContext {
/*     */     private final WorldRenderContext renderContext;
/*     */     private final class_310 client;
/*     */     
/*     */     public ClientCaptureContextImpl(WorldRenderContext renderContext, class_310 client) {
/* 156 */       this.renderContext = renderContext;
/* 157 */       this.client = client;
/*     */     }
/*     */ 
/*     */     
/*     */     public class_310 client() {
/* 162 */       return this.client;
/*     */     }
/*     */ 
/*     */     
/*     */     public float tickDelta() {
/* 167 */       return this.renderContext.tickDelta();
/*     */     }
/*     */ 
/*     */     
/*     */     public class_1297 cameraEntity() {
/* 172 */       return this.client.field_1719;
/*     */     }
/*     */ 
/*     */     
/*     */     public class_4184 camera() {
/* 177 */       return this.renderContext.camera();
/*     */     }
/*     */ 
/*     */     
/*     */     public class_746 localPlayer() {
/* 182 */       return this.client.field_1724;
/*     */     }
/*     */ 
/*     */     
/*     */     public class_757 gameRenderer() {
/* 187 */       return this.renderContext.gameRenderer();
/*     */     }
/*     */ 
/*     */     
/*     */     public class_638 world() {
/* 192 */       return this.renderContext.world();
/*     */     }
/*     */ 
/*     */     
/*     */     public WorldRenderContext renderContext() {
/* 197 */       return this.renderContext;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientRecordingModule.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */