/*   */ package com.igrium.replayfps.core.util;
/*   */ 
/*   */ public class NoHeaderException extends IllegalStateException {
/*   */   public NoHeaderException() {
/* 5 */     super("The header has not been initialized.");
/*   */   }
/*   */   
/*   */   public NoHeaderException(String message) {
/* 9 */     super(message);
/*   */   }
/*   */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\cor\\util\NoHeaderException.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */