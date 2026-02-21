package whirlpool.gods_of_olympus.Registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.gods_of_olympus.Entities.ThrownHydroTrident;
import whirlpool.gods_of_olympus.Gods_of_olympus;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Gods_of_olympus.MODID);

    public static ResourceKey<EntityType<?>> HYDRO_TRIDENT_TEXTURE = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hydro_trident"));

    public static final Supplier<EntityType<ThrownHydroTrident>> THROWN_HYDRO_TRIDENT = ENTITY_TYPES.register("thrown_hydro_trident",
            () -> EntityType.Builder.<ThrownHydroTrident>of(ThrownHydroTrident::new, net.minecraft.world.entity.MobCategory.MISC)
                    .noLootTable()
                    .sized(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(HYDRO_TRIDENT_TEXTURE));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
