package whirlpool.gods_of_olympus.Effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.Fluids;

public class DrowningEffect extends MobEffect {
    public DrowningEffect() {
        super(MobEffectCategory.HARMFUL, 0x1E90FF); // Blue color for drowning effect
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        // If they are out of water and trying to breathe, stop them.
        if (entity.getAirSupply() >= -20) {
            entity.setAirSupply(-20);

            if(entity.canDrownInFluidType(Fluids.WATER.getFluidType())) {
                level.broadcastEntityEvent(entity, (byte) 67);
                entity.hurtServer(level, entity.damageSources().drown(), 1.0F);
            }
        }
        // Return true so the effect continues to tick
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
