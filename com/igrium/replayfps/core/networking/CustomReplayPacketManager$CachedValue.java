/*    */ package com.igrium.replayfps.core.networking;
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
/*    */ public final class CachedValue
/*    */   extends Record
/*    */ {
/*    */   private final FakePacketHandler<?> handler;
/*    */   private final Object val;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #41	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #41	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #41	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/igrium/replayfps/core/networking/CustomReplayPacketManager$CachedValue;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   protected CachedValue(FakePacketHandler<?> handler, Object val) {
/* 41 */     this.handler = handler; this.val = val; } public FakePacketHandler<?> handler() { return this.handler; } public Object val() { return this.val; }
/*    */ 
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\CustomReplayPacketManager$CachedValue.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */