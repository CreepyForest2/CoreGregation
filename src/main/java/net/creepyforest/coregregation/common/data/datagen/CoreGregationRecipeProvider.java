package net.creepyforest.coregregation.common.data.datagen;

import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.function.Consumer;

public class CoreGregationRecipeProvider extends RecipeProvider implements ICondition {


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CoreGregationItems.FLINT_KNIFE.get())
                .pattern("fF")
                .pattern("SF")
                .define('f', CoreGregationItems.FLINT_SHARD.get())
                .define('F', ItemTags.FLOWERS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(CoreGregationItems.FLINT_SHARD.get()), has(CoreGregationItems.FLINT_SHARD.get()))
                .save(pWriter);

    }

    @Override
    public ResourceLocation getID() {
        return null;
    }

    @Override
    public boolean test(IContext iContext) {
        return false;
    }

    public CoreGregationRecipeProvider(PackOutput output) {
        super(output);
    }
}
