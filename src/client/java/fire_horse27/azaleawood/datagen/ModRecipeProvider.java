package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.AzaleaWood;
import fire_horse27.azaleawood.block.ModBlocks;
import fire_horse27.azaleawood.item.ModItems;
import fire_horse27.azaleawood.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                FeatureFlagSet enabledFeatures = FeatureFlagSet.of(FeatureFlags.VANILLA);
                generateRecipes(ModBlocks.AZALEA_FAMILY, enabledFeatures);
                woodFromLogs(ModBlocks.AZALEA_WOOD, ModBlocks.AZALEA_LOG);
                woodFromLogs(ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG);
                woodenBoat(ModItems.AZALEA_BOAT, ModBlocks.AZALEA_PLANKS);
                chestBoat(ModItems.AZALEA_CHEST_BOAT, ModItems.AZALEA_BOAT);
                shelf(ModBlocks.AZALEA_SHELF, ModBlocks.STRIPPED_AZALEA_LOG);
            }
        };
    }

    @Override
    public String getName() {
        return "Azalea Wood Recipes";
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.fromNamespaceAndPath(AzaleaWood.MOD_ID, identifier.getPath());
    }
}
