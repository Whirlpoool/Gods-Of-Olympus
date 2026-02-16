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
import org.jspecify.annotations.Nullable;
import whirlpool.gods_of_olympus.Gods_of_olympus;

public class HadesHelmOfDarkness extends Item {
    public HadesHelmOfDarkness(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hades_armor"), (double) 3.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hades_armor_toughness"), (double) 3.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hades_knockback_resistance"), (double) 0.10F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD).build();
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HadesHelmOfDarkness && !player.hasEffect(MobEffects.INVISIBILITY)) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1, 0, false, false, false));
            }
        }
    }
}