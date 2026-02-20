package whirlpool.gods_of_olympus.Registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Items.HadesHelmOfDarkness;
import whirlpool.gods_of_olympus.Items.HermesWingedSandals;
import whirlpool.gods_of_olympus.Items.PoseidonsTrident;
import whirlpool.gods_of_olympus.Renderer.ModRarities;

/**
 * Registry class for all items in the Gods of Olympus mod.
 * This class uses DeferredRegister to register items with the NeoForge
 * registry.
 */
public class ModItems {
    // DeferredRegister for Items. Acts as a holding list for all items before they are registered to the game.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gods_of_olympus.MODID);
    public static final ResourceKey<EquipmentAsset> OLYMPUS =  ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "olympus"));

    /**
     * Poseidon's Trident.
     * 
     * A custom legendary weapon implementation {@link PoseidonsTrident} that
     * defines specific behaviors.
     * 
     * Configured with:
     * Custom Rarity: {@link ModRarities#POSEIDON}
     * Durability: 1000 
     * Custom Attributes (e.g., Reach, Damage)
     * Tool properties (mining speed, etc.)
     * Weapon properties (attack damage, etc.)
     */
    public static final DeferredItem<Item> POSEIDONS_TRIDENT = ITEMS.registerItem("poseidons_trident",
            properties -> new PoseidonsTrident(
                    properties
                            .rarity(ModRarities.POSEIDON)
                            .durability(1000)
                            .attributes(PoseidonsTrident.createAttributes())
                            .component(DataComponents.TOOL, PoseidonsTrident.createToolProperties())
                            .enchantable(5)
                            .component(DataComponents.WEAPON, new Weapon(1))
            ));
    
    /**
     * Zeus's Master Bolt.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> ZEUS_MASTER_BOLT = ITEMS.registerItem("zeus_master_bolt",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.ZEUS)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Hades's Helm of Darkness.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> HADES_HELM_OF_DARKNESS = ITEMS.registerItem("hades_helm_of_darkness",
            properties -> new HadesHelmOfDarkness(
                    properties
                            .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.HEAD).setEquipSound(SoundEvents.ARMOR_EQUIP_NETHERITE)
                                    .setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hades_helm_of_darkness"))).build())
                            .rarity(ModRarities.HADES)
                            .attributes(HadesHelmOfDarkness.createAttributes())
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Aegis Shield of Athena.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> AEGIS_SHEILD_OF_ATHENA = ITEMS.registerItem("aegis_sheild_of_athena",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.ATHENA)
                            .durability(1000) //SUBJECT TO CHANGE
            ));
    
    /**
     * Apollo's Bow of Light.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> APOLLOS_BOW_OF_LIGHT = ITEMS.registerItem("apollos_bow_of_light",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.APOLLO)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Artemis's Bow of the Hunt.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> ARTEMIS_BOW_OF_THE_HUNT = ITEMS.registerItem("artemis_bow_of_the_hunt",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.ARTEMIS)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Ares's Spear of War.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> ARES_SPEAR_OF_WAR = ITEMS.registerItem("ares_spear_of_war",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.ARES)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Hermes's Winged Sandals.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> HERMES_WINGED_SANDALS = ITEMS.registerItem("hermes_winged_sandals",
            properties -> new HermesWingedSandals(
                    properties
                            .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.FEET).setEquipSound(SoundEvents.ARMOR_EQUIP_LEATHER)
                                    .setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID, "hermes_winged_sandals"))).build())
                            .rarity(ModRarities.HERMES)
                            .enchantable(15)
                            .attributes(HermesWingedSandals.createAttributes())
                            .durability(481) //SUBJECT TO CHANGE
            ));

    /**
     * Hephaestus's Hammer of Fire.
     * Currently registered as a generic Item with EPIC rarity.
     */
    public static final DeferredItem<Item> HEPHAESTUS_HAMMER_OF_FIRE = ITEMS.registerItem("hephaestus_hammer_of_fire",
            properties -> new Item(
                    properties
                            .rarity(ModRarities.HEPHAESTUS)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    /**
     * Registers the DeferredRegister to the event bus.
     * This method must be called in the main mod class constructor.
     *
     * @param eventBus The mod event bus
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
