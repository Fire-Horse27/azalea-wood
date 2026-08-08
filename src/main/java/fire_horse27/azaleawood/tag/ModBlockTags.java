package fire_horse27.azaleawood.tag;

import fire_horse27.azaleawood.AzaleaWood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> AZALEA_LOGS = ModBlockTags.of("azalea_logs");

    private static TagKey<Block> of(String path) {
        return ModBlockTags.of(Identifier.fromNamespaceAndPath(AzaleaWood.MOD_ID, path));
    }

    private static TagKey<Block> of(Identifier id) {
        return TagKey.create(Registries.BLOCK, id);
    }
}
