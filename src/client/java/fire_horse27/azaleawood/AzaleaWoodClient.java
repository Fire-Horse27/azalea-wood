package fire_horse27.azaleawood;

import fire_horse27.azaleawood.util.TerraformCpyBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;

public class AzaleaWoodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TerraformCpyBoatClientHelper.registerModelLayers(AzaleaWood.AZALEA_BOATS_ID);
	}
}