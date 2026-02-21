package whirlpool.gods_of_olympus.Events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModEntities;
import whirlpool.gods_of_olympus.Renderer.HydroTridentRenderer;

@EventBusSubscriber(modid = Gods_of_olympus.MODID, value = Dist.CLIENT)
public class ClientModEventHandler {
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.THROWN_HYDRO_TRIDENT.get(), HydroTridentRenderer::new);
    }
}
