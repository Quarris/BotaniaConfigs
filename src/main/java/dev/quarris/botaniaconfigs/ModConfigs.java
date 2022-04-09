package dev.quarris.botaniaconfigs;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigs {

    public static ForgeConfigSpec.IntValue orechidDelay;
    public static ForgeConfigSpec.IntValue orechidCost;

    public static ForgeConfigSpec register(ForgeConfigSpec.Builder config) {
        config.push("orechid");
        orechidDelay = config.comment(
                "The delay (in ticks) between the Orechid working",
                "Default: 100"
        ).defineInRange("delay", 100, 1, Short.MAX_VALUE);
        orechidCost = config.comment(
                "The mana cost of the Orechid working",
                "Default: 17500"
        ).defineInRange("cost", 17500, 0, Integer.MAX_VALUE);

        return config.build();
    }
}
