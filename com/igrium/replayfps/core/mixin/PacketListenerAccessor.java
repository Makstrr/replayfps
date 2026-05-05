package com.igrium.replayfps.core.mixin;

import com.replaymod.recording.packet.PacketListener;
import com.replaymod.replaystudio.replay.ReplayFile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({PacketListener.class})
public interface PacketListenerAccessor {
  @Accessor(value = "replayFile", remap = false)
  ReplayFile getReplayFile();
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\mixin\PacketListenerAccessor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */