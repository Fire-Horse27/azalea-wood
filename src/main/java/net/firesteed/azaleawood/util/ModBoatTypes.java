//package net.firesteed.azaleawood.util;
//
//import com.terraformersmc.terraform.boat.api.TerraformBoatType;
//import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
//import net.firesteed.azaleawood.AzaleaWood;
//import net.firesteed.azaleawood.block.ModBlocks;
//import net.firesteed.azaleawood.item.ModItems;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//public class ModBoatTypes {
//    public static final TerraformBoatType AZALEA_BOAT_TYPE = new TerraformBoatType.Builder()
//                    .item(ModItems.AZALEA_BOAT).chestItem(ModItems.AZALEA_CHEST_BOAT).planks(ModBlocks.AZALEA_PLANKS.asItem())
//                    .build();
//
//    static {
//        Registry.register(TerraformBoatTypeRegistry.INSTANCE, id("azalea"), AZALEA_BOAT_TYPE);
//    }
//
//    public static void registerModBoatTypes() {
//        AzaleaWood.LOGGER.info("Registering Mod Boat Types for " + AzaleaWood.MOD_ID);
//    }
//
//    private static Identifier id(String path) {
//        return Identifier.of(AzaleaWood.MOD_ID, path);
//    }
//}
