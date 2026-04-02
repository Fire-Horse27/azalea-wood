package fire_horse27.azaleawood.block;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import fire_horse27.azaleawood.AzaleaWood;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

import static fire_horse27.azaleawood.AzaleaWood.MOD_ID;
import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final BlockSetType AZALEA = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY)
            .register(Identifier.fromNamespaceAndPath(MOD_ID, "azalea"));
    public static final WoodType AZALEA_TYPE = WoodTypeBuilder.copyOf(WoodType.CHERRY)
            .register(Identifier.fromNamespaceAndPath(MOD_ID, "azalea"), AZALEA);

    public static final Block AZALEA_LOG = register("azalea_log", RotatedPillarBlock::new,
            logProperties(MapColor.TERRACOTTA_GRAY, MapColor.RAW_IRON, SoundType.CHERRY_WOOD));
    public static final Block AZALEA_WOOD = register("azalea_wood", RotatedPillarBlock::new,
            BlockBehaviour.Properties.ofFullCopy(CHERRY_WOOD).mapColor(MapColor.RAW_IRON));
    public static final Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", RotatedPillarBlock::new,
            logProperties(MapColor.TERRACOTTA_GRAY, MapColor.TERRACOTTA_GRAY, SoundType.CHERRY_WOOD));
    public static final Block STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", RotatedPillarBlock::new,
            BlockBehaviour.Properties.ofFullCopy(STRIPPED_CHERRY_WOOD).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_PLANKS = register("azalea_planks", Block::new,
            BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block AZALEA_STAIRS = register("azalea_stairs",
            p -> new StairBlock(AZALEA_PLANKS.defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS));
    public static final Block AZALEA_SLAB = register("azalea_slab", SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(CHERRY_SLAB).mapColor(MapColor.TERRACOTTA_GRAY));

    public static final Block AZALEA_FENCE = register("azalea_fence", FenceBlock::new,
            BlockBehaviour.Properties.ofFullCopy(CHERRY_FENCE).mapColor(AZALEA_PLANKS.defaultMapColor()));
    public static final Block AZALEA_FENCE_GATE = register("azalea_fence_gate",
            p -> new FenceGateBlock(WoodType.CHERRY, p),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_FENCE_GATE).mapColor(AZALEA_PLANKS.defaultMapColor()));

    public static final StandingSignBlock AZALEA_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MOD_ID, "azalea_sign"),
            properties -> new StandingSignBlock(AZALEA_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_SIGN).mapColor(AZALEA_PLANKS.defaultMapColor()));
    public static final WallSignBlock AZALEA_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MOD_ID, "azalea_wall_sign"),
            properties -> new WallSignBlock(AZALEA_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_WALL_SIGN)
                    .mapColor(AZALEA_PLANKS.defaultMapColor()).overrideLootTable(AZALEA_SIGN.getLootTable()));
    public static final CeilingHangingSignBlock AZALEA_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MOD_ID, "azalea_hanging_sign"),
            properties -> new CeilingHangingSignBlock(AZALEA_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_HANGING_SIGN).mapColor(AZALEA_PLANKS.defaultMapColor()));
    public static final WallHangingSignBlock AZALEA_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MOD_ID, "azalea_wall_hanging_sign"),
            properties -> new WallHangingSignBlock(AZALEA_TYPE, properties),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_WALL_HANGING_SIGN).mapColor(
                    AZALEA_PLANKS.defaultMapColor()).overrideLootTable(AZALEA_HANGING_SIGN.getLootTable()));

    public static final Block AZALEA_DOOR = register("azalea_door",
            p -> new DoorBlock(BlockSetType.CHERRY, p),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_DOOR).mapColor(AZALEA_PLANKS.defaultMapColor()));
    public static final Block AZALEA_TRAPDOOR = register("azalea_trapdoor",
            p -> new TrapDoorBlock(BlockSetType.CHERRY, p),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_TRAPDOOR).mapColor(AZALEA_PLANKS.defaultMapColor()));

    public static final Block AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate",
            p -> new PressurePlateBlock(AZALEA, p),
            BlockBehaviour.Properties.ofFullCopy(CHERRY_PRESSURE_PLATE).mapColor(AZALEA_PLANKS.defaultMapColor()));
    public static final Block AZALEA_BUTTON = register("azalea_button",
            p -> new ButtonBlock(AZALEA, 30, p), buttonProperties());

    public static final Block AZALEA_SHELF = register("azalea_shelf", ShelfBlock::new,
            BlockBehaviour.Properties.ofFullCopy(CHERRY_SHELF).mapColor(AZALEA_PLANKS.defaultMapColor()));

    private static Block register(
            String id,
            Function<BlockBehaviour.Properties, Block> factory,
            BlockBehaviour.Properties properties
    ) {
        Identifier identifier = Identifier.fromNamespaceAndPath(MOD_ID, id);

        // Create block
        Block block = factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, identifier)));

        // Create item
        BlockItem item = new BlockItem(block,
                new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, identifier))
                        .useBlockDescriptionPrefix()
        );

        // Register both
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        Registry.register(BuiltInRegistries.ITEM, identifier, item);
        item.registerBlocks(Item.BY_BLOCK, item);

        return block;
    }

    public static void registerModBlocks() {
        AzaleaWood.LOGGER.debug("Registering ModBlocks for " + MOD_ID);

        BlockEntityType.SHELF.addValidBlock(AZALEA_SHELF);
    }
}
