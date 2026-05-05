/*    */ package com.igrium.replayfps.core.playback;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class ChannelValueCache
/*    */ {
/* 11 */   private Map<ChannelHandler<?>, Object> map = new HashMap<>();
/* 12 */   private Map<ChannelHandler<?>, Object> unmodifiable = Collections.unmodifiableMap(this.map);
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> void put(ChannelHandler<T> channel, T value) {
/* 17 */     this.map.put(channel, value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T get(ChannelHandler<T> channel) {
/* 23 */     return (T)this.map.get(channel);
/*    */   }
/*    */   
/*    */   public Map<ChannelHandler<?>, Object> map() {
/* 27 */     return this.unmodifiable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T remove(ChannelHandler<T> channel) {
/* 33 */     return (T)this.map.remove(channel);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 37 */     this.map.clear();
/*    */   }
/*    */   
/*    */   public void forEach(ChannelValueConsumer consumer) {
/* 41 */     for (Map.Entry<ChannelHandler<?>, Object> entry : this.map.entrySet()) {
/* 42 */       doCast(consumer, entry.getKey(), entry.getValue());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private <T> void doCast(ChannelValueConsumer consumer, ChannelHandler<T> channel, Object value) {
/* 48 */     consumer.accept(channel, channel.getType().cast(value));
/*    */   }
/*    */   
/*    */   public static interface ChannelValueConsumer {
/*    */     <T> void accept(ChannelHandler<T> param1ChannelHandler, T param1T);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ChannelValueCache.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */