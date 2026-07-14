package net.creepyforest.coregregation.common.recipe;

import net.minecraft.data.recipes.FinishedRecipe;


import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.cosmetics.CapeRegistry.save;
import static com.gregtechceu.gtceu.common.data.GTItems.ELECTRONIC_CIRCUIT_MV;
import static com.gregtechceu.gtceu.common.data.GTItems.GOOD_CIRCUIT_BOARD;
import static net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes.BRASS_PUNCHER_RECIPES;

public class CoreGregationMachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {

        CoreGregationRecipeTypes.BRASS_PUNCHER_RECIPES.recipeBuilder("mortii_matii")
                .inputItems(GOOD_CIRCUIT_BOARD)
                .outputItems(ELECTRONIC_CIRCUIT_MV)
                .EUt(16)
                .duration(100)
                .save(provider);
    }
}
