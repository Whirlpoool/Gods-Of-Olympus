package whirlpool.gods_of_olympus.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FlightEffect extends MobEffect {
    public FlightEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFFAF0);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return false;
    }
}
