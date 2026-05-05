package com.igrium.replayfps.game.mixin;

import net.minecraft.class_1309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_1309.class})
public interface LivingEntityAccessor {
  @Accessor("lastDamageTaken")
  float getLastDamageTaken();
  
  @Accessor("lastDamageTaken")
  void setLastDamageTaken(float paramFloat);
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\game\mixin\LivingEntityAccessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */