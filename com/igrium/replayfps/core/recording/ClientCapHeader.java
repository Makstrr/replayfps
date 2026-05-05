/*     */ package com.igrium.replayfps.core.recording;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.channel.ChannelHandlers;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.class_151;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_2499;
/*     */ import net.minecraft.class_2507;
/*     */ import net.minecraft.class_2520;
/*     */ import net.minecraft.class_2960;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientCapHeader
/*     */ {
/*     */   public static class HeaderFormatException
/*     */     extends IOException
/*     */   {
/*     */     public HeaderFormatException() {}
/*     */     
/*     */     public HeaderFormatException(String message) {
/*  33 */       super(message);
/*     */     }
/*     */   }
/*     */   
/*  37 */   private static final class_2960 INVALID_IDENTIFIER = new class_2960("replayfps:invalid");
/*  38 */   private Logger logger = LogUtils.getLogger();
/*     */   
/*     */   private List<ChannelHandler<?>> channels;
/*     */   
/*  42 */   private int framerate = 40;
/*  43 */   private int framerateBase = 1;
/*  44 */   private int localPlayerID = -1;
/*     */   
/*     */   public ClientCapHeader(List<? extends ChannelHandler<?>> channels) {
/*  47 */     this.channels = new ArrayList<>(channels);
/*     */   }
/*     */   
/*     */   public ClientCapHeader() {
/*  51 */     this.channels = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public final List<ChannelHandler<?>> getChannels() {
/*  55 */     return this.channels;
/*     */   }
/*     */   
/*     */   public int numChannels() {
/*  59 */     return this.channels.size();
/*     */   }
/*     */   
/*     */   public final int getLocalPlayerID() {
/*  63 */     return this.localPlayerID;
/*     */   }
/*     */   
/*     */   public void setLocalPlayerID(int localPlayerID) {
/*  67 */     this.localPlayerID = localPlayerID;
/*     */   }
/*     */   
/*     */   public final int getFramerate() {
/*  71 */     return this.framerate;
/*     */   }
/*     */   
/*     */   public final int getFramerateBase() {
/*  75 */     return this.framerateBase;
/*     */   }
/*     */   
/*     */   public void setFramerate(int framerate) {
/*  79 */     if (framerate < 1) {
/*  80 */       throw new IllegalArgumentException("Framerate must be at least 1.");
/*     */     }
/*  82 */     this.framerate = framerate;
/*     */   }
/*     */   
/*     */   public void setFramerateBase(int framerateBase) {
/*  86 */     if (framerateBase < 1) {
/*  87 */       throw new IllegalArgumentException("Framerate base must be at least 1.");
/*     */     }
/*  89 */     this.framerateBase = framerateBase;
/*     */   }
/*     */   
/*     */   public final void setFramerate(int framerate, int framerateBase) {
/*  93 */     setFramerate(framerateBase);
/*  94 */     setFramerateBase(framerateBase);
/*     */   }
/*     */   
/*     */   public float getFramerateFloat() {
/*  98 */     return this.framerate / this.framerateBase;
/*     */   }
/*     */   
/*     */   public float getFrameInterval() {
/* 102 */     return this.framerateBase / this.framerate;
/*     */   }
/*     */   
/*     */   public int getFrameIntervalMillis() {
/* 106 */     return this.framerateBase * 1000 / this.framerate;
/*     */   }
/*     */   
/*     */   public class_2487 writeNBT(class_2487 nbt) {
/* 110 */     if (this.localPlayerID == -1) {
/* 111 */       throw new IllegalStateException("Local player ID has not been set!");
/*     */     }
/* 113 */     nbt.method_10569("framerate", this.framerate);
/* 114 */     nbt.method_10569("framerateBase", this.framerateBase);
/* 115 */     nbt.method_10569("localPlayerID", this.localPlayerID);
/*     */     
/* 117 */     class_2499 channels = new class_2499();
/* 118 */     for (ChannelHandler<?> handler : this.channels) {
/* 119 */       channels.add(writeChannelDeclaration(handler, new class_2487()));
/*     */     }
/* 121 */     nbt.method_10566("channels", (class_2520)channels);
/*     */     
/* 123 */     return nbt;
/*     */   }
/*     */   
/*     */   private class_2487 writeChannelDeclaration(ChannelHandler<?> channel, class_2487 nbt) {
/* 127 */     class_2960 id = (class_2960)ChannelHandlers.REGISTRY.inverse().get(channel);
/* 128 */     if (id == null) id = INVALID_IDENTIFIER;
/*     */     
/* 130 */     nbt.method_10582("id", id.toString());
/* 131 */     nbt.method_10569("size", channel.getChannelType().getSize());
/* 132 */     return nbt;
/*     */   }
/*     */   
/*     */   public void readNBT(class_2487 nbt) throws HeaderFormatException {
/* 136 */     if (nbt.method_10573("framerate", 3)) {
/* 137 */       setFramerate(nbt.method_10550("framerate"));
/*     */     }
/*     */     
/* 140 */     if (nbt.method_10573("framerateBase", 3)) {
/* 141 */       setFramerateBase(nbt.method_10550("framerateBase"));
/*     */     }
/*     */     
/* 144 */     if (!nbt.method_10573("channels", 9)) {
/* 145 */       throw new HeaderFormatException("No channel declaration found.");
/*     */     }
/*     */     
/* 148 */     class_2499 channels = nbt.method_10554("channels", 10);
/*     */     
/* 150 */     for (class_2520 element : channels) {
/* 151 */       this.channels.add(readChannelDeclaration((class_2487)element));
/*     */     }
/*     */     
/* 154 */     if (!nbt.method_10573("localPlayerID", 3)) {
/* 155 */       throw new HeaderFormatException("No local player ID found.");
/*     */     }
/* 157 */     this.localPlayerID = nbt.method_10550("localPlayerID");
/*     */   } private ChannelHandler<?> readChannelDeclaration(class_2487 nbt) throws HeaderFormatException {
/*     */     class_2960 id;
/*     */     ChannelHandlers.PlaceholderChannelHandler placeholderChannelHandler;
/* 161 */     String name = nbt.method_10558("id");
/*     */     
/*     */     try {
/* 164 */       id = new class_2960(name);
/* 165 */     } catch (class_151 e) {
/* 166 */       throw new HeaderFormatException("Invalid channel id: " + name);
/*     */     } 
/*     */     
/* 169 */     if (!nbt.method_10573("size", 3)) {
/* 170 */       throw new HeaderFormatException("Channel must specify a size.");
/*     */     }
/*     */     
/* 173 */     int size = nbt.method_10550("size");
/*     */     
/* 175 */     ChannelHandler<?> handler = (ChannelHandler)ChannelHandlers.REGISTRY.get(id);
/* 176 */     if (handler == null) {
/* 177 */       this.logger.warn("Unknown channel type: " + id);
/* 178 */       placeholderChannelHandler = new ChannelHandlers.PlaceholderChannelHandler(size);
/*     */     } 
/*     */     
/* 181 */     if (placeholderChannelHandler.getChannelType().getSize() != size) {
/* 182 */       this.logger.error("Improper channel size for handler type '%s'! (%d != %d)".formatted(new Object[] { id, Integer.valueOf(size), Integer.valueOf(placeholderChannelHandler.getChannelType().getSize()) }));
/* 183 */       placeholderChannelHandler = new ChannelHandlers.PlaceholderChannelHandler(size);
/*     */     } 
/*     */     
/* 186 */     return (ChannelHandler<?>)placeholderChannelHandler;
/*     */   }
/*     */   
/*     */   public void writeHeader(OutputStream out) throws IOException {
/* 190 */     class_2507.method_10628(writeNBT(new class_2487()), new DataOutputStream(out));
/*     */   }
/*     */   
/*     */   public void readHeader(InputStream in) throws IOException {
/* 194 */     class_2487 nbt = class_2507.method_10627(new DataInputStream(in));
/* 195 */     readNBT(nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int calculateFrameLength() {
/* 203 */     int length = 0;
/* 204 */     for (ChannelHandler<?> handler : this.channels) {
/* 205 */       length += handler.getChannelType().getSize();
/*     */     }
/* 207 */     return length;
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientCapHeader.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */