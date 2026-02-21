package whirlpool.gods_of_olympus.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import whirlpool.gods_of_olympus.Gods_of_olympus;
import whirlpool.gods_of_olympus.Registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }


    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.POSEIDONS_TRIDENT)
                .pattern("GOG")
                .pattern(" B ")
                .pattern(" S ")
                .define('S', Items.HEART_OF_THE_SEA)
                .define('G', Items.GOLD_BLOCK)
                .define('B', ModItems.BLESSING_OF_POSEIDON)
                .define('O', ModItems.BLESSING_OF_OLYMPUS)
                .unlockedBy("has_poseidons_blessing", has(ModItems.BLESSING_OF_POSEIDON)).save(output);

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.BLESSING_OF_OLYMPUS), //Template
                Ingredient.of(Items.NETHERITE_HELMET), //Base
                Ingredient.of(ModItems.BLESSING_OF_HADES), //Addition
                RecipeCategory.COMBAT,
                ModItems.HADES_HELM_OF_DARKNESS.get()
        ).unlocks("has_blessing_of_hades", has(ModItems.BLESSING_OF_HADES)).save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID,
                "hades_helm_of_darkness_smithing")));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.BLESSING_OF_OLYMPUS), //Template
                Ingredient.of(Items.NETHERITE_BOOTS), //Base
                Ingredient.of(ModItems.BLESSING_OF_HERMES), //Addition
                RecipeCategory.COMBAT,
                ModItems.HERMES_WINGED_SANDALS.get()
        ).unlocks("has_blessing_of_hermes", has(ModItems.BLESSING_OF_HERMES)).save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Gods_of_olympus.MODID,
                "hermes_winged_sandals_smithing")));
    }
}
