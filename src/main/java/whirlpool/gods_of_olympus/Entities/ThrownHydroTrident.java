package whirlpool.gods_of_olympus.Entities;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import whirlpool.gods_of_olympus.Registry.ModEffects;
import whirlpool.gods_of_olympus.Registry.ModEntities;

import java.util.Collection;
import java.util.List;

public class ThrownHydroTrident extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL;
    private static final float WATER_INERTIA = 0.99F;
    private static final boolean DEFAULT_DEALT_DAMAGE = false;
    private boolean dealtDamage = false;
    public int clientSideReturnTridentTickCount;

    public ThrownHydroTrident(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public ThrownHydroTrident(Level level, LivingEntity livingEntity, ItemStack stack) {
        super(ModEntities.THROWN_HYDRO_TRIDENT.get(), livingEntity, level, stack, null);
        this.entityData.set(ID_FOIL, stack.hasFoil());
        this.pickup = Pickup.DISALLOWED;
    }

    public ThrownHydroTrident(Level level, double x, double y, double z, ItemStack stack) {
        super(ModEntities.THROWN_HYDRO_TRIDENT.get(), x, y, z, level, stack, stack);
        this.entityData.set(ID_FOIL, stack.hasFoil());
        this.pickup = Pickup.DISALLOWED;
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 100) {
            this.discard();
        }

        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                Level level = this.level();
                if (level instanceof ServerLevel serverlevel) {
                    if (this.pickup == Pickup.ALLOWED) {
                        this.spawnAtLocation(serverlevel, this.getPickupItem(), 0.1F);
                    }
                }
                this.discard();
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        return entity != null && entity.isAlive() ? !(entity instanceof ServerPlayer) || !entity.isSpectator() : false;
    }

    public boolean isFoil() {
        return (Boolean)this.entityData.get(ID_FOIL);
    }

    protected @Nullable EntityHitResult findHitEntity(Vec3 p_479890_, Vec3 p_479868_) {
        return this.dealtDamage ? null : super.findHitEntity(p_479890_, p_479868_);
    }

    protected Collection<EntityHitResult> findHitEntities(Vec3 p_481064_, Vec3 p_480089_) {
        EntityHitResult entityhitresult = this.findHitEntity(p_481064_, p_480089_);
        return entityhitresult != null ? List.of(entityhitresult) : List.of();
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0F;
        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, (Entity)(entity1 == null ? this : entity1));
        Level level = this.level();
        if (level instanceof ServerLevel serverlevel) {
            f = EnchantmentHelper.modifyDamage(serverlevel, this.getWeaponItem(), entity, damagesource, f);
        }

        this.dealtDamage = true;
        if (entity.hurtOrSimulate(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            level = this.level();
            if (level instanceof ServerLevel) {
                ServerLevel serverlevel1 = (ServerLevel)level;
                EnchantmentHelper.doPostAttackEffectsWithItemSourceOnBreak(serverlevel1, entity, damagesource, this.getWeaponItem(), (p_478671_) -> this.kill(serverlevel1));
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;

                livingentity.addEffect(new MobEffectInstance(ModEffects.DROWNING, 50, 0, false, false, false));

                this.doKnockback(livingentity, damagesource);
                this.doPostHurtEffects(livingentity);
            }
        }

        this.deflect(ProjectileDeflection.REVERSE, entity, this.owner, false);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.01, 0.1, 0.01));
        this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
    }

    protected void hitBlockEnchantmentEffects(ServerLevel serverLevel, BlockHitResult blockHitResult, ItemStack itemStack) {
        Vec3 vec3 = blockHitResult.getBlockPos().clampLocationWithin(blockHitResult.getLocation());
        Entity owner1 = this.getOwner();
        LivingEntity livingEntity;
        if (owner1 instanceof LivingEntity livingentity) {
            livingEntity = livingentity;
        } else {
            livingEntity = null;
        }

        EnchantmentHelper.onHitBlock(serverLevel, itemStack, livingEntity, this, (EquipmentSlot)null, vec3, serverLevel.getBlockState(blockHitResult.getBlockPos()), (p_478806_) -> this.kill(serverLevel));
    }

    public ItemStack getWeaponItem() {
        return this.getPickupItemStackOrigin();
    }

    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public void playerTouch(Player player) {}

    protected void readAdditionalSaveData(ValueInput valueInput) {
        super.readAdditionalSaveData(valueInput);
        this.dealtDamage = valueInput.getBooleanOr("DealtDamage", false);
    }

    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        super.addAdditionalSaveData(valueOutput);
        valueOutput.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void tickDespawn() {
        if (this.pickup != Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double p_478379_, double p_480480_, double p_480806_) {
        return true;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        // This registers the ID_FOIL into the entity's data manager
        builder.define(ID_FOIL, false);
    }

    static {
        ID_FOIL = SynchedEntityData.defineId(ThrownHydroTrident.class, EntityDataSerializers.BOOLEAN);
    }
}
