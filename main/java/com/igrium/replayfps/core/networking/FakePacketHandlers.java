/*    */ package com.igrium.replayfps.core.networking;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import com.google.common.collect.HashBiMap;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.class_2960;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FakePacketHandlers
/*    */ {
/* 12 */   public static final BiMap<class_2960, FakePacketHandler<?>> REGISTRY = (BiMap<class_2960, FakePacketHandler<?>>)HashBiMap.create();
/*    */   
/*    */   public static void register(class_2960 id, Function<class_2960, FakePacketHandler<?>> factory) {
/* 15 */     FakePacketHandler<?> handler = factory.apply(id);
/* 16 */     REGISTRY.put(id, handler);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\FakePacketHandlers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */