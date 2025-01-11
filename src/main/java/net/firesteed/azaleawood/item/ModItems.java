package net.firesteed.azaleawood.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firesteed.azaleawood.AzaleaWood;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Identifier AZALEA = Identifier.of(AzaleaWood.MOD_ID, "azalea");
    public static final Item AZALEA_BOAT = TerraformBoatItemHelper.registerBoatItem(AZALEA, false);
    public static final Item AZALEA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(AZALEA, true);

    public static void addItemsToItemGroup() {
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
