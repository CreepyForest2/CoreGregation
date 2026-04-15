package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;

import org.jetbrains.annotations.NotNull;

public class StrongSteamParallelMultiBlockMachine extends SteamParallelMultiblockMachine {

    //sane thing as weak parallel, except it does 8 recipes at once and not 4 and works faster

    private static final double CONVERSION_RATE = 0.5D;

    public StrongSteamParallelMultiBlockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        setMaxParallels(8);
    }

    @Override
    public double getConversionRate() {
        return CONVERSION_RATE;
    }

    public static ModifierFunction recipeModifier(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (RecipeHelper.getRecipeEUtTier(recipe) > GTValues.LV) return ModifierFunction.NULL;
        // long euTick = RecipeHelper.getRecipeEUtTier(recipe);
        int parallel = ParallelLogic.getParallelAmount(machine, recipe, 8);
        // double eutMulti = (euTick * 0.5 * parallel <= 32) ? (parallel * 0.5) : (32.0 / euTick);

        return ModifierFunction.builder()
                .modifyAllContents(ContentModifier.multiplier(parallel))
                .eutModifier(ContentModifier.multiplier(parallel))
                .durationMultiplier(parallel * 0.5)
                .parallels(parallel)
                .build();
    }

    public static RecipeModifier recipeModifierCanRunAtMost(int tier) {
        return (@NotNull MetaMachine machine, @NotNull GTRecipe recipe) -> {
            if (RecipeHelper.getRecipeEUtTier(recipe) > tier) return ModifierFunction.NULL;
            // long euTick = RecipeHelper.getRecipeEUtTier(recipe);
            int parallel = ParallelLogic.getParallelAmount(machine, recipe, 8);
            // double eutMulti = (euTick * 0.5 * parallel <= 32) ? (parallel * 0.5) : (32.0 / euTick);

            return ModifierFunction.builder()
                    .modifyAllContents(ContentModifier.multiplier(parallel))
                    .eutModifier(ContentModifier.multiplier(parallel))
                    .durationMultiplier(parallel * 0.5)
                    .parallels(parallel)
                    .build();
        };
    }
}