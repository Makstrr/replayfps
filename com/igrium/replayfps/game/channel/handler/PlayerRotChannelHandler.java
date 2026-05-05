/*    */ package com.igrium.replayfps.game.channel.handler;
/*    */ 
/*    */ import com.igrium.replayfps.core.channel.ChannelHandler;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelType;
/*    */ import com.igrium.replayfps.core.channel.type.ChannelTypes;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackContext;
/*    */ import com.igrium.replayfps.core.recording.ClientCaptureContext;
/*    */ import net.minecraft.class_742;
/*    */ import net.minecraft.class_746;
/*    */ import org.joml.Vector2f;
/*    */ import org.joml.Vector2fc;
/*    */ 
/*    */ 
/*    */ public class PlayerRotChannelHandler
/*    */   implements ChannelHandler<Vector2fc>
/*    */ {
/*    */   public ChannelType<Vector2fc> getChannelType() {
/* 18 */     return (ChannelType<Vector2fc>)ChannelTypes.VECTOR2F;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector2fc capture(ClientCaptureContext context) {
/* 23 */     class_746 player = context.localPlayer();
/* 24 */     return (Vector2fc)new Vector2f(player.method_36455(), player.method_36454());
/*    */   }
/*    */ 
/*    */   
/*    */   public void apply(Vector2fc val, ClientPlaybackContext context) {
/* 29 */     context.localPlayer().ifPresent(player -> {
/*    */           player.method_36457(val.x());
/*    */           player.method_36456(val.y());
/*    */           player.field_6004 = val.x();
/*    */           player.field_5982 = val.y();
/*    */           player.method_5847(val.y());
/*    */           player.field_6259 = val.y();
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldInterpolate() {
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\channel\handler\PlayerRotChannelHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */