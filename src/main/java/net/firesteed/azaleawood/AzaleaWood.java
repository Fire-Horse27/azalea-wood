package net.firesteed.azaleawood;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.firesteed.azaleawood.block.ModBlocks;
import net.firesteed.azaleawood.item.ModItems;
import net.firesteed.azaleawood.util.ModBoatTypes;
import net.firesteed.azaleawood.util.ModFlammableBlocks;
import net.firesteed.azaleawood.util.ModStrippableBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class AzaleaWood implements ModInitializer {
	public static final String MOD_ID = "azaleawood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModBoatTypes.registerModBoatTypes();
		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (id.equals(new Identifier("chests/spawn_bonus_chest"))) {
				AtomicInteger i = new AtomicInteger();
				tableBuilder.modifyPools(builder -> {
					i.getAndIncrement();
					if (i.get() == 2) {
						builder.with(ItemEntry.builder(ModBlocks.AZALEA_LOG)
								.weight(3)
								.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))));
					}
				});
			}
		});


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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.addAfter(Blocks.CHERRY_HANGING_SIGN, ModItems.AZALEA_SIGN);
			entries.addAfter(ModBlocks.AZALEA_SIGN, ModBlocks.AZALEA_HANGING_SIGN);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
			entries.addAfter(Items.CHERRY_CHEST_BOAT, ModItems.AZALEA_BOAT);
			entries.addAfter(ModItems.AZALEA_CHEST_BOAT, ModItems.AZALEA_CHEST_BOAT);
		});

	}
}
