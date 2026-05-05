/*    */ package com.igrium.replayfps.core.util;
/*    */ 
/*    */ import com.igrium.replayfps.core.playback.ClientCapPlayer;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import com.replaymod.simplepathing.ReplayModSimplePathing;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_638;
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
/*    */ public final class PlaybackUtils
/*    */ {
/*    */   public static Integer getCurrentPlaybackPlayerID() {
/* 25 */     ClientCapPlayer player = ClientPlaybackModule.getInstance().getCurrentPlayer();
/* 26 */     if (player == null) return null; 
/* 27 */     if (player.getReader().getHeader() == null) return null; 
/* 28 */     return Integer.valueOf(player.getReader().getHeader().getLocalPlayerID());
/*    */   }
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
/*    */   public static class_1657 getCurrentPlaybackPlayer() {
/* 41 */     class_638 class_638 = (class_310.method_1551()).field_1687;
/* 42 */     if (class_638 == null) return null;
/*    */     
/* 44 */     Integer id = getCurrentPlaybackPlayerID();
/* 45 */     if (id == null) return null;
/*    */     
/* 47 */     class_1297 class_1297 = class_638.method_8469(id.intValue()); if (class_1297 instanceof class_1657) { class_1657 player = (class_1657)class_1297;
/* 48 */       return player; }
/*    */     
/* 50 */     return null;
/*    */   }
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
/*    */   public static boolean isViewingPlaybackPlayer() {
/* 63 */     class_1297 camera = (class_310.method_1551()).field_1719;
/* 64 */     if (camera == null) return false; 
/* 65 */     return Integer.valueOf(camera.method_5628()).equals(getCurrentPlaybackPlayerID());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isPlayingReplay() {
/* 76 */     return (ReplayModSimplePathing.instance.getGuiPathing() != null);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\PlaybackUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */