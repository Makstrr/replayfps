/*    */ package com.igrium.replayfps.core.networking;
/*    */ 
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_310;
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
/*    */ public interface PacketRedirector<T extends net.minecraft.class_2596<?>>
/*    */ {
/*    */   Class<T> getPacketClass();
/*    */   
/*    */   boolean shouldRedirect(T paramT, class_1657 paramclass_1657, class_310 paramclass_310);
/*    */   
/*    */   void redirect(T paramT, class_1657 paramclass_1657, class_310 paramclass_310);
/*    */   
/*    */   default boolean shouldRedirect(Object packet, class_1657 localPlayer, class_310 client) {
/* 40 */     return shouldRedirect(getPacketClass().cast(packet), localPlayer, client);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\PacketRedirector.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */