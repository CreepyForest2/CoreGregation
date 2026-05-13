package net.creepyforest.coregregation.common.data;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class CoreGregationMachineRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {

        CoreGregationRecipeTypes.OVEN_RECIPES.recipeBuilder("testoven")
                .inputItems(GTItems.DOUGH, 1)
                .outputItems(ELECTRONIC_CIRCUIT_MV)
                .save(provider);

        CoreGregationRecipeTypes.COOKING_POT_RECIPES.recipeBuilder("testpot")
                .inputItems(GTItems.CAPACITOR, 1)
                .inputFluids(GTMaterials.Deuterium.getFluid(375))
                .outputItems(ELECTRONIC_CIRCUIT_MV)
                .save(provider);

        CoreGregationRecipeTypes.BLOOMERY_RECIPES.recipeBuilder("testbloomery")
                .inputItems(GTItems.SMD_DIODE, 1)
                .outputItems(NEUTRONIUM_WAFER)
                .save(provider);
    }
}
