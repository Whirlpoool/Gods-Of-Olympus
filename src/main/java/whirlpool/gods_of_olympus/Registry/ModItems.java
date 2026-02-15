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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
