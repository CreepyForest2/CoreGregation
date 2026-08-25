package net.creepyforest.coregregation.common.items;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.CoreGregationTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class CoreGregationToolTiers {

    public static final Tier FLINT = TierSortingRegistry.registerTier(
            new ForgeTier(0, 64, 2.0f, 1.0f, 15, CoreGregationTags.Blocks.DUMMY_BLOCK_TAG, () -> Ingredient.of(Items.FLINT)),
            new ResourceLocation(CoreGregation.MOD_ID, "flint"), List.of(Tiers.WOOD), List.of());

    public static final Tier FLINT_HATCHET_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(0, 32, 5.0f, 0f, 10, CoreGregationTags.Blocks.DUMMY_BLOCK_TAG, () -> Ingredient.of(Items.FLINT)),
            new ResourceLocation(CoreGregation.MOD_ID, "flint_hatchet_i_should_make_this_with_kjs_fuck_java"), List.of(Tiers.WOOD), List.of());
}
