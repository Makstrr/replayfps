/*    */ package com.igrium.replayfps.core.channel.type;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChannelTypes
/*    */ {
/* 13 */   public static final NumberChannel.ByteChannel BYTE = new NumberChannel.ByteChannel();
/* 14 */   public static final NumberChannel.ShortChannel SHORT = new NumberChannel.ShortChannel();
/* 15 */   public static final NumberChannel.IntegerChannel INTEGER = new NumberChannel.IntegerChannel();
/* 16 */   public static final NumberChannel.LongChannel LONG = new NumberChannel.LongChannel();
/* 17 */   public static final NumberChannel.FloatChannel FLOAT = new NumberChannel.FloatChannel();
/* 18 */   public static final NumberChannel.DoubleChannel DOUBLE = new NumberChannel.DoubleChannel();
/* 19 */   public static final NumberChannel.UnsignedShortChannel UNSIGNED_SHORT = new NumberChannel.UnsignedShortChannel();
/* 20 */   public static final NumberChannel.UnsignedByteChannel UNSIGNED_BYTE = new NumberChannel.UnsignedByteChannel();
/*    */   
/* 22 */   public static final Matrix4fChannelType MATRIX4F = new Matrix4fChannelType();
/* 23 */   public static final Vector2fChannelType VECTOR2F = new Vector2fChannelType();
/*    */   
/* 25 */   public static final Vec3dChannelType VEC3D = new Vec3dChannelType();
/*    */   
/*    */   public static PlaceholderChannel placeholder(int size) {
/* 28 */     return new PlaceholderChannel(size);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\channel\type\ChannelTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */