package net.firesteed.azaleawood.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.firesteed.azaleawood.AzaleaWood;
import net.firesteed.azaleawood.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

import static com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry.createKey;

public class ModItems {
    public static RegistryKey<TerraformBoatType> BOAT_KEY = createKey(new Identifier(AzaleaWood.MOD_ID, "azalea"));

    public static final Item AZALEA_BOAT = registerItem("azalea_boat",
                        new TerraformBoatItem(BOAT_KEY,
                        false, new FabricItemSettings().maxCount(1)));
    public static final Item AZALEA_CHEST_BOAT = registerItem("azalea_chest_boat",
                        new TerraformBoatItem(BOAT_KEY,
                        true, new FabricItemSettings().maxCount(1)));
    public static final Item AZALEA_SIGN = registerItem("azalea_sign", new SignItem(
            new FabricItemSettings().maxCount(16), ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_WALL_SIGN));
    public static final Item AZALEA_HANGING_SIGN = registerItem("azalea_hanging_sign", new HangingSignItem(
            ModBlocks.AZALEA_HANGING_SIGN, ModBlocks.AZALEA_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AzaleaWood.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.MANGROVE_HANGING_SIGN, AZALEA_SIGN);
        });
    }

    public static void registerModItems() {
        AzaleaWood.LOGGER.info("Registering Mod Items for " + AzaleaWood.MOD_ID);

        addItemsToItemGroup();
    }
}
