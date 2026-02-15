package whirlpool.gods_of_olympus.Items;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

public class PoseidonsTrident extends TridentItem {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 9.0F;
    public static final float PROJECTILE_SHOOT_POWER = 3.0F;

    public PoseidonsTrident(Properties properties) {
        super(properties);

    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)9.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)-2.9F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

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
