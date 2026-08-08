package fire_horse27.azaleawood.tag;

import fire_horse27.azaleawood.AzaleaWood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> AZALEA_LOGS = ModItemTags.of("azalea_logs");

    private static TagKey<Item> of(String path) {
        return ModItemTags.of(Identifier.fromNamespaceAndPath(AzaleaWood.MOD_ID, path));
    }

    private static TagKey<Item> of(Identifier id) {
        return TagKey.create(Registries.ITEM, id);
    }
}
