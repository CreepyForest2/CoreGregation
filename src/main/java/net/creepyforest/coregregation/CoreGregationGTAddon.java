package net.creepyforest.coregregation;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.creepyforest.coregregation.common.data.CoreGregationMachineRecipes;
import net.creepyforest.coregregation.common.data.materials.CoreGregationMaterials;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class CoreGregationGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return CoreGregation.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return CoreGregation.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        // CustomTagPrefixes.init();
    }
    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        CoreGregationMachineRecipes.init(provider);
    }

    @Override
    public void registerElements() {
        // CustomElements.init();
    }
    
    // If you have custom ingredient types, uncomment this & change to match your capability.
    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
    /*
     * public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, false);
     * public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, true);
     *
     * @Override
     * public void registerRecipeKeys(KJSRecipeKeyEvent event) {
     * event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
     * }
     */
}