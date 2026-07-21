package net.creepyforest.coregregation.common.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;
import static com.gregtechceu.gtceu.common.data.GTItems.*;


public class CoreGregationMachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {

        CoreGregationRecipeTypes.BRASS_PUNCHER_RECIPES.recipeBuilder("mortii_matii")
                .inputItems(GOOD_CIRCUIT_BOARD)
                .outputItems(SILICON_BOULE)
                .EUt(16)
                .duration(100)
                .save(provider);
    }
}
