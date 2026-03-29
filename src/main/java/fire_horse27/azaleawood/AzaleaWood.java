package fire_horse27.azaleawood;

import fire_horse27.azaleawood.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzaleaWood implements ModInitializer {
	public static final String MOD_ID = "azaleawood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
//		ModItems.registerModItems();
//
//		ModFlammableBlocks.registerFlammableBlocks();
//		ModStrippableBlocks.registerStrippables();
//
//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//			entries.addAfter(Blocks.CHERRY_BUTTON, ModBlocks.AZALEA_LOG);
//			entries.addAfter(ModBlocks.AZALEA_LOG, ModBlocks.AZALEA_WOOD);
//			entries.addAfter(ModBlocks.AZALEA_WOOD, ModBlocks.STRIPPED_AZALEA_LOG);
//			entries.addAfter(ModBlocks.STRIPPED_AZALEA_LOG, ModBlocks.STRIPPED_AZALEA_WOOD);
//			entries.addAfter(ModBlocks.STRIPPED_AZALEA_WOOD, ModBlocks.AZALEA_PLANKS);
//			entries.addAfter(ModBlocks.AZALEA_PLANKS, ModBlocks.AZALEA_STAIRS);
//			entries.addAfter(ModBlocks.AZALEA_STAIRS, ModBlocks.AZALEA_SLAB);
//			entries.addAfter(ModBlocks.AZALEA_SLAB, ModBlocks.AZALEA_FENCE);
//			entries.addAfter(ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_FENCE_GATE);
//			entries.addAfter(ModBlocks.AZALEA_FENCE_GATE, ModBlocks.AZALEA_DOOR);
//			entries.addAfter(ModBlocks.AZALEA_DOOR, ModBlocks.AZALEA_TRAPDOOR);
//			entries.addAfter(ModBlocks.AZALEA_TRAPDOOR, ModBlocks.AZALEA_PRESSURE_PLATE);
//			entries.addAfter(ModBlocks.AZALEA_PRESSURE_PLATE, ModBlocks.AZALEA_BUTTON);
//		});
//
//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
//				entries.addAfter(Blocks.CHERRY_LOG, ModBlocks.AZALEA_LOG));
//
//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->
//				entries.addAfter(Blocks.CHERRY_HANGING_SIGN, ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_HANGING_SIGN));
	}
}