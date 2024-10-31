package net.firesteed.azaleawood.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firesteed.azaleawood.AzaleaWood;
import net.firesteed.azaleawood.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry.createKey;

public class ModItems {
    public static RegistryKey<TerraformBoatType> BOAT_KEY = createKey(id("azalea"));

    public static final Item AZALEA_BOAT = registerItem("azalea_boat",
                        new TerraformBoatItem(BOAT_KEY,
                        false, new Item.Settings().maxCount(1)));
    public static final Item AZALEA_CHEST_BOAT = registerItem("azalea_chest_boat",
                        new TerraformBoatItem(BOAT_KEY,
                        true, new Item.Settings().maxCount(1)));
    public static final Item AZALEA_SIGN = registerItem("azalea_sign", new SignItem(
            ModBlocks.AZALEA_WALL_SIGN, ModBlocks.AZALEA_SIGN, new Item.Settings().maxCount(16)));
    public static final Item AZALEA_HANGING_SIGN = registerItem("azalea_hanging_sign", new HangingSignItem(
            ModBlocks.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    public static void addItemsToItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.CHERRY_HANGING_SIGN, AZALEA_SIGN);
            entries.addAfter(AZALEA_SIGN, AZALEA_HANGING_SIGN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.CHERRY_CHEST_BOAT, AZALEA_BOAT);
            entries.addAfter(AZALEA_BOAT, AZALEA_CHEST_BOAT);
        });
    }

    public static void registerModItems() {
        AzaleaWood.LOGGER.info("Registering Mod Items for " + AzaleaWood.MOD_ID);

        addItemsToItemGroup();
    }

    private static Identifier id(String path) {
        return Identifier.of(AzaleaWood.MOD_ID, path);
    }
}
