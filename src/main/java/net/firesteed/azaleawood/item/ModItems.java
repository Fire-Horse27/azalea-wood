package net.firesteed.azaleawood.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firesteed.azaleawood.AzaleaWood;
import net.firesteed.azaleawood.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Identifier used consistently for boat registration and model layer registration
    public static final Identifier AZALEA = Identifier.of(AzaleaWood.MOD_ID, "azalea");

    public static Item AZALEA_BOAT;
    public static Item AZALEA_CHEST_BOAT;

    public static final SignItem AZALEA_SIGN = new SignItem(
            ModBlocks.AZALEA_SIGN,
            ModBlocks.AZALEA_WALL_SIGN,
            new Item.Settings().maxCount(16)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzaleaWood.MOD_ID, "azalea_sign")))
                    .useBlockPrefixedTranslationKey());

    public static final HangingSignItem AZALEA_HANGING_SIGN = new HangingSignItem(
            ModBlocks.AZALEA_HANGING_SIGN,
            ModBlocks.AZALEA_WALL_HANGING_SIGN,
            new Item.Settings().maxCount(16)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzaleaWood.MOD_ID, "azalea_hanging_sign")))
                    .useBlockPrefixedTranslationKey());

    public static void registerModItems() {
        AzaleaWood.LOGGER.info("Registering Mod Items for " + AzaleaWood.MOD_ID);

        // Register sign and hanging sign items
        Registry.register(
                Registries.ITEM,
                Identifier.of(AzaleaWood.MOD_ID, "azalea_sign"),
                AZALEA_SIGN
        );
        Registry.register(
                Registries.ITEM,
                Identifier.of(AzaleaWood.MOD_ID, "azalea_hanging_sign"),
                AZALEA_HANGING_SIGN
        );

        // Use the AZALEA identifier consistently to avoid mismatches
        AZALEA_BOAT = TerraformBoatItemHelper.registerBoatItem(
                AZALEA,
                new Item.Settings()
                        .maxCount(1)
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, AZALEA)),
                false,
                false
        );

        AZALEA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(
                AZALEA,
                new Item.Settings()
                        .maxCount(1)
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzaleaWood.MOD_ID, "azalea_chest_boat"))),
                true,
                false
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.CHERRY_CHEST_BOAT, AZALEA_BOAT);
            entries.addAfter(AZALEA_BOAT, AZALEA_CHEST_BOAT);
        });
    }
}
