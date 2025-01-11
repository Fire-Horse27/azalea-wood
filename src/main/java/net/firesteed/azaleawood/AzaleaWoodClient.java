package net.firesteed.azaleawood;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.firesteed.azaleawood.block.ModBlocks;
import net.firesteed.azaleawood.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class AzaleaWoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AZALEA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AZALEA_TRAPDOOR, RenderLayer.getCutout());
        TerraformBoatClientHelper.registerModelLayers(ModItems.AZALEA);
        /*SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.AZALEA_SIGN.getTexture()));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.AZALEA_HANGING_SIGN.getTexture()));*/
    }

    private static Identifier id(String path) {
        return Identifier.of(AzaleaWood.MOD_ID, path);
    }
}
