package whirlpool.gods_of_olympus.Datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModItems;

import java.util.Set;
import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    private static Set<DeferredItem> customItemModels = Set.of(
            ModItems.POSEIDONS_TRIDENT
    );

    private static Set<DeferredItem> flatItemModels = Set.of(
            ModItems.HEPHAESTUS_HAMMER_OF_FIRE,
            ModItems.ARTEMIS_BOW_OF_THE_HUNT,
            ModItems.AEGIS_SHEILD_OF_ATHENA,
            ModItems.APOLLOS_BOW_OF_LIGHT,
            ModItems.ARES_SPEAR_OF_WAR,
            ModItems.HADES_HELM_OF_DARKNESS,
            ModItems.HERMES_WINGED_SANDALS,
            ModItems.ZEUS_MASTER_BOLT
    );

    public ModModelProvider(PackOutput output) {
        super(output, Gods_of_olympus.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for(DeferredItem<Item> item : flatItemModels) { itemModels.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM); }
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream().filter(x -> !customItemModels.contains(x));
    }
}
