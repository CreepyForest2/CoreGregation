package net.creepyforest.coregregation.common;



import net.creepyforest.coregregation.api.machine.multiblock.primitive.Bloomery;
import net.creepyforest.coregregation.api.machine.multiblock.primitive.CookingPot;
import net.creepyforest.coregregation.api.machine.multiblock.primitive.OvenMachine;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.MissingMappingsEvent;

public class MissingMappings {

    //credit to the tfg team for the code

    @SubscribeEvent
    public static void remapIds(MissingMappingsEvent event) {
        event.getAllMappings(Registries.ITEM).forEach(MissingMappings::remapItems);
        event.getAllMappings(Registries.BLOCK).forEach(MissingMappings::remapBlocks);
        event.getAllMappings(Registries.BLOCK_ENTITY_TYPE).forEach(MissingMappings::remapBlockEntities);
    }



    private static void remapItems(MissingMappingsEvent.Mapping<Item> mapping) {
        if (mapping.getKey().equals(new ResourceLocation("notreepunching:fire_starter"))) mapping.remap(CoreGregationItems.FIRE_STARTER.get());
        if (mapping.getKey().equals(new ResourceLocation("notreepunching:flint_axe"))) mapping.remap(CoreGregationItems.FLINT_HATCHET.get());
        if (mapping.getKey().equals(new ResourceLocation("notreepunching:flint_shard"))) mapping.remap(CoreGregationItems.FLINT_SHARD.get());

        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_axe"))) mapping.remap(CoreGregationItems.FLINT_AXE.get());
        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_pickaxe"))) mapping.remap(CoreGregationItems.FLINT_PICKAXE.get());
        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_shovel"))) mapping.remap(CoreGregationItems.FLINT_SHOVEL.get());
        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_sword"))) mapping.remap(CoreGregationItems.FLINT_SWORD.get());
        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_saw_head"))) mapping.remap(CoreGregationItems.FLINT_SAW_HEAD.get());
        if (mapping.getKey().equals(new ResourceLocation("kubejs:flint_saw"))) mapping.remap(CoreGregationItems.FLINT_SAW.get());
    }

    private static void remapBlocks(MissingMappingsEvent.Mapping<Block> mapping) {
        if (mapping.getKey().equals(new ResourceLocation("gregtech:bloomery"))) mapping.remap(Bloomery.BLOOMERY.getBlock());
        if (mapping.getKey().equals(new ResourceLocation("gregtech:oven"))) mapping.remap(OvenMachine.OVEN.getBlock());
        if (mapping.getKey().equals(new ResourceLocation("farmersdelight:pot"))) mapping.remap(CookingPot.COOKING_POT.getBlock());
    }

    private static void remapBlockEntities(MissingMappingsEvent.Mapping<BlockEntityType<?>> mapping) {
        if (mapping.getKey().equals(new ResourceLocation("gregtech:bloomery"))) mapping.remap(Bloomery.BLOOMERY.getBlockEntityType());
        if (mapping.getKey().equals(new ResourceLocation("gregtech:oven"))) mapping.remap(OvenMachine.OVEN.getBlockEntityType());
        if (mapping.getKey().equals(new ResourceLocation("farmersdelight:pot"))) mapping.remap(CookingPot.COOKING_POT.getBlockEntityType());
    }
}


