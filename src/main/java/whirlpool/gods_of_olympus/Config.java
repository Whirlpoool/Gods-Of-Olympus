package whirlpool.gods_of_olympus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = Gods_of_olympus.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<Integer> HERMES_FLIGHT_LENGTH = BUILDER
            .comment("The number (in seconds) that the player will be able to fly for with Hermes' Winged Sandals")
            .translation("config.gods_of_olympus.hermes_flight_length")
            .defineInRange("hermesFlightLength", 60, 0, Integer.MAX_VALUE);


    static final ModConfigSpec SPEC = BUILDER.build();
}
