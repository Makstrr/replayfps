/*     */ package com.igrium.replayfps.config;
/*     */ 
import net.minecraftforge.common.ForgeConfigSpec;
/*     */ 
/*     */ 
public class ConfigHolder {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue SMOOTH_CAMERA;
    public static final ForgeConfigSpec.DoubleValue FOV_MULTIPLIER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("ReplayFPS settings").push("general");
        SMOOTH_CAMERA = builder
                .comment("Enable camera smoothing in replays")
                .define("smoothCamera", true);
        FOV_MULTIPLIER = builder
                .comment("FOV multiplier for first-person view")
                .defineInRange("fovMultiplier", 1.0, 0.1, 2.0);
        builder.pop();
        SPEC = builder.build();
    }
}