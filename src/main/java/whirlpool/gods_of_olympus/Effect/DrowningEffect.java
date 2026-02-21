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
                entity.hurtServer(level, entity.damageSources().drown(), 2.0F);
            }/*else if(entity instanceof Zombie zombie && !(entity instanceof Drowned)) {
                zombie.setInWaterTime(600);
                zombie.setConversionTime(3);
            }*///Problem for another day, this is supposed to turn zombies into drowned, but it doesn't work for some reason.
        }
        // Return true so the effect continues to tick
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int k = 20 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }
}
