package fire_horse27.azaleawood.item;

import fire_horse27.azaleawood.AzaleaWood;
import fire_horse27.azaleawood.block.ModBlocks;
import fire_horse27.azaleawood.util.TerraformCpyBoatItemHelperImpl;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.function.BiFunction;
import java.util.function.Function;

import static fire_horse27.azaleawood.AzaleaWood.MOD_ID;

public class ModItems {
    public static final Item AZALEA_SIGN = registerSignItem(
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

    private static Item registerSignItem(String name, StandingSignBlock sign, WallSignBlock wallSign) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);


        Item item = registerBlock(
                BlockItemId.create(Identifier.fromNamespaceAndPath(MOD_ID, name), Identifier.fromNamespaceAndPath(MOD_ID, name)),
                sign,
                (BiFunction)((b, p) -> new StandingAndWallBlockItem((Block) b, wallSign, Direction.DOWN, (Item.Properties) p)),
                (new Item.Properties())
                        .cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE)
                        .stacksTo(16)
                        .signText());

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

    public static BoatItem registerBoatItem(Identifier id, boolean chest) {
        return registerBoatItem(id, new Item.Properties().stacksTo(1), chest, false);
    }

    public static BoatItem registerBoatItem(Identifier id, Item.Properties properties, boolean chest, boolean raft) {
        return TerraformCpyBoatItemHelperImpl.registerBoatItem(id, properties, chest, raft);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(id.item(), (p) -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        AzaleaWood.LOGGER.debug("Registering ModItems for " + MOD_ID);
    }
}
