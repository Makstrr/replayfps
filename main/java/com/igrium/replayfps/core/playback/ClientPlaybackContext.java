package com.igrium.replayfps.core.playback;

import com.replaymod.replay.ReplayHandler;
import java.util.Optional;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import net.minecraft.class_742;

public interface ClientPlaybackContext {
  class_310 client();
  
  ReplayHandler replayHandler();
  
  Optional<class_1297> cameraEntity();
  
  Optional<class_742> localPlayer();
  
  class_4184 camera();
  
  int timestamp();
  
  Optional<class_638> world();
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ClientPlaybackContext.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */