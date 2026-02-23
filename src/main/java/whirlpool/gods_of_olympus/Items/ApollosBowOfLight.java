package whirlpool.gods_of_olympus.Items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.jspecify.annotations.Nullable;

public class ApollosBowOfLight extends BowItem {
    public ApollosBowOfLight(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        super.shootProjectile(shooter, projectile, index, velocity, inaccuracy, angle, target);
        if(projectile instanceof Arrow arrow) {
            arrow.baseDamage *= 1.15f;

            PotionContents potionContents = arrow.getPickupItemStackOrigin().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);

            boolean hasBlindness = false;
            boolean hasGlowing = false;

            for(MobEffectInstance effect : potionContents.getAllEffects()) {
                if(effect.getEffect() == MobEffects.BLINDNESS) hasBlindness = true;
                if(effect.getEffect() == MobEffects.GLOWING) hasGlowing = true;
            }

            if(!hasBlindness && !hasGlowing) {
                arrow.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 150, 1, false, false, true));
                arrow.addEffect(new MobEffectInstance(MobEffects.GLOWING, 500, 0, false, false, true));
            }
        }
    }
}
