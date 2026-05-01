package net.creepyforest.coregregation.common.data;

import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.material.WaterFluid;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTItems.ELECTRONIC_CIRCUIT_MV;

public class CoreGregationMachineRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {

        CoreGregationRecipeTypes.OVEN_RECIPES.recipeBuilder("test")
                .inputItems(GTItems.DOUGH, 1)
                .outputItems(ELECTRONIC_CIRCUIT_MV)
                .save(provider);
    }
}
