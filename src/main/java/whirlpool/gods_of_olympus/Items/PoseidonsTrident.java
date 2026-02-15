package whirlpool.gods_of_olympus.Items;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;

public class PoseidonsTrident extends TridentItem {
    public PoseidonsTrident(Properties properties) {
        super(properties);
    }

    /**
     * Prevents the item from being consumed when used
     */
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.nextDamageWillBreak()) {
            return InteractionResult.FAIL;
        } else {
            player.startUsingItem(hand);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ThrownTrident throwntrident = new ThrownTrident(level, position.x(), position.y(), position.z(), itemStack);
        throwntrident.pickup = AbstractArrow.Pickup.DISALLOWED;

        return throwntrident;
    }
}
