package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootSubProvider extends FabricBlockLootSubProvider {
    public ModBlockLootSubProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.AZALEA_BUTTON);
        dropSelf(ModBlocks.AZALEA_FENCE);
        dropSelf(ModBlocks.AZALEA_FENCE_GATE);
        dropSelf(ModBlocks.AZALEA_LOG);
        dropSelf(ModBlocks.AZALEA_PLANKS);
        dropSelf(ModBlocks.AZALEA_PRESSURE_PLATE);
        dropSelf(ModBlocks.AZALEA_HANGING_SIGN);
        dropSelf(ModBlocks.AZALEA_SHELF);
        dropSelf(ModBlocks.AZALEA_SIGN);
        dropSelf(ModBlocks.AZALEA_STAIRS);
        dropSelf(ModBlocks.AZALEA_TRAPDOOR);
        dropSelf(ModBlocks.AZALEA_WALL_HANGING_SIGN);
        dropSelf(ModBlocks.AZALEA_WALL_SIGN);
        dropSelf(ModBlocks.AZALEA_WOOD);
        dropSelf(ModBlocks.STRIPPED_AZALEA_LOG);
        dropSelf(ModBlocks.STRIPPED_AZALEA_WOOD);

        add(ModBlocks.AZALEA_DOOR, this::createDoorTable);
        add(ModBlocks.AZALEA_SLAB, this::createSlabItemTable);
    }

    @Override
    public String getName() {
        return "Azalea Wood Block Loot Tables";
    }
}
