/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import org.joml.Vector2f;
/*    */ import org.joml.Vector2fc;
/*    */ 
/*    */ 
/*    */ public class Vector2fChannelType
/*    */   implements ChannelType<Vector2fc>
/*    */ {
/*    */   public Class<Vector2fc> getType() {
/* 14 */     return Vector2fc.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 19 */     return 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector2fc read(DataInput in) throws IOException {
/* 24 */     float x = in.readFloat();
/* 25 */     float y = in.readFloat();
/* 26 */     return (Vector2fc)new Vector2f(x, y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Vector2fc val) throws IOException {
/* 31 */     out.writeFloat(val.x());
/* 32 */     out.writeFloat(val.y());
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector2fc defaultValue() {
/* 37 */     return (Vector2fc)new Vector2f();
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector2fc interpolate(Vector2fc from, Vector2fc to, float delta) {
/* 42 */     return (Vector2fc)from.lerp(to, delta, new Vector2f());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 47 */     return "Vector2f";
/*    */   }
/*    */ 
/*    */   
/*    */   public float[] getRawValues(Vector2fc value) {
/* 52 */     return new float[] { value.x(), value.y() };
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\Vector2fChannelType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */