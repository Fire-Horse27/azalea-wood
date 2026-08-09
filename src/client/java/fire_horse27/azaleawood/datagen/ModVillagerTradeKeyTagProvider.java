package fire_horse27.azaleawood.datagen;

import fire_horse27.azaleawood.villager.ModVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradeKeyTagProvider extends FabricTagsProvider<VillagerTrade> {
    public ModVillagerTradeKeyTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(VillagerTradeTags.WANDERING_TRADER_UNCOMMON)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_AZALEA_LOG);
    }

    @Override
    public String getName() {
        return "Azalea Wood Villager Trade Tags";
    }
}
