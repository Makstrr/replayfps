/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
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
/*    */ public interface ChannelType<T>
/*    */ {
/*    */   Class<T> getType();
/*    */   
/*    */   int getSize();
/*    */   
/*    */   T read(DataInput paramDataInput) throws IOException;
/*    */   
/*    */   void write(DataOutput paramDataOutput, T paramT) throws IOException;
/*    */   
/*    */   T defaultValue();
/*    */   
/*    */   default T interpolate(T from, T to, float delta) {
/* 59 */     return from;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default String getName() {
/* 67 */     return getType().getSimpleName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default float[] getRawValues(T value) {
/* 78 */     return new float[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\ChannelType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */