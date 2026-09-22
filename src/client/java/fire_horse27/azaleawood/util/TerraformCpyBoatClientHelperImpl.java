package fire_horse27.azaleawood.util;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.boat.RaftModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.RaftRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/*
 * Original code by gniftygnome, used under GPLv3.
 * Licensed under the GNU General Public License v3.0
 * Modified by Fire_Horse27 – variable names adjusted.
 */

public final class TerraformCpyBoatClientHelperImpl {
    @SuppressWarnings("UnnecessaryReturnStatement")
    private TerraformCpyBoatClientHelperImpl() {
        return;
    }

    private static <T extends Entity> void registerEntityRenderer(EntityType<? extends T> entityType, ModelLayerLocation modelLayer, ModelLayerRegistry.TexturedLayerDefinitionProvider texturedModelDataProvider, EntityRendererProvider<T> entityRendererFactory) {
        ModelLayerRegistry.registerModelLayer(modelLayer, texturedModelDataProvider);
        EntityRenderers.register(entityType, entityRendererFactory);
    }

    public static void registerModelLayers(Identifier id) {
        TerraformCpyBoatDataImpl boatData = TerraformCpyBoatDataImpl.get(id);

        if (boatData.boatEntityType() != null) {
            ModelLayerLocation modelLayers = new ModelLayerLocation(boatData.boatModelLayerId(), "main");
            registerEntityRenderer(boatData.boatEntityType(), modelLayers,
                    BoatModel::createBoatModel,
                    context -> new BoatRenderer(context, modelLayers));
        }
        if (boatData.chestBoatEntityType() != null) {
            ModelLayerLocation modelLayers = new ModelLayerLocation(boatData.chestBoatModelLayerId(), "main");
            registerEntityRenderer(boatData.chestBoatEntityType(), modelLayers,
                    BoatModel::createChestBoatModel,
                    context -> new BoatRenderer(context, modelLayers));
        }
        if (boatData.raftEntityType() != null) {
            ModelLayerLocation modelLayers = new ModelLayerLocation(boatData.raftModelLayerId(), "main");
            registerEntityRenderer(boatData.raftEntityType(), modelLayers,
                    RaftModel::createRaftModel,
                    context -> new RaftRenderer(context, modelLayers));
        }
        if (boatData.chestRaftEntityType() != null) {
            ModelLayerLocation modelLayers = new ModelLayerLocation(boatData.chestRaftModelLayerId(), "main");
            registerEntityRenderer(boatData.chestRaftEntityType(), modelLayers,
                    RaftModel::createChestRaftModel,
                    context -> new RaftRenderer(context, modelLayers));
        }
    }
}
