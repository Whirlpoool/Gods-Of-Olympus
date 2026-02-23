package whirlpool.gods_of_olympus.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Gods_of_olympus.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.HADES_HELM_OF_DARKNESS.asItem())
                .add(ModItems.HERMES_WINGED_SANDALS.asItem())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.HADES_HELM_OF_DARKNESS.asItem())
        ;

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.HERMES_WINGED_SANDALS.asItem())
        ;

        tag(ItemTags.TRIDENT_ENCHANTABLE).add(ModItems.POSEIDONS_TRIDENT.asItem());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.POSEIDONS_TRIDENT.asItem());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.APOLLOS_BOW_OF_LIGHT.asItem())
                .add(ModItems.ARTEMIS_BOW_OF_THE_HUNT.asItem())
        ;
    }
}
