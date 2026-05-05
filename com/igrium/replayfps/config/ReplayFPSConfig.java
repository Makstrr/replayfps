/*     */ package com.igrium.replayfps.config;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.igrium.replayfps.ReplayFPS;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
/*     */ import me.shedaniel.clothconfig2.api.ConfigBuilder;
/*     */ import me.shedaniel.clothconfig2.api.ConfigCategory;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_437;
/*     */ 
/*     */ 
/*     */ public final class ReplayFPSConfig
/*     */ {
/*  21 */   private static Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
/*     */ 
/*     */   
/*     */   public static final String CONFIG_FILE = "config/replayfps.json";
/*     */   
/*     */   private boolean playClientCap = true;
/*     */ 
/*     */   
/*     */   public boolean shouldPlayClientCap() {
/*  30 */     return this.playClientCap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayClientCap(boolean playClientCap) {
/*  37 */     this.playClientCap = playClientCap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean drawHud = false;
/*     */ 
/*     */   
/*     */   public boolean shouldDrawHud() {
/*  46 */     return this.drawHud;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawHud(boolean drawHud) {
/*  53 */     this.drawHud = drawHud;
/*     */   }
/*     */   
/*     */   private boolean drawHotbar = true;
/*     */   
/*     */   public boolean shouldDrawHotbar() {
/*  59 */     return this.drawHotbar;
/*     */   }
/*     */   
/*     */   public void setDrawHotbar(boolean drawHotbar) {
/*  63 */     this.drawHotbar = drawHotbar;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class_437 getScreen(class_437 parent) {
/*  69 */     ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle((class_2561)class_2561.method_43471("title.replayfps.config"));
/*     */ 
/*     */     
/*  72 */     ConfigCategory general = builder.getOrCreateCategory((class_2561)class_2561.method_43471("category.replayfps.general"));
/*  73 */     general.addEntry((AbstractConfigListEntry)builder.entryBuilder().startBooleanToggle((class_2561)class_2561.method_43471("option.replayfps.use_clientcap"), this.playClientCap)
/*  74 */         .setDefaultValue(true)
/*  75 */         .setTooltip(new class_2561[] { (class_2561)class_2561.method_43471("option.replayfps.use_clientcap.tooltip")
/*  76 */           }).setSaveConsumer(val -> setPlayClientCap(val.booleanValue()))
/*  77 */         .build());
/*     */     
/*  79 */     ConfigCategory hud = builder.getOrCreateCategory((class_2561)class_2561.method_43471("category.replayfps.hud"));
/*  80 */     hud.addEntry((AbstractConfigListEntry)builder.entryBuilder().startBooleanToggle((class_2561)class_2561.method_43471("option.replayfps.drawhud"), this.drawHud)
/*  81 */         .setDefaultValue(false)
/*  82 */         .setTooltip(new class_2561[] { class_2561.method_30163("option.replayfps.drawhud.tooltip")
/*  83 */           }).setSaveConsumer(val -> setDrawHud(val.booleanValue()))
/*  84 */         .build());
/*     */     
/*  86 */     hud.addEntry((AbstractConfigListEntry)builder.entryBuilder().startBooleanToggle((class_2561)class_2561.method_43471("option.replayfps.drawhotbar"), this.drawHotbar)
/*  87 */         .setDefaultValue(true)
/*  88 */         .setTooltip(new class_2561[] { (class_2561)class_2561.method_43471("option.replayfps.drawhotbar.tooltip")
/*  89 */           }).setSaveConsumer(val -> setDrawHotbar(val.booleanValue()))
/*  90 */         .build());
/*     */     
/*  92 */     builder.setSavingRunnable(this::save);
/*     */     
/*  94 */     return builder.build();
/*     */   }
/*     */   
/*     */   public static ReplayFPSConfig load() {
/*  98 */     class_310 client = class_310.method_1551();
/*  99 */     File configFile = new File(client.field_1697, "config/replayfps.json");
/*     */     
/* 101 */     if (configFile.exists()) {
/* 102 */       try { BufferedReader reader = new BufferedReader(new FileReader(configFile)); 
/* 103 */         try { ReplayFPSConfig replayFPSConfig = (ReplayFPSConfig)gson.fromJson(reader, ReplayFPSConfig.class);
/* 104 */           reader.close(); return replayFPSConfig; } catch (Throwable throwable) { try { reader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception e)
/* 105 */       { ReplayFPS.LOGGER.error("Unable to load Replay FPS config!", e); }
/*     */     
/*     */     }
/*     */     
/* 109 */     return new ReplayFPSConfig();
/*     */   }
/*     */   
/*     */   public void save() {
/* 113 */     class_310 client = class_310.method_1551();
/* 114 */     File configFile = new File(client.field_1697, "config/replayfps.json");
/*     */     
/* 116 */     try { BufferedWriter writer = new BufferedWriter(new FileWriter(configFile)); 
/* 117 */       try { writer.write(gson.toJson(this));
/* 118 */         writer.close(); } catch (Throwable throwable) { try { writer.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Exception e)
/* 119 */     { ReplayFPS.LOGGER.error("Error saving Replay FPS config!", e); }
/*     */ 
/*     */     
/* 122 */     ReplayFPS.LOGGER.info("Saved config to " + configFile);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\config\ReplayFPSConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */