package fire_horse27.azaleawood;

import fire_horse27.azaleawood.block.ModBlocks;
import fire_horse27.azaleawood.item.ModItems;
import fire_horse27.azaleawood.util.ModFlammableBlocks;
import fire_horse27.azaleawood.util.ModStrippableBlocks;
import fire_horse27.azaleawood.villager.ModVillagerTrades;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzaleaWood implements ModInitializer {
	public static final String MOD_ID = "azaleawood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier AZALEA_BOATS_ID = Identifier.fromNamespaceAndPath(MOD_ID, "azalea");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
			entries.insertAfter(Items.PALE_OAK_BUTTON, ModBlocks.AZALEA_LOG.asItem());
			entries.insertAfter(ModBlocks.AZALEA_LOG.asItem(), ModBlocks.AZALEA_WOOD.asItem());
			entries.insertAfter(ModBlocks.AZALEA_WOOD.asItem(), ModBlocks.STRIPPED_AZALEA_LOG.asItem());
			entries.insertAfter(ModBlocks.STRIPPED_AZALEA_LOG.asItem(), ModBlocks.STRIPPED_AZALEA_WOOD.asItem());
			entries.insertAfter(ModBlocks.STRIPPED_AZALEA_WOOD.asItem(), ModBlocks.AZALEA_PLANKS.asItem());
			entries.insertAfter(ModBlocks.AZALEA_PLANKS.asItem(), ModBlocks.AZALEA_STAIRS.asItem());
			entries.insertAfter(ModBlocks.AZALEA_STAIRS.asItem(), ModBlocks.AZALEA_SLAB.asItem());
			entries.insertAfter(ModBlocks.AZALEA_SLAB.asItem(), ModBlocks.AZALEA_FENCE.asItem());
			entries.insertAfter(ModBlocks.AZALEA_FENCE.asItem(), ModBlocks.AZALEA_FENCE_GATE.asItem());
			entries.insertAfter(ModBlocks.AZALEA_FENCE_GATE.asItem(), ModBlocks.AZALEA_DOOR.asItem());
			entries.insertAfter(ModBlocks.AZALEA_DOOR.asItem(), ModBlocks.AZALEA_TRAPDOOR.asItem());
			entries.insertAfter(ModBlocks.AZALEA_TRAPDOOR.asItem(), ModBlocks.AZALEA_PRESSURE_PLATE.asItem());
			entries.insertAfter(ModBlocks.AZALEA_PRESSURE_PLATE.asItem(), ModBlocks.AZALEA_BUTTON.asItem());
		});

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries ->
				entries.insertAfter(Items.PALE_OAK_LOG, ModBlocks.AZALEA_LOG.asItem())
		);

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
			entries.insertAfter(Items.PALE_OAK_SHELF, ModBlocks.AZALEA_SHELF.asItem());
			entries.insertAfter(Items.PALE_OAK_HANGING_SIGN, ModItems.AZALEA_SIGN, ModItems.AZALEA_HANGING_SIGN);
		});

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output ->
				output.insertAfter(Items.CHERRY_CHEST_BOAT, ModItems.AZALEA_BOAT, ModItems.AZALEA_CHEST_BOAT)
		);
	}
}