package whirlpool.gods_of_olympus.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class HadesInvisEffect extends MobEffect {
    public HadesInvisEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFFAF0);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return false;
    }
}
