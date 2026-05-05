/*     */ package com.igrium.replayfps.core.playback;
/*     */ 
/*     */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*     */ import com.igrium.replayfps.core.recording.ClientCapHeader;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public final class UnserializedFrame extends Record {
/*     */   private final ClientCapHeader header;
/*     */   private final Object[] values;
/*     */   
/*  16 */   public ClientCapHeader header() { return this.header; } public final String toString() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lcom/igrium/replayfps/core/playback/UnserializedFrame;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #16	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lcom/igrium/replayfps/core/playback/UnserializedFrame; } public final int hashCode() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lcom/igrium/replayfps/core/playback/UnserializedFrame;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #16	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lcom/igrium/replayfps/core/playback/UnserializedFrame; } public final boolean equals(Object o) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lcom/igrium/replayfps/core/playback/UnserializedFrame;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #16	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lcom/igrium/replayfps/core/playback/UnserializedFrame;
/*  16 */     //   0	8	1	o	Ljava/lang/Object; } public Object[] values() { return this.values; }
/*     */   
/*     */   public UnserializedFrame(ClientCapHeader header, Object[] values) {
/*  19 */     if (values.length != header.numChannels()) {
/*  20 */       throw new IllegalArgumentException("Incorrect number of channels.");
/*     */     }
/*     */     
/*  23 */     this.header = header;
/*  24 */     this.values = values;
/*     */   }
/*     */   
/*     */   public UnserializedFrame(ClientCapHeader header) {
/*  28 */     this(header, new Object[header.numChannels()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<ChannelHandler<?>, Object> getValues() {
/*  36 */     return new ChannelMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T getValue(ChannelHandler<T> channel) throws ClassCastException {
/*  49 */     Object value = getValues().get(channel);
/*  50 */     if (value == null) return null;
/*     */     
/*  52 */     return channel.getType().cast(value);
/*     */   }
/*     */   
/*     */   private class ChannelMap extends AbstractMap<ChannelHandler<?>, Object> {
/*  56 */     private UnserializedFrame.ChannelEntrySet entrySet = new UnserializedFrame.ChannelEntrySet();
/*     */ 
/*     */     
/*     */     public Set<Map.Entry<ChannelHandler<?>, Object>> entrySet() {
/*  60 */       return this.entrySet;
/*     */     }
/*     */   }
/*     */   
/*     */   private class ChannelEntrySet
/*     */     extends AbstractSet<Map.Entry<ChannelHandler<?>, Object>>
/*     */   {
/*     */     public int size() {
/*  68 */       return UnserializedFrame.this.values.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<ChannelHandler<?>, Object>> iterator() {
/*  73 */       return new UnserializedFrame.ChannelIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean add(Map.Entry<ChannelHandler<?>, Object> e) {
/*  78 */       throw new UnsupportedOperationException("Unimplemented method 'add'");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean addAll(Collection<? extends Map.Entry<ChannelHandler<?>, Object>> c) {
/*  83 */       throw new UnsupportedOperationException("Unimplemented method 'addAll'");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class ChannelIterator
/*     */     implements Iterator<Map.Entry<ChannelHandler<?>, Object>>
/*     */   {
/*     */     int currentIndex;
/*     */     
/*     */     public boolean hasNext() {
/*  94 */       return (this.currentIndex < UnserializedFrame.this.values.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public Map.Entry<ChannelHandler<?>, Object> next() {
/*  99 */       ChannelHandler<?> key = UnserializedFrame.this.header.getChannels().get(this.currentIndex);
/* 100 */       Object value = UnserializedFrame.this.values[this.currentIndex];
/* 101 */       this.currentIndex++;
/* 102 */       return new AbstractMap.SimpleEntry<>(key, value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\UnserializedFrame.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */