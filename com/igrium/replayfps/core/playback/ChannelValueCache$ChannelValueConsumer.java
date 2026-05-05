package com.igrium.replayfps.core.playback;

import com.igrium.replayfps.core.channel.ChannelHandler;

public interface ChannelValueConsumer {
  <T> void accept(ChannelHandler<T> paramChannelHandler, T paramT);
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\core\playback\ChannelValueCache$ChannelValueConsumer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */