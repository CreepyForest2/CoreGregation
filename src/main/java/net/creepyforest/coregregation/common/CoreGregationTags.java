package net.creepyforest.coregregation.common;

import net.creepyforest.coregregation.CoreGregation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockCollisions;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.TagEntry.tag;

public class CoreGregationTags {

    public class Blocks {
        public static final TagKey<Block> DUMMY_BLOCK_TAG = tag("dummy_block_tag");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CoreGregation.MOD_ID, name));
        }
    }
}
