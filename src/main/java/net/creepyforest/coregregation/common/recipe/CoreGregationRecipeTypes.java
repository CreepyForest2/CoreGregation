package net.creepyforest.coregregation.common.recipe;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;


public class CoreGregationRecipeTypes {
    public static GTRecipeType OVEN_RECIPES;

    public static void init() {
        if (OVEN_RECIPES != null) return;
        OVEN_RECIPES = GTRecipeTypes
                .register("oven_multiblock", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(11, 2, 1, 0);
    }
}
