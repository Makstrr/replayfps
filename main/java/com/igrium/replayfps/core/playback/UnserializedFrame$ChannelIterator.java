/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ChannelIterator
/*     */   implements Iterator<Map.Entry<ChannelHandler<?>, Object>>
/*     */ {
/*     */   int currentIndex;
/*     */   
/*     */   public boolean hasNext() {
/*  94 */     return (this.currentIndex < UnserializedFrame.this.values.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<ChannelHandler<?>, Object> next() {
/*  99 */     ChannelHandler<?> key = UnserializedFrame.this.header.getChannels().get(this.currentIndex);
/* 100 */     Object value = UnserializedFrame.this.values[this.currentIndex];
/* 101 */     this.currentIndex++;
/* 102 */     return new AbstractMap.SimpleEntry<>(key, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\UnserializedFrame$ChannelIterator.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */