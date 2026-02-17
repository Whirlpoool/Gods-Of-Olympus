package whirlpool.gods_of_olympus.Items;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jspecify.annotations.Nullable;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModEffects;

public class HermesWingedSandals extends Item implements IItemExtension {
    public HermesWingedSandals(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hermes_armor"), (double) 3.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hermes_armor_toughness"), (double) 3.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hermes_knockback_resistance"), (double) 0.10F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET).build();
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if(entity instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof HermesWingedSandals hermesWingedSandals) {
            if(player.onGround()) {
                player.addEffect(new MobEffectInstance(ModEffects.FLIGHT, MobEffectInstance.INFINITE_DURATION, 0, false, false, false)); // Reset flight time when on the ground
            }else if(!player.onGround() && player.getEffect(ModEffects.FLIGHT) != null && player.getEffect(ModEffects.FLIGHT).isInfiniteDuration()) {
                player.removeEffect(ModEffects.FLIGHT);
                player.addEffect(new MobEffectInstance(ModEffects.FLIGHT, 1200, 0, false, false, false));
            }
        }
    }
}
