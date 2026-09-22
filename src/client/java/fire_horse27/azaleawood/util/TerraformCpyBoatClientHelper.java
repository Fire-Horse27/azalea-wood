package fire_horse27.azaleawood.util;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.Identifier;

public class TerraformCpyBoatClientHelper {
    @SuppressWarnings("UnnecessaryReturnStatement")
    private TerraformCpyBoatClientHelper() {
        return;
    }

    public static void registerModelLayers(Identifier id) {
        TerraformCpyBoatClientHelperImpl.registerModelLayers(id);
    }
}
