/*    */ package com.igrium.replayfps.core.networking;
/*    */ 
/*    */ import com.igrium.replayfps.core.util.PlaybackUtils;
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.WeakHashMap;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketRedirectors
/*    */ {
/* 17 */   private static final Map<Class<? extends class_2596<?>>, PacketRedirector<?>> REGISTRY = new ConcurrentHashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   public static final Set<class_2596<?>> REDIRECT_QUEUED = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));
/*    */   
/*    */   public static boolean shouldRedirect(class_2596<?> packet) {
/* 27 */     class_310 client = class_310.method_1551();
/* 28 */     class_1657 localPlayer = PlaybackUtils.getCurrentPlaybackPlayer();
/* 29 */     return shouldRedirect(packet, localPlayer, client);
/*    */   }
/*    */   
/*    */   public static boolean shouldRedirect(class_2596<?> packet, class_1657 localPlayer, class_310 client) {
/* 33 */     PacketRedirector<?> redirector = REGISTRY.get(packet.getClass());
/* 34 */     if (redirector != null && redirector.getPacketClass().isInstance(packet)) {
/* 35 */       return redirector.shouldRedirect(packet, localPlayer, client);
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public static void applyRedirect(class_2596<?> packet, class_1657 localPlayer, class_310 client) {
/* 41 */     PacketRedirector<?> redirector = REGISTRY.get(packet.getClass());
/* 42 */     if (redirector == null)
/*    */       return; 
/* 44 */     tryHandle(packet, redirector, localPlayer, client);
/*    */   }
/*    */ 
/*    */   
/*    */   private static <T extends class_2596<?>> void tryHandle(class_2596<?> packet, PacketRedirector<T> redirector, class_1657 localPlayer, class_310 client) {
/* 49 */     redirector.redirect((T)redirector.getPacketClass().cast(packet), localPlayer, client);
/*    */   }
/*    */   
/*    */   public static void register(PacketRedirector<?> redirector) {
/* 53 */     REGISTRY.put((Class)redirector.getPacketClass(), redirector);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\PacketRedirectors.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */