/*    */ package com.igrium.replayfps.core.playback;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import java.util.AbstractSet;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ChannelEntrySet
/*    */   extends AbstractSet<Map.Entry<ChannelHandler<?>, Object>>
/*    */ {
/*    */   public int size() {
/* 68 */     return UnserializedFrame.this.values.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<Map.Entry<ChannelHandler<?>, Object>> iterator() {
/* 73 */     return new UnserializedFrame.ChannelIterator(UnserializedFrame.this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(Map.Entry<ChannelHandler<?>, Object> e) {
/* 78 */     throw new UnsupportedOperationException("Unimplemented method 'add'");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addAll(Collection<? extends Map.Entry<ChannelHandler<?>, Object>> c) {
/* 83 */     throw new UnsupportedOperationException("Unimplemented method 'addAll'");
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\UnserializedFrame$ChannelEntrySet.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */