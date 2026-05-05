/*    */ package com.igrium.replayfps.core.playback;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import java.util.AbstractMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ class ChannelMap
/*    */   extends AbstractMap<ChannelHandler<?>, Object>
/*    */ {
/* 56 */   private UnserializedFrame.ChannelEntrySet entrySet = new UnserializedFrame.ChannelEntrySet(UnserializedFrame.this);
/*    */ 
/*    */   
/*    */   public Set<Map.Entry<ChannelHandler<?>, Object>> entrySet() {
/* 60 */     return this.entrySet;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\UnserializedFrame$ChannelMap.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */