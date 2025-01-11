package net.firesteed.azaleawood.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firesteed.azaleawood.AzaleaWood;
import net.firesteed.azaleawood.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;

public class ModItems {
    public static final Identifier AZALEA = Identifier.of(AzaleaWood.MOD_ID, "azalea");
    public static final Item AZALEA_BOAT = TerraformBoatItemHelper.registerBoatItem(AZALEA, false);
    public static final Item AZALEA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(AZALEA, true);

    /*public static final Item AZALEA_SIGN = registerBiBlock(ModBlocks.AZALEA_SIGN, (block, settings) -> {
        return new SignItem(block, ModBlocks.AZALEA_WALL_SIGN, settings);
    }, new Item.Settings().maxCount(16));
    public static final Item AZALEA_HANGING_SIGN = registerBiBlock(ModBlocks.AZALEA_HANGING_SIGN, (block, settings) -> {
        return new SignItem(block, ModBlocks.AZALEA_WALL_HANGING_SIGN, settings);
    }, new Item.Settings().maxCount(16));

    public static Item registerBiBlock(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(block, factory, settings);
    }*/

    public static void addItemsToItemGroup() {
        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.CHERRY_HANGING_SIGN, AZALEA_SIGN);
            entries.addAfter(AZALEA_SIGN, AZALEA_HANGING_SIGN);
        });*/
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.CHERRY_CHEST_BOAT, AZALEA_BOAT);
            entries.addAfter(AZALEA_BOAT, AZALEA_CHEST_BOAT);
        });
    }

    public static void registerModItems() {
        AzaleaWood.LOGGER.info("Registering Mod Items for " + AzaleaWood.MOD_ID);

        addItemsToItemGroup();
    }
}
