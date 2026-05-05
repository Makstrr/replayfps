package com.igrium.replayfps.core.util;

public interface TimecodeProvider {
  long getStartTime();
  
  long getTimePassedWhilePaused();
  
  boolean getServerWasPaused();
}


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\TimecodeProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */