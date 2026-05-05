/*     */ package com.igrium.replayfps.core.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AnimationUtils
/*     */ {
/*     */   public static long countFrames(long time, long frameInterval) {
/*  13 */     return Math.floorDiv(time, frameInterval);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countFrames(long time, int frameInterval) {
/*  23 */     return (int)Math.floorDiv(time, frameInterval);
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
/*     */   
/*     */   public static int countFrames(long time, int framerate, int framerateBase) {
/*  37 */     return (int)(time * framerate / (framerateBase * 1000));
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
/*     */   
/*     */   public static int countFrames(int time, int framerate, int framerateBase) {
/*  51 */     return time * framerate / framerateBase * 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countFrames(long time, float framerate) {
/*  61 */     return (int)((float)time * framerate / 1000.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countFrames(float time, int framerate, int framerateBase) {
/*  72 */     return (int)(time * framerate / framerateBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countFrames(float time, float framerate) {
/*  82 */     return (int)(time * framerate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getDuration(int numFrames, int framerate, int framerateBase) {
/*  93 */     return (numFrames * framerateBase * 1000 / framerate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getDuration(int numFrames, float framerate) {
/* 103 */     return (long)((1000 * numFrames) / framerate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getDurationSeconds(int numFrames, float framerate) {
/* 113 */     return numFrames / framerate;
/*     */   }
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\AnimationUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */