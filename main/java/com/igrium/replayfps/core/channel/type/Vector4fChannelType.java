/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import org.joml.Vector4f;
/*    */ import org.joml.Vector4fc;
/*    */ 
/*    */ 
/*    */ public class Vector4fChannelType
/*    */   implements ChannelType<Vector4fc>
/*    */ {
/*    */   public Class<Vector4fc> getType() {
/* 14 */     return Vector4fc.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 19 */     return 16;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector4fc read(DataInput in) throws IOException {
/* 24 */     float x = in.readFloat();
/* 25 */     float y = in.readFloat();
/* 26 */     float z = in.readFloat();
/* 27 */     float w = in.readFloat();
/*    */     
/* 29 */     return (Vector4fc)new Vector4f(x, y, z, w);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Vector4fc val) throws IOException {
/* 34 */     out.writeFloat(val.x());
/* 35 */     out.writeFloat(val.y());
/* 36 */     out.writeFloat(val.z());
/* 37 */     out.writeFloat(val.w());
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector4fc defaultValue() {
/* 42 */     return (Vector4fc)new Vector4f();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 47 */     return "Vector4f";
/*    */   }
/*    */ 
/*    */   
/*    */   public float[] getRawValues(Vector4fc value) {
/* 52 */     return new float[] { value.x(), value.y(), value.z(), value.w() };
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\Vector4fChannelType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */