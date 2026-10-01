package net.creepyforest.coregregation.common.blocks;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.blocks.special.CasingAssemblingMechanismBlock;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
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

public class CoreGregationBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CoreGregation.MOD_ID);

//i am very thankful for kaupenjoe, all hail his name

    public static final RegistryObject<Block> CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK = registerBlock("cartridge_assembling_mechanism",
            () -> new CasingAssemblingMechanismBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()));


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
}
