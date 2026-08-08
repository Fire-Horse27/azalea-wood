package fire_horse27.azaleawood;

import fire_horse27.azaleawood.datagen.ModModelProvider;
import fire_horse27.azaleawood.datagen.ModRecipeProvider;
import fire_horse27.azaleawood.datagen.ModBlockLootSubProvider;
//import fire_horse27.azaleawood.datagen.ModBlockTagsProvider;
import fire_horse27.azaleawood.datagen.ModEntityTypeTagsProvider;
//import fire_horse27.azaleawood.datagen.ModItemTagsProvider;
//import fire_horse27.azaleawood.datagen.ModVillagerTradeKeyTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AzaleaWoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockLootSubProvider::new);
		//pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModEntityTypeTagsProvider::new);
		//pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		//pack.addProvider(ModVillagerTradeKeyTagProvider::new);
	}
}
