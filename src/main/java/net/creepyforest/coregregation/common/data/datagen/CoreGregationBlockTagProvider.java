package net.creepyforest.coregregation.common.data.datagen;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.blocks.CoreGregationBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CoreGregationBlockTagProvider extends BlockTagsProvider {
    public CoreGregationBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CoreGregation.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get());

    }
}
