package fire_horse27.azaleawood.villager;

import fire_horse27.azaleawood.AzaleaWood;
import fire_horse27.azaleawood.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.List;
import java.util.Optional;

public class ModVillagerTrades {

    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_AZALEA_LOG =
            resourceKey("wandering_trader/emerald_azalea_log");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        context.register(
                WANDERING_TRADER_EMERALD_AZALEA_LOG,
                new VillagerTrade(
                        new TradeCost(Items.EMERALD, 1),
                        new ItemStackTemplate(ModBlocks.AZALEA_LOG.asItem(), 8),
                        4,
                        1,
                        0.05F,
                        Optional.empty(),
                        List.of()
                )
        );
    }

    public static ResourceKey<VillagerTrade> resourceKey(String path) {
        return ResourceKey.create(
                Registries.VILLAGER_TRADE,
                Identifier.fromNamespaceAndPath(AzaleaWood.MOD_ID, path)
        );
    }
}


