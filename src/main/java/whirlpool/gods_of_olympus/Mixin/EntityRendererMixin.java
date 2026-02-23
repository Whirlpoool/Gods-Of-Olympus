package whirlpool.gods_of_olympus.Mixin;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whirlpool.gods_of_olympus.Items.HadesHelmOfDarkness;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin<T extends Entity> {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    public void isInvisibleCancel(T entity, Frustum camera, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player && player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HadesHelmOfDarkness && !player.hasEffect(MobEffects.GLOWING)) {
            cir.setReturnValue(false);
        }
    }
}
