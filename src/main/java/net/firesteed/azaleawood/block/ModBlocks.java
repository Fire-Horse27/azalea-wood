package net.firesteed.azaleawood.block;

import net.firesteed.azaleawood.AzaleaWood;
import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final BlockSetType AZALEA = new BlockSetType("azalea", true, true, true,
            BlockSetType.ActivationRule.EVERYTHING, BlockSoundGroup.CHERRY_WOOD,
            SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE, SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON);
    public static final Block AZALEA_BUTTON = register("azalea_button", (settings) -> {
        return new ButtonBlock(AZALEA, 30, settings);
    }, Blocks.createButtonSettings());
    public static final Block AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate", (settings) -> {
        return new PressurePlateBlock(AZALEA, settings);
    }, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_TRAPDOOR = register("azalea_trapdoor", (settings) -> {
        return new TrapdoorBlock(AZALEA, settings);
    }, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_DOOR = register("azalea_door", (settings) -> {
        return new DoorBlock(AZALEA, settings);
    }, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final WoodType AZALEA_TYPE = new WoodType("azalea", AZALEA, BlockSoundGroup.CHERRY_WOOD,
            BlockSoundGroup.CHERRY_WOOD_HANGING_SIGN, SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN);
    public static final Block AZALEA_FENCE_GATE = register("azalea_fence_gate", (settings) -> {
        return new FenceGateBlock(AZALEA_TYPE, settings);
    }, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_FENCE = register("azalea_fence", FenceBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_PLANKS = register("azalea_planks", Block::new,
            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_SLAB = register("azalea_slab", SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_STAIRS = register("azalea_stairs", (settings) -> {
        return new StairsBlock(AZALEA_PLANKS.getDefaultState(), settings);
    }, AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block AZALEA_WOOD = register("azalea_wood", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.RAW_IRON_PINK)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block AZALEA_LOG = register("azalea_log", PillarBlock::new, Blocks.createLogSettings(
            MapColor.RAW_IRON_PINK, MapColor.TERRACOTTA_GRAY, BlockSoundGroup.CHERRY_WOOD));

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AzaleaWood.MOD_ID, path));

        final Block block = Blocks.register(registryKey, factory, settings);
        if (!path.contains("sign")) {
            Items.register(block);
        }
        return block;
    }

    public static void registerModBlocks() {
        AzaleaWood.LOGGER.debug("Registering ModBlocks for " + AzaleaWood.MOD_ID);
    }
}
