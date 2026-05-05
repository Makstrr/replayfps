package com.igrium.replayfps.core.recording;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.class_1297;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_757;

public interface ClientCaptureContext {
  class_310 client();
  
  float tickDelta();
  
  class_1297 cameraEntity();
  
  class_4184 camera();
  
  class_746 localPlayer();
  
  class_757 gameRenderer();
  
  class_638 world();
  
  WorldRenderContext renderContext();
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\recording\ClientCaptureContext.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */