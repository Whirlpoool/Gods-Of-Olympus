package whirlpool.gods_of_olympus.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModItems;
import whirlpool.gods_of_olympus.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Gods_of_olympus.MODID);
    }

    @Override
    protected void start() {
        add("poseidons_blessing_from_elder_guardian",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/elder_guardian")).build()
                }, ModItems.BLESSING_OF_POSEIDON.get()));

        add("hades_blessing_from_wither",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/wither")).build()
                }, ModItems.BLESSING_OF_HADES.get()));
    }
}
