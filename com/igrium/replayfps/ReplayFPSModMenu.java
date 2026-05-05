/*   */ package com.igrium.replayfps;
/*   */ 
/*   */ import com.terraformersmc.modmenu.api.ConfigScreenFactory;
/*   */ import com.terraformersmc.modmenu.api.ModMenuApi;
/*   */ import net.minecraft.class_437;
/*   */ 
/*   */ public class ReplayFPSModMenu implements ModMenuApi {
/*   */   public ConfigScreenFactory<?> getModConfigScreenFactory() {
/* 9 */     return parent -> ReplayFPS.getInstance().config().getScreen(parent);
/*   */   }
/*   */ }


/* Location:              C:\Users\m_shi\Downloads\replayfps-0.2.0.jar!\com\igrium\replayfps\ReplayFPSModMenu.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */