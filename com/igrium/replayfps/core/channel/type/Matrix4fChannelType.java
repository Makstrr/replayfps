/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import org.joml.Matrix4f;
/*    */ import org.joml.Matrix4fc;
/*    */ 
/*    */ public class Matrix4fChannelType
/*    */   implements ChannelType<Matrix4fc>
/*    */ {
/*    */   private static final int BUFFER_SIZE = 16;
/* 13 */   private float[] buffer = new float[16];
/*    */ 
/*    */   
/*    */   public Class<Matrix4fc> getType() {
/* 17 */     return Matrix4fc.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 22 */     return 64;
/*    */   }
/*    */ 
/*    */   
/*    */   public Matrix4fc read(DataInput in) throws IOException {
/* 27 */     for (int i = 0; i < this.buffer.length; i++) {
/* 28 */       this.buffer[i] = in.readFloat();
/*    */     }
/* 30 */     return (Matrix4fc)(new Matrix4f()).set(this.buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, Matrix4fc val) throws IOException {
/* 35 */     val.get(this.buffer);
/* 36 */     for (int i = 0; i < this.buffer.length; i++) {
/* 37 */       out.writeFloat(this.buffer[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public Matrix4fc defaultValue() {
/* 43 */     return (Matrix4fc)new Matrix4f();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 48 */     return "Matrix4f";
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\Matrix4fChannelType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */