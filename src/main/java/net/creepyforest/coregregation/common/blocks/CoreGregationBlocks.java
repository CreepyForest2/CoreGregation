package net.creepyforest.coregregation.common.blocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.blocks.special.CasingAssemblingMechanismBlock;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class CoreGregationBlocks {

    public static final BlockEntry<CasingAssemblingMechanismBlock> CASING_ASSEMBLING_MECHANISM;


static {
    CASING_ASSEMBLING_MECHANISM = ((BlockBuilder) REGISTRATE.block("casing_assembling_mechanism", CasingAssemblingMechanismBlock::new).initialProperties(() -> Blocks.IRON_BLOCK).exBlockstate(GTModels.createModelBlockState(CoreGregation.id("block/casing_assembling_mechanism"))).tag(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE}).lang("Casing Assembling Mechanism").item().build()).register();
}


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return CoreGregationItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CoreGregation.MOD_ID);
}
