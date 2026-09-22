package fire_horse27.azaleawood.util;

import net.minecraft.resources.Identifier;

/*
 * Original code by gniftygnome, used under GPLv3.
 * Licensed under the GNU General Public License v3.0
 * Modified by Fire_Horse27 – variable names adjusted.
 */

public class TerraformCpyBoatClientHelper {
    @SuppressWarnings("UnnecessaryReturnStatement")
    private TerraformCpyBoatClientHelper() {
        return;
    }

    public static void registerModelLayers(Identifier id) {
        TerraformCpyBoatClientHelperImpl.registerModelLayers(id);
    }
}
