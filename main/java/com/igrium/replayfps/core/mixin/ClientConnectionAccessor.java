package com.igrium.replayfps.core.mixin;

import io.netty.channel.Channel;
import net.minecraft.class_2535;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_2535.class})
public interface ClientConnectionAccessor {
  @Accessor("channel")
  Channel replayfps$getChannel();
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\ClientConnectionAccessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */