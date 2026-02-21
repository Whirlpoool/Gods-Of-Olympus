package whirlpool.gods_of_olympus.Items;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import whirlpool.gods_of_olympus.Entities.ThrownHydroTrident;

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

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int p_43397_) {
        if (livingEntity instanceof Player player) {
            int i = this.getUseDuration(stack, livingEntity) - p_43397_;
            if (i < 10) {
                return false;
            } else {
                float f = EnchantmentHelper.getTridentSpinAttackStrength(stack, player);
                if (f > 0.0F && !player.isInWaterOrRain()) {
                    return false;
                } else if (stack.nextDamageWillBreak()) {
                    return false;
                } else {
                    Holder<SoundEvent> holder = (Holder)EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (level instanceof ServerLevel) {
                        ServerLevel serverlevel = (ServerLevel)level;
                        stack.hurtWithoutBreaking(1, player);
                        if (f == 0.0F) {
                            ThrownHydroTrident throwntrident = (ThrownHydroTrident) Projectile.spawnProjectileFromRotation(ThrownHydroTrident::new, serverlevel, stack, player, 0.0F, 2.5F, 1.0F);
                            if (player.hasInfiniteMaterials()) {
                                throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            level.playSound((Entity)null, throwntrident, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            return true;
                        }
                    }

                    if (f > 0.0F) {
                        float f7 = player.getYRot();
                        float f1 = player.getXRot();
                        float f2 = -Mth.sin((double)(f7 * ((float)Math.PI / 180F))) * Mth.cos((double)(f1 * ((float)Math.PI / 180F)));
                        float f3 = -Mth.sin((double)(f1 * ((float)Math.PI / 180F)));
                        float f4 = Mth.cos((double)(f7 * ((float)Math.PI / 180F))) * Mth.cos((double)(f1 * ((float)Math.PI / 180F)));
                        float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
                        f2 *= f / f5;
                        f3 *= f / f5;
                        f4 *= f / f5;
                        player.push((double)f2, (double)f3, (double)f4);
                        player.startAutoSpinAttack(20, 8.0F, stack);
                        if (player.onGround()) {
                            float f6 = 1.1999999F;
                            player.move(MoverType.SELF, new Vec3((double)0.0F, (double)1.1999999F, (double)0.0F));
                        }

                        level.playSound((Entity)null, player, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
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
        ThrownHydroTrident throwntrident = new ThrownHydroTrident(level, position.x(), position.y(), position.z(), itemStack);

        return throwntrident;
    }
}
