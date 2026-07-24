package net.creepyforest.coregregation.common.data.datagen;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CoreGregationItemTagProvider extends ItemTagsProvider {
    public CoreGregationItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                                        CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, CoreGregation.MOD_ID, existingFileHelper);
    }

    public static final TagKey<Item> KNIVES = ItemTags.create(
            new ResourceLocation("forge", "tools/knives")
    );

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(KNIVES)
                .add(CoreGregationItems.FLINT_KNIFE.get());
        this.tag(Tags.Items.STRING)
                .add(CoreGregationItems.PLANT_STRING.get());
    }
}
