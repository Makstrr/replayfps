/*    */ package com.igrium.replayfps;
/*    */ 
/*    */ import com.igrium.replayfps.config.ReplayFPSConfig;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import com.igrium.replayfps.core.recording.ClientRecordingModule;
/*    */ import com.igrium.replayfps.core.util.ReplayModHooks;
/*    */ import com.igrium.replayfps.game.BullshitPlayerInventoryManager;
/*    */ import com.igrium.replayfps.game.channel.DefaultChannelHandlers;
/*    */ import com.igrium.replayfps.game.networking.DefaultFakePackets;
/*    */ import com.igrium.replayfps.game.networking.DefaultPacketRedirectors;
/*    */ import com.replaymod.core.ReplayMod;
/*    */ import net.fabricmc.api.ModInitializer;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class ReplayFPS
/*    */   implements ModInitializer {
/* 18 */   public static final Logger LOGGER = LoggerFactory.getLogger("ReplayFPS");
/*    */   private static ReplayFPS instance;
/*    */   private ReplayFPSConfig config;
/*    */   
/*    */   public static ReplayFPS getInstance() {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */   private ClientRecordingModule clientRecordingModule;
/*    */   
/*    */   public ReplayFPSConfig config() {
/* 29 */     return this.config;
/*    */   }
/*    */   private ClientPlaybackModule clientPlaybackModule;
/*    */   public static ReplayFPSConfig getConfig() {
/* 33 */     return getInstance().config();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ClientRecordingModule getClientRecordingModule() {
/* 39 */     return this.clientRecordingModule;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ClientPlaybackModule getClientPlaybackModule() {
/* 45 */     return this.clientPlaybackModule;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onInitialize() {
/* 50 */     instance = this;
/* 51 */     this.config = ReplayFPSConfig.load();
/*    */     
/* 53 */     ReplayModHooks.onReplayModInit(mod -> {
/*    */           this.clientRecordingModule = new ClientRecordingModule(mod);
/*    */           
/*    */           this.clientRecordingModule.initCommon();
/*    */           
/*    */           this.clientRecordingModule.initClient();
/*    */           this.clientRecordingModule.register();
/*    */           this.clientPlaybackModule = new ClientPlaybackModule();
/*    */           this.clientPlaybackModule.initCommon();
/*    */           this.clientPlaybackModule.initClient();
/*    */           this.clientPlaybackModule.register();
/*    */         });
/* 65 */     DefaultChannelHandlers.registerDefaults();
/* 66 */     DefaultPacketRedirectors.registerDefaults();
/* 67 */     DefaultFakePackets.registerDefaults();
/*    */     
/* 69 */     BullshitPlayerInventoryManager.register();
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\ReplayFPS.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */