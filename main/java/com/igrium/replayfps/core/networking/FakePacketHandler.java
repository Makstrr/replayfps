/*     */ package com.igrium.replayfps.core.networking;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
/*     */ import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_2540;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_310;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FakePacketHandler<T>
/*     */   implements CustomReplayPacketManager.ReplayPacketConsumer
/*     */ {
/*     */   private final class_2960 id;
/*     */   
/*     */   public enum SpectatorBehavior
/*     */   {
/*  30 */     APPLY,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     SKIP,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     QUEUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FakePacketHandler(class_2960 id) {
/*  51 */     this.id = Objects.<class_2960>requireNonNull(id);
/*  52 */     registerListener(this::sendPacket);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class_2960 getId() {
/*  59 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void castAndApply(Object value, class_310 client, class_1657 player) throws ClassCastException {
/* 110 */     apply(getType().cast(value), client, player);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPacket(class_310 client, class_2540 packet, class_1657 localPlayer) {
/* 115 */     T val = parse(packet);
/* 116 */     client.execute(() -> apply((T)val, client, localPlayer));
/*     */   }
/*     */   
/*     */   private void sendPacket(T value) {
/* 120 */     class_2540 buffer = PacketByteBufs.create();
/* 121 */     write(value, buffer);
/* 122 */     CustomReplayPacketManager.sendReplayPacket(this.id, buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SpectatorBehavior getSpectatorBehavior() {
/* 130 */     return SpectatorBehavior.APPLY;
/*     */   }
/*     */   
/*     */   public abstract Class<T> getType();
/*     */   
/*     */   public abstract void registerListener(Consumer<T> paramConsumer);
/*     */   
/*     */   public abstract void write(T paramT, class_2540 paramclass_2540);
/*     */   
/*     */   public abstract T parse(class_2540 paramclass_2540);
/*     */   
/*     */   public abstract void apply(T paramT, class_310 paramclass_310, class_1657 paramclass_1657);
/*     */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\networking\FakePacketHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */