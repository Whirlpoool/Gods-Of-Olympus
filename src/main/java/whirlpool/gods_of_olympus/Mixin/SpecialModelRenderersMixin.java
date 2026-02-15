package whirlpool.gods_of_olympus.Mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Renderer.PoseidonsTridentSpecialRenderer;

@Mixin(SpecialModelRenderers.class)
public class SpecialModelRenderersMixin {
    @Shadow
    @Final
    private static ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends SpecialModelRenderer.Unbaked>> ID_MAPPER;

    @Inject(method = "bootstrap",
    at = @At("HEAD"),
    cancellable = true)
    private static void bootstrap(CallbackInfo ci) {
        ID_MAPPER.put(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "poseidons_trident"), PoseidonsTridentSpecialRenderer.Unbaked.MAP_CODEC);
    }
}
