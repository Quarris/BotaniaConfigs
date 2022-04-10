package dev.quarris.botaniaconfigs;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigs {

    // Orechid
    public static ForgeConfigSpec.IntValue orechidDelay;
    public static ForgeConfigSpec.IntValue orechidCost;

    // Orechid Ignem
    public static ForgeConfigSpec.IntValue orechidIgnemDelay;
    public static ForgeConfigSpec.IntValue orechidIgnemCost;

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
        config.pop();
        config.push("orechid_ignem");
        orechidIgnemDelay = config.comment(
                "The delay (in ticks) between the Orechid Ignem working",
                "Default: 100"
        ).defineInRange("delay", 100, 1, Short.MAX_VALUE);
        orechidIgnemCost = config.comment(
                "The mana cost of the Orechid Ignem working",
                "Default: 20000"
        ).defineInRange("cost", 20000, 0, Integer.MAX_VALUE);
        config.pop();

        return config.build();
    }
}
