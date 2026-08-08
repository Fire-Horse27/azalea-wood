package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.block.ModBlocks;
import fire_horse27.azaleawood.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.family(ModBlocks.AZALEA_FAMILY.getBaseBlock()).generateFor(ModBlocks.AZALEA_FAMILY);
        generator.createShelf(ModBlocks.AZALEA_SHELF, ModBlocks.STRIPPED_AZALEA_LOG);
        generator.woodProvider(ModBlocks.AZALEA_LOG).logWithHorizontal(ModBlocks.AZALEA_LOG).wood(ModBlocks.AZALEA_WOOD);
        generator.woodProvider(ModBlocks.STRIPPED_AZALEA_LOG).logWithHorizontal(ModBlocks.STRIPPED_AZALEA_LOG).wood(ModBlocks.STRIPPED_AZALEA_WOOD);
        this.registerBlockItemModel(generator, ModBlocks.AZALEA_FENCE_GATE);
        this.registerBlockItemModel(generator, ModBlocks.AZALEA_PLANKS);
        this.registerBlockItemModel(generator, ModBlocks.AZALEA_PRESSURE_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(ModItems.AZALEA_BOAT, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(ModItems.AZALEA_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }

    private void registerBlockItemModel(BlockModelGenerators generator, Block block) {
        generator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block));
    }

    @Override
    public String getName() {
        return "Azalea Wood Models";
    }
}
