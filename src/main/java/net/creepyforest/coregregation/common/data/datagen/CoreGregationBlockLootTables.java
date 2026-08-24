package net.creepyforest.coregregation.common.data.datagen;

import net.creepyforest.coregregation.common.blocks.CoreGregationBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class CoreGregationBlockLootTables extends BlockLootSubProvider {

    protected CoreGregationBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CoreGregationBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
