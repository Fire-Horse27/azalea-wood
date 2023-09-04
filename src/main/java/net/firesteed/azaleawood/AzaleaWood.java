package net.firesteed.azaleawood;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.firesteed.azaleawood.block.ModBlocks;
import net.firesteed.azaleawood.item.ModItems;
import net.firesteed.azaleawood.util.ModBoatTypes;
import net.firesteed.azaleawood.util.ModFlammableBlocks;
import net.firesteed.azaleawood.util.ModStrippableBlocks;
import net.minecraft.loot.LootPool;
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

	}
}
