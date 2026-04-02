package fire_horse27.azaleawood.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import fire_horse27.azaleawood.AzaleaWood;
import fire_horse27.azaleawood.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;

import static fire_horse27.azaleawood.AzaleaWood.MOD_ID;

public class ModItems {
    public static final SignItem AZALEA_SIGN = registerSignItem(
            "azalea_sign",
            ModBlocks.AZALEA_SIGN,
            ModBlocks.AZALEA_WALL_SIGN
    );

    public static final HangingSignItem AZALEA_HANGING_SIGN = registerHangingSignItem(
            "azalea_hanging_sign",
            ModBlocks.AZALEA_HANGING_SIGN,
            ModBlocks.AZALEA_WALL_HANGING_SIGN
    );

    public static BoatItem AZALEA_BOAT = registerBoatItem(AzaleaWood.AZALEA_BOATS_ID, false);
    public static BoatItem AZALEA_CHEST_BOAT = registerBoatItem(AzaleaWood.AZALEA_BOATS_ID, true);

    private static SignItem registerSignItem(String name, StandingSignBlock sign, WallSignBlock wallSign) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);

        SignItem item = new SignItem(
                sign,
                wallSign,
                new Item.Properties()
                        .stacksTo(16)
                        .setId(ResourceKey.create(Registries.ITEM, id))
                        .useBlockDescriptionPrefix()
        );

        Registry.register(BuiltInRegistries.ITEM, id, item);
        item.registerBlocks(Item.BY_BLOCK, item);

        return item;
    }

    private static HangingSignItem registerHangingSignItem(
            String name,
            CeilingHangingSignBlock sign,
            WallHangingSignBlock wallSign
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);

        HangingSignItem item = new HangingSignItem(
                sign,
                wallSign,
                new Item.Properties()
                        .stacksTo(16)
                        .setId(ResourceKey.create(Registries.ITEM, id))
                        .useBlockDescriptionPrefix()
        );

        Registry.register(BuiltInRegistries.ITEM, id, item);
        item.registerBlocks(Item.BY_BLOCK, item);

        return item;
    }

    private static BoatItem registerBoatItem(Identifier id, boolean chest) {
        return TerraformBoatItemHelper.registerBoatItem(id, chest);
    }

    public static void registerModItems() {
        AzaleaWood.LOGGER.debug("Registering ModItems for " + MOD_ID);
    }
}
