package net.creepyforest.coregregation.common.data.datagen;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.creepyforest.coregregation.loot.AddItemModifier;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class CoreGregationGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public CoreGregationGlobalLootModifiersProvider(PackOutput output) {
        super(output, CoreGregation.MOD_ID);
    }


    public static final TagKey<Item> KNIVES_TAG =
            TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/knives")); //im gonna move this somewhere...eventually


    @Override
    protected void start() {
        add("plant_fiber_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(KNIVES_TAG)).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                CoreGregationItems.PLANT_FIBER.get()));
        add("plant_fiber_from_tall_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(KNIVES_TAG)).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                CoreGregationItems.PLANT_FIBER.get()));
        add("plant_fiber_from_fern", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(KNIVES_TAG)).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                CoreGregationItems.PLANT_FIBER.get()));
        add("plant_fiber_from_large_fern", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LARGE_FERN).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(KNIVES_TAG)).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()},
                CoreGregationItems.PLANT_FIBER.get()));
    }

}
