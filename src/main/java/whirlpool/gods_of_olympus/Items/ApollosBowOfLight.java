package whirlpool.gods_of_olympus.Items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.BowItem;
import org.jspecify.annotations.Nullable;

public class ApollosBowOfLight extends BowItem {
    public ApollosBowOfLight(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        super.shootProjectile(shooter, projectile, index, velocity, inaccuracy, angle, target);
        if(projectile instanceof AbstractArrow arrow) {
            arrow.setBaseDamage(arrow.baseDamage * 1.25f);
        }
    }
}
