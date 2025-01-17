package cech12.brickhopper.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ServerConfig {
    public static ForgeConfigSpec SERVER_CONFIG;

    public static final ForgeConfigSpec.IntValue BRICK_HOPPER_COOLDOWN;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("Options that affect the added Brick Hopper.").push("Brick Hopper Settings");
        BRICK_HOPPER_COOLDOWN = builder
                .comment("Time (ticks) that passes between two brick hopper operations. (default: 12 ticks) (vanilla hopper: 8 ticks)")
                .defineInRange("brickHopperCooldown", 12, 1, 1000);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}
