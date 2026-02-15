package whirlpool.gods_of_olympus.Registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Weapon;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Items.PoseidonsTrident;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gods_of_olympus.MODID);

    public static final DeferredItem<Item> POSEIDONS_TRIDENT = ITEMS.registerItem("poseidons_trident",
            properties -> new PoseidonsTrident(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000)
                            .attributes(PoseidonsTrident.createAttributes())
                            .component(DataComponents.TOOL, PoseidonsTrident.createToolProperties())
                            .enchantable(5)
                            .component(DataComponents.WEAPON, new Weapon(1))
            )); //Create a new PoseidonsTrident Item called "poseidons_trident" and set its rarity to EPIC

    public static final DeferredItem<Item> ZEUS_MASTER_BOLT = ITEMS.registerItem("zeus_master_bolt",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> HADES_HELM_OF_DARKNESS = ITEMS.registerItem("hades_helm_of_darkness",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> AEGIS_SHEILD_OF_ATHENA = ITEMS.registerItem("aegis_sheild_of_athena",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> APOLLOS_BOW_OF_LIGHT = ITEMS.registerItem("apollos_bow_of_light",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> ARTEMIS_BOW_OF_THE_HUNT = ITEMS.registerItem("artemis_bow_of_the_hunt",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> ARES_SPEAR_OF_WAR = ITEMS.registerItem("ares_spear_of_war",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> HERMES_WINGED_SANDALS = ITEMS.registerItem("hermes_winged_sandals",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static final DeferredItem<Item> HEPHAESTUS_HAMMER_OF_FIRE = ITEMS.registerItem("hephaestus_hammer_of_fire",
            properties -> new Item(
                    properties
                            .rarity(Rarity.EPIC)
                            .durability(1000) //SUBJECT TO CHANGE
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
