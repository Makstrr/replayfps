/*    */ package com.igrium.replayfps.game.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.game.event.ClientPlayerEvents;
/*    */ import net.minecraft.class_1934;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_746;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_746.class})
/*    */ public class ClientPlayerEntityMixin
/*    */ {
/*    */   @Shadow
/*    */   private class_310 field_3937;
/*    */   
/*    */   @Inject(method = {"onGameModeChanged"}, at = {@At("HEAD")})
/*    */   void replayfps$gamemodeChanged(class_1934 gameMode, CallbackInfo ci) {
/* 23 */     ((ClientPlayerEvents.SetGamemodeEvent)ClientPlayerEvents.SET_GAMEMODE.invoker()).onSetGamemode((class_746)this, this.field_3937.field_1761.method_2920(), gameMode);
/*    */   }
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\mixin\ClientPlayerEntityMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */