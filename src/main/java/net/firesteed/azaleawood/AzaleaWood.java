package net.firesteed.azaleawood;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firesteed.azaleawood.block.ModBlocks;
import net.firesteed.azaleawood.item.ModItems;
import net.firesteed.azaleawood.util.ModFlammableBlocks;
import net.firesteed.azaleawood.util.ModStrippableBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;

public class AzaleaWood implements ModInitializer {
    public static final String MOD_ID = "azaleawood";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    protected static final Identifier SIGN_TEXTURE_ID = Identifier.of(AzaleaWood.MOD_ID, "entity/signs/azalea");
    protected static final Identifier HANGING_SIGN_TEXTURE_ID = Identifier.of(AzaleaWood.MOD_ID,
            "entity/signs/hanging/azalea");
    protected static final Identifier HANGING_SIGN_GUI_TEXTURE_ID = Identifier.of(AzaleaWood.MOD_ID,
            "textures/gui/hanging_signs/azalea");
    private static final Identifier AZALEA_SIGN_ID = Identifier.of(AzaleaWood.MOD_ID, "azalea_sign");
    private static final Identifier AZALEA_WALL_SIGN_ID = Identifier.of(AzaleaWood.MOD_ID, "azalea_wall_sign");
    private static final Identifier AZALEA_HANGING_SIGN_ID = Identifier.of(AzaleaWood.MOD_ID,
            "azalea_hanging_sign");
    private static final Identifier AZALEA_WALL_HANGING_SIGN_ID = Identifier.of(AzaleaWood.MOD_ID,
            "azalea_wall_hanging_sign");

    @Override
    public void onInitialize() {

        // Signs
        Block sign = new TerraformSignBlock(SIGN_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                .sounds(BlockSoundGroup.CHERRY_WOOD).registryKey(RegistryKey.of(RegistryKeys.BLOCK, AZALEA_SIGN_ID)));
        Registry.register(Registries.BLOCK, AZALEA_SIGN_ID, sign);

        Block wallSign = new TerraformWallSignBlock(SIGN_TEXTURE_ID, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                .sounds(BlockSoundGroup.CHERRY_WOOD).lootTable(sign.getLootTableKey()).registryKey(RegistryKey
                        .of(RegistryKeys.BLOCK, AZALEA_WALL_SIGN_ID)));
        Registry.register(Registries.BLOCK, AZALEA_WALL_SIGN_ID, wallSign);

        Block hangingSign = new TerraformHangingSignBlock(HANGING_SIGN_TEXTURE_ID, HANGING_SIGN_GUI_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.CHERRY_WOOD_HANGING_SIGN)
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, AZALEA_HANGING_SIGN_ID)));
        Registry.register(Registries.BLOCK, AZALEA_HANGING_SIGN_ID, hangingSign);

        Block wallHangingSign = new TerraformWallHangingSignBlock(HANGING_SIGN_TEXTURE_ID, HANGING_SIGN_GUI_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                        .sounds(BlockSoundGroup.CHERRY_WOOD_HANGING_SIGN).lootTable(hangingSign.getLootTableKey())
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, AZALEA_WALL_HANGING_SIGN_ID)));
        Registry.register(Registries.BLOCK, AZALEA_WALL_HANGING_SIGN_ID, wallHangingSign);

        SignItem signItem = new SignItem(sign, wallSign, new Item.Settings().maxCount(16).registryKey(RegistryKey
                .of(RegistryKeys.ITEM, AZALEA_SIGN_ID)));
        HangingSignItem hangingSignItem = new HangingSignItem(hangingSign, wallHangingSign, new Item.Settings()
                .maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, AZALEA_HANGING_SIGN_ID)));

        // Register
        signItem.appendBlocks(Item.BLOCK_ITEMS, signItem);
        hangingSignItem.appendBlocks(Item.BLOCK_ITEMS, hangingSignItem);

        Registry.register(Registries.ITEM, AZALEA_SIGN_ID, signItem);
        Registry.register(Registries.ITEM, AZALEA_HANGING_SIGN_ID, hangingSignItem);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.CHERRY_HANGING_SIGN, signItem, hangingSignItem);
        });

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();

        ModFlammableBlocks.registerFlammableBlocks();
        ModStrippableBlocks.registerStrippables();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.CHERRY_BUTTON, ModBlocks.AZALEA_LOG);
            entries.addAfter(ModBlocks.AZALEA_LOG, ModBlocks.AZALEA_WOOD);
            entries.addAfter(ModBlocks.AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG);
            entries.addAfter(ModBlocks.STRIPPED_AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_WOOD);
            entries.addAfter(ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.AZALEA_PLANKS);
            entries.addAfter(ModBlocks.AZALEA_PLANKS, ModBlocks.AZALEA_STAIRS);
            entries.addAfter(ModBlocks.AZALEA_STAIRS, ModBlocks.AZALEA_SLAB);
            entries.addAfter(ModBlocks.AZALEA_SLAB, ModBlocks.AZALEA_FENCE);
            entries.addAfter(ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_FENCE_GATE);
            entries.addAfter(ModBlocks.AZALEA_FENCE_GATE, ModBlocks.AZALEA_DOOR);
            entries.addAfter(ModBlocks.AZALEA_DOOR, ModBlocks.AZALEA_TRAPDOOR);
            entries.addAfter(ModBlocks.AZALEA_TRAPDOOR, ModBlocks.AZALEA_PRESSURE_PLATE);
            entries.addAfter(ModBlocks.AZALEA_PRESSURE_PLATE, ModBlocks.AZALEA_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.CHERRY_LOG, ModBlocks.AZALEA_LOG);
        });
    }
}
