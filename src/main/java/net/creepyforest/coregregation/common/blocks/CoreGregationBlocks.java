package net.creepyforest.coregregation.common.blocks;

import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.blocks.special.CasingAssemblingMechanismBlock;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class CoreGregationBlocks {

    public static final BlockEntry<CasingAssemblingMechanismBlock> CASING_ASSEMBLING_MECHANISM;
    public static final BlockEntry<Block> PORCELAIN_ENAMELED_STEEL_CASING;


static {
    CASING_ASSEMBLING_MECHANISM = ((BlockBuilder) REGISTRATE.block("casing_assembling_mechanism", CasingAssemblingMechanismBlock::new).initialProperties(() -> Blocks.IRON_BLOCK).exBlockstate(GTModels.createModelBlockState(CoreGregation.id("block/casing_assembling_mechanism"))).tag(new TagKey[]{BlockTags.MINEABLE_WITH_PICKAXE}).lang("Casing Assembling Mechanism").item().build()).register();
    PORCELAIN_ENAMELED_STEEL_CASING = createCasingBlock("porcelain_enameled_steel_casing", CoreGregation.id("block/casings/porcelain_enameled_steel_casing"));
}




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //dont register casings under gtceu
    private static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return REGISTRATE.block(name, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, entity) -> false))
                .addLayer(() -> RenderType::solid)
                .exBlockstate(GTModels.cubeAllModel(texture))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new)
                .build()
                .register();
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
