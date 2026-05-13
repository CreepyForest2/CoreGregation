package net.creepyforest.coregregation.common.recipe;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;


public class CoreGregationRecipeTypes {
    public static GTRecipeType OVEN_RECIPES;
    public static GTRecipeType COOKING_POT_RECIPES;
    public static GTRecipeType BLOOMERY_RECIPES;


    public static void init() {
        OVEN_RECIPES = GTRecipeTypes
                .register("oven", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(11, 2, 1, 0);

        COOKING_POT_RECIPES = GTRecipeTypes
                .register("cooking_pot", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(11, 2, 1, 1);

        BLOOMERY_RECIPES = GTRecipeTypes
                .register("bloomery", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(3, 3, 0, 0);
    }
}