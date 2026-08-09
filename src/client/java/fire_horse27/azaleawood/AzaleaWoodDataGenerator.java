package fire_horse27.azaleawood;

import fire_horse27.azaleawood.datagen.ModModelProvider;
import fire_horse27.azaleawood.datagen.ModRecipeProvider;
import fire_horse27.azaleawood.datagen.ModBlockLootSubProvider;
import fire_horse27.azaleawood.datagen.ModVillagerTradeKeyTagProvider;
import fire_horse27.azaleawood.datagen.ModDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class AzaleaWoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModDynamicRegistryProvider::new);
		pack.addProvider(ModBlockLootSubProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModVillagerTradeKeyTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		ModDynamicRegistryProvider.buildRegistry(registryBuilder);
	}
}
