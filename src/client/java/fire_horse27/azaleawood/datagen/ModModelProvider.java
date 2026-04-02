package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createShelf(ModBlocks.AZALEA_SHELF, ModBlocks.STRIPPED_AZALEA_LOG);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {

    }
}
