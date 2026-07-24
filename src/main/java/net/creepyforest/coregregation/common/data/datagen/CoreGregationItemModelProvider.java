package net.creepyforest.coregregation.common.data.datagen;

import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.creepyforest.coregregation.CoreGregation.MOD_ID;

public class CoreGregationItemModelProvider extends ItemModelProvider {
    public CoreGregationItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    //code by kaupenjoe, all hail his name

    @Override
    protected void registerModels() {
        simpleItem(CoreGregationItems.NETHER_PORTAL_ACTIVATOR_ITEM);
        simpleItem(CoreGregationItems.CONTAMINATED_SILICON_BOULE);
        simpleItem(CoreGregationItems.FLINT_SHARD);
        simpleItem(CoreGregationItems.FLINT_KNIFE);
        simpleItem(CoreGregationItems.PLANT_FIBER);
        simpleItem(CoreGregationItems.PLANT_STRING);

        //tools

        handheldItem(CoreGregationItems.FLINT_KNIFE);
    }


    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CoreGregation.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/" + item.getId().getPath()));
    }

    public static void init(RegistrateItemModelProvider registrateItemModelProvider) {
    }
}
