package whirlpool.gods_of_olympus.Mixin;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whirlpool.gods_of_olympus.Items.HadesHelmOfDarkness;

@Mixin(AvatarRenderer.class)
public class EntityRendererMixin<T extends Entity> {
    @Inject(method = "shouldRenderLayers", at = @At("HEAD"), cancellable = true)
    public void isInvisibleCancel(AvatarRenderState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.headEquipment.getItem() instanceof HadesHelmOfDarkness) {
            cir.setReturnValue(false);
        }
    }
}
