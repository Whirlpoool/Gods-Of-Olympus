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

/**
 * A custom trident item representing Poseidon's Trident.
 * <p>
 * This class extends the vanilla {@link TridentItem} to provide custom
 * attribute modifiers, use behavior, and projectile creation for the
 * PoseidonsTrident item.
 */
public class PoseidonsTrident extends TridentItem {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 9.0F;
    public static final float PROJECTILE_SHOOT_POWER = 3.0F;

    /**
     * Creates a new PoseidonsTrident instance.
     *
     * @param properties item properties passed to the superclass constructor
     */
    public PoseidonsTrident(Properties properties) {
        super(properties);

    }

    /**
     * Build and return the attribute modifiers for this trident when equipped.
     * <p>
     * The returned {@link ItemAttributeModifiers} configures the main-hand
     * attack damage and attack speed modifiers for the item.
     *
     * @return an {@link ItemAttributeModifiers} instance containing the attack
     *         damage and attack speed modifiers for the main hand
     */
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)9.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)-2.9F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    /**
     * Handle right-click use of the trident.
     * <p>
     * If the item is about to break, usage fails. Otherwise the player begins
     * using the item (charging/aiming) and the method returns {@link InteractionResult#SUCCESS}.
     *
     * @param level the world the player is in
     * @param player the player using the item
     * @param hand the hand in which the item is held
     * @return {@link InteractionResult#FAIL} if the item would break when used,
     *         otherwise {@link InteractionResult#SUCCESS} after starting use
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

    /**
     * Create the projectile entity for this trident when thrown.
     * <p>
     * This method creates a vanilla {@link ThrownTrident} at the provided
     * position and disables pickup (so players cannot retrieve thrown tridents).
     *
     * @param level the world to spawn the projectile in
     * @param position the spawn position information
     * @param itemStack the trident item stack used to construct the projectile
     * @param direction the direction the projectile will be fired (unused by this implementation)
     * @return a {@link Projectile} instance representing the thrown trident
     */
    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ThrownTrident throwntrident = new ThrownTrident(level, position.x(), position.y(), position.z(), itemStack);
        throwntrident.pickup = AbstractArrow.Pickup.DISALLOWED;

        return throwntrident;
    }
}
