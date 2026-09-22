package fire_horse27.azaleawood.util;

import fire_horse27.azaleawood.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        BlockTransformerHelper.registerStripping(ModBlocks.AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_LOG);
        BlockTransformerHelper.registerStripping(ModBlocks.AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_WOOD);
    }
}