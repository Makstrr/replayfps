/*    */ package com.igrium.replayfps;
/*    */ 
         import com.mojang.logging.LogUtils;
/*    */ import com.igrium.replayfps.config.ConfigHolder;
/*    */ import com.igrium.replayfps.core.playback.ClientPlaybackModule;
/*    */ import com.igrium.replayfps.core.recording.ClientRecordingModule;
/*    */ 
/*    */ import com.replaymod.core.ReplayMod;
/*    */ import net.minecraftforge.api.distmarker.Dist;
         import net.minecraftforge.client.event.RenderLevelStageEvent;
         import net.minecraftforge.event.TickEvent;
         import net.minecraftforge.eventbus.api.SubscribeEvent;
         import net.minecraftforge.fml.ModLoadingContext;
         import net.minecraftforge.fml.common.Mod;
         import net.minecraftforge.fml.config.ModConfig;
         import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
         import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import org.slf4j.Logger;
/*    */ 
@Mod(ReplayFPS.MOD_ID)
public class ReplayFPS {

    public static final String MOD_ID = "replayfps";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ReplayFPS() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigHolder.SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        ReplayMod.instance.getModuleRegistry().registerModule(new ClientPlaybackModule());
        ReplayMod.instance.getModuleRegistry().registerModule(new ClientRecordingModule());
        LOGGER.info("ReplayFPS modules successfully registered");
    }

    // ------------------------------------------------------------------------
    // Обработчики клиентских событий Forge (тик и рендер мира)
    // ------------------------------------------------------------------------
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onClientTick(final TickEvent.ClientTickEvent event) {
            // Выполняем логику только в конце клиентского тика
            if (event.phase != TickEvent.Phase.END) return;

            // Если модули реализуют интерфейс с методом tick(), вызываем их
            ClientPlaybackModule.tick();
            ClientRecordingModule.tick();
        }

        @SubscribeEvent
        public static void onRenderWorldLast(final RenderLevelStageEvent event) {
            if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES) return;

            // Здесь можно вызывать методы отрисовки оверлеев,
            // например: ClientPlaybackModule.renderOverlay(event.getPoseStack(), event.getPartialTick());
        }
    }
}