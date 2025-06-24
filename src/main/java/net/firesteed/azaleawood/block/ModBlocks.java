package net.firesteed.azaleawood.block;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.firesteed.azaleawood.AzaleaWood;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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

    public static final Block AZALEA_BUTTON = register("azalea_button", (settings) ->
            new ButtonBlock(AZALEA, 30, settings), Blocks.createButtonSettings());
    public static final Block AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate", (settings) ->
            new PressurePlateBlock(AZALEA, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_PRESSURE_PLATE)
            .mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_TRAPDOOR = register("azalea_trapdoor", (settings) ->
            new TrapdoorBlock(AZALEA, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_TRAPDOOR)
            .mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_DOOR = register("azalea_door", (settings) ->
            new DoorBlock(AZALEA, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_DOOR)
            .mapColor(MapColor.TERRACOTTA_GRAY));

    public static final WoodType AZALEA_TYPE = WoodTypeBuilder.copyOf(WoodType.CHERRY)
            .register(Identifier.of(AzaleaWood.MOD_ID, "azalea"),
                    BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY)
                            .register(Identifier.of(AzaleaWood.MOD_ID, "azalea")));

    public static final SignBlock AZALEA_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.of(AzaleaWood.MOD_ID, "azalea_sign"),
            settings -> new SignBlock(AZALEA_TYPE, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_SIGN)
                    .mapColor(MapColor.TERRACOTTA_GRAY));
    public static final WallSignBlock AZALEA_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.of(AzaleaWood.MOD_ID, "azalea_wall_sign"),
            settings -> new WallSignBlock(AZALEA_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.CHERRY_WALL_SIGN).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final HangingSignBlock AZALEA_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.of(AzaleaWood.MOD_ID, "azalea_hanging_sign"),
            settings -> new HangingSignBlock(AZALEA_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.CHERRY_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final WallHangingSignBlock AZALEA_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.of(AzaleaWood.MOD_ID, "azalea_wall_hanging_sign"),
            settings -> new WallHangingSignBlock(AZALEA_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.CHERRY_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_FENCE_GATE = register("azalea_fence_gate", (settings) ->
            new FenceGateBlock(AZALEA_TYPE, settings), AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE_GATE)
            .mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_FENCE = register("azalea_fence", FenceBlock::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_PLANKS = register("azalea_planks", Block::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_SLAB = register("azalea_slab", SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_SLAB).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_STAIRS = register("azalea_stairs", (settings) ->
            new StairsBlock(AZALEA_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.CHERRY_STAIRS)
            .mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_LOG).mapColor(MapColor.TERRACOTTA_GRAY)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block AZALEA_WOOD = register("azalea_wood", PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).mapColor(MapColor.RAW_IRON_PINK)
                    .sounds(BlockSoundGroup.CHERRY_WOOD));
    public static final Block AZALEA_LOG = register("azalea_log", PillarBlock::new, Blocks.createLogSettings(
            MapColor.RAW_IRON_PINK, MapColor.TERRACOTTA_GRAY, BlockSoundGroup.CHERRY_WOOD));

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(AzaleaWood.MOD_ID, name);
        settings.registryKey(net.minecraft.registry.RegistryKey.of(net.minecraft.registry.RegistryKeys.BLOCK, id));
        Block block = Registry.register(Registries.BLOCK, id, factory.apply(settings));
        Item.Settings itemSettings = new Item.Settings()
                .registryKey(net.minecraft.registry.RegistryKey.of(net.minecraft.registry.RegistryKeys.ITEM, id))
                .useBlockPrefixedTranslationKey();
        Registry.register(Registries.ITEM, id, new BlockItem(block, itemSettings));
        return block;
    }

    public static void registerModBlocks() {
        AzaleaWood.LOGGER.debug("Registering ModBlocks for " + AzaleaWood.MOD_ID);
    }
}