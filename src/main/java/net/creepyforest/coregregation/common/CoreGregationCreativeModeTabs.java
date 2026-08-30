package net.creepyforest.coregregation.common;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.blocks.CoreGregationBlocks;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CoreGregationCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoreGregation.MOD_ID);


    public static final RegistryObject<CreativeModeTab> COREGREGATION_ITEMS_TAB = CREATIVE_MODE_TABS.register("coregregation_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CoreGregationItems.METALLURGICAL_SILICON_ITEM.get()))
                    .title(Component.translatable("creativetab.coregregation_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CoreGregationItems.NETHER_PORTAL_ACTIVATOR_ITEM.get());
                        output.accept(CoreGregationItems.METALLURGICAL_SILICON_ITEM.get());
                        output.accept(CoreGregationItems.CONTAMINATED_SILICON_BOULE.get());
                        output.accept(CoreGregationItems.FLINT_SHARD.get());
                        output.accept(CoreGregationItems.PLANT_FIBER.get());
                        output.accept(CoreGregationItems.FLINT_SAW_HEAD.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> COREGREGATION_TOOLS_TAB = CREATIVE_MODE_TABS.register("coregregation_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CoreGregationItems.FLINT_HATCHET.get()))
                    .title(Component.translatable("creativetab.coregregation_tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CoreGregationItems.FLINT_KNIFE.get());
                        output.accept(CoreGregationItems.FLINT_HATCHET.get());
                        output.accept(CoreGregationItems.FIRE_STARTER.get());
                        output.accept(CoreGregationItems.FLINT_SWORD.get());
                        output.accept(CoreGregationItems.FLINT_PICKAXE.get());
                        output.accept(CoreGregationItems.FLINT_AXE.get());
                        output.accept(CoreGregationItems.FLINT_SHOVEL.get());
                        output.accept(CoreGregationItems.FLINT_HOE.get());
                        output.accept(CoreGregationItems.FLINT_SAW.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> COREGREGATION_BLOCKS_TAB = CREATIVE_MODE_TABS.register("coregregation_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get()))
                    .title(Component.translatable("creativetab.coregregation_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get());
                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
