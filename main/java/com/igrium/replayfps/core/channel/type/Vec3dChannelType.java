/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.class_243;
/*    */ 
/*    */ 
/*    */ public class Vec3dChannelType
/*    */   implements ChannelType<class_243>
/*    */ {
/*    */   public Class<class_243> getType() {
/* 13 */     return class_243.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 18 */     return 24;
/*    */   }
/*    */ 
/*    */   
/*    */   public class_243 read(DataInput in) throws IOException {
/* 23 */     double x = in.readDouble();
/* 24 */     double y = in.readDouble();
/* 25 */     double z = in.readDouble();
/* 26 */     return new class_243(x, y, z);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(DataOutput out, class_243 val) throws IOException {
/* 31 */     out.writeDouble(val.method_10216());
/* 32 */     out.writeDouble(val.method_10214());
/* 33 */     out.writeDouble(val.method_10215());
/*    */   }
/*    */ 
/*    */   
/*    */   public class_243 defaultValue() {
/* 38 */     return new class_243(0.0D, 0.0D, 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public class_243 interpolate(class_243 from, class_243 to, float delta) {
/* 43 */     return from.method_35590(to, delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public float[] getRawValues(class_243 value) {
/* 48 */     return new float[] { (float)value.field_1352, (float)value.field_1351, (float)value.field_1350 };
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\Vec3dChannelType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */