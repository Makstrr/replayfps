/*    */ package com.igrium.replayfps.core.channel;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import com.google.common.collect.HashBiMap;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelTypes;
/*    */ import com.igrium.replayfps.core.channel.type.PlaceholderChannel;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ import net.minecraft.class_2960;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChannelHandlers
/*    */ {
/* 16 */   public static final BiMap<class_2960, ChannelHandler<?>> REGISTRY = (BiMap<class_2960, ChannelHandler<?>>)HashBiMap.create();
/*    */   
/* 18 */   public static final ChannelHandler<?> DUMMY = register(new DummyChannelHandler(), new class_2960("replayfps:dummy"));
/*    */   
/*    */   public static class PlaceholderChannelHandler
/*    */     implements ChannelHandler<Object> {
/*    */     private final ChannelType<Object> type;
/*    */     
/*    */     public PlaceholderChannelHandler(int size) {
/* 25 */       this.type = (ChannelType<Object>)new PlaceholderChannel(size);
/*    */     }
/*    */ 
/*    */     
/*    */     public ChannelType<Object> getChannelType() {
/* 30 */       return this.type;
/*    */     }
/*    */ 
/*    */     
/*    */     public Object capture(ClientCaptureContext context) {
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void apply(Object val, ClientPlaybackContext context) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T extends ChannelHandler<?>> T register(T handler, class_2960 id) {
/* 51 */     REGISTRY.put(id, handler);
/* 52 */     return handler;
/*    */   }
/*    */   
/*    */   private static class DummyChannelHandler
/*    */     implements ChannelHandler<Short>
/*    */   {
/*    */     public ChannelType<Short> getChannelType() {
/* 59 */       return (ChannelType<Short>)ChannelTypes.SHORT;
/*    */     }
/*    */ 
/*    */     
/*    */     public Short capture(ClientCaptureContext context) {
/* 64 */       return Short.valueOf((short)4031);
/*    */     }
/*    */     
/*    */     public void apply(Short val, ClientPlaybackContext context) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\ChannelHandlers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */