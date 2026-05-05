/*    */ package com.igrium.replayfps.game.mixin;
/*    */ 
/*    */ import com.igrium.replayfps.game.event.ClientPlayerEvents;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1799;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_1661.class})
/*    */ public abstract class PlayerInventoryMixin
/*    */ {
/*    */   @Shadow
/*    */   int field_7545;
/*    */   @Unique
/* 24 */   private int prevSelectedSlot = -1;
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"updateItems"}, at = {@At("RETURN")})
/*    */   void replayfps$onUpdateItems(CallbackInfo ci) {
/* 30 */     if (this.field_7545 != this.prevSelectedSlot) {
/* 31 */       ((ClientPlayerEvents.SelectSlotEvent)ClientPlayerEvents.SELECT_SLOT.invoker()).onSelectSlot((class_1661)this, this.field_7545);
/*    */     }
/* 33 */     this.prevSelectedSlot = this.field_7545;
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   public abstract class_1799 method_5438(int paramInt);
/*    */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\mixin\PlayerInventoryMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */