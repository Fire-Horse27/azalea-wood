package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.AzaleaWood;
import fire_horse27.azaleawood.villager.ModVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    public ModDynamicRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap);
    }

    @Override
    public void configure(HolderLookup.Provider registries, Entries entries) {
        var trades = registries.lookupOrThrow(Registries.VILLAGER_TRADE);

        trades.listElementIds()
                .filter(key -> key.identifier().getNamespace().equals(AzaleaWood.MOD_ID))
                .forEach(key -> entries.add(trades, key));
    }

    @Override
    public String getName() {
        return "Azalea Wood Dynamic Registries";
    }
}
