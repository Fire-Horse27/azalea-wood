package net.firesteed.azaleawood.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.firesteed.azaleawood.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.AZALEA_LOG, 5, 5);
        registry.add(ModBlocks.AZALEA_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_AZALEA_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_AZALEA_WOOD, 5, 5);

        registry.add(ModBlocks.AZALEA_PLANKS, 5, 20);
        registry.add(ModBlocks.AZALEA_STAIRS, 5, 20);
        registry.add(ModBlocks.AZALEA_SLAB, 5, 20);
        registry.add(ModBlocks.AZALEA_FENCE, 5, 20);
        registry.add(ModBlocks.AZALEA_FENCE_GATE, 5, 20);
    }
}
