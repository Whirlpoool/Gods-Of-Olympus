package whirlpool.gods_of_olympus.Registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.gods_of_olympus.Effect.DrowningEffect;
import whirlpool.gods_of_olympus.Effect.FlightEffect;
import whirlpool.gods_of_olympus.Effect.HadesInvisEffect;
import whirlpool.gods_of_olympus.Gods_of_olympus;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Gods_of_olympus.MODID);

    public static final Holder<MobEffect> FLIGHT = MOB_EFFECTS.register("flight", FlightEffect::new);

    public static final Holder<MobEffect> HADES_INVIS = MOB_EFFECTS.register("hades_invis", () -> new HadesInvisEffect().addAttributeModifier(
            Attributes.WAYPOINT_TRANSMIT_RANGE,
            Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hades_invis_transmit_range"), -1.0F,
            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> DROWNING = MOB_EFFECTS.register("drowning", DrowningEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
