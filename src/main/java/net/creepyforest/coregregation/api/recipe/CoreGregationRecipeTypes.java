package net.creepyforest.coregregation.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;


public class CoreGregationRecipeTypes {

    //gui multis
    public static GTRecipeType OVEN_RECIPES;
    public static GTRecipeType COOKING_POT_RECIPES;
    public static GTRecipeType BLOOMERY_RECIPES;

    //electric stuff
    public static GTRecipeType BRASS_PUNCHER_RECIPES;
    public static GTRecipeType CASING_PRODUCTION_LINE_RECIPES;
    public static GTRecipeType FIREARM_PARTS_ASSEMBLING_RECIPES;
    public static GTRecipeType FIREARM_ASSEMBLING_RECIPES;


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

        BRASS_PUNCHER_RECIPES = GTRecipeTypes
                .register("brass_puncher", GTRecipeTypes.ELECTRIC)
                .setMaxIOSize(4, 1, 0, 0);

        CASING_PRODUCTION_LINE_RECIPES = GTRecipeTypes
                .register("casing_production_line", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(4, 1, 0, 0);


        FIREARM_PARTS_ASSEMBLING_RECIPES = GTRecipeTypes
                .register("firearm_parts_assembler", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(25, 1, 0, 0).setEUIO(IO.IN);

        FIREARM_ASSEMBLING_RECIPES = GTRecipeTypes
                .register("firearm_assembler", GTRecipeTypes.MULTIBLOCK)
                .setMaxIOSize(25, 1, 0, 0).setEUIO(IO.IN);
    }
}