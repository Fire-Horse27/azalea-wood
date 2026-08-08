package fire_horse27.azaleawood.datagen;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatData;
import fire_horse27.azaleawood.AzaleaWood;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(EntityTypeTags.BOAT)
                .addElement(TerraformBoatData.get(AzaleaWood.AZALEA_BOATS_ID).boatEntityTypeId());

        getOrCreateRawBuilder(ConventionalEntityTypeTags.BOATS)
                .addElement(TerraformBoatData.get(AzaleaWood.AZALEA_BOATS_ID).chestBoatEntityTypeId());
    }

    @Override
    public String getName() {
        return "Azalea Wood Entity Type Tags";
    }
}
