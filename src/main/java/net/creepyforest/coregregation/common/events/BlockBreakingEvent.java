package net.creepyforest.coregregation.common.events;

import com.gregtechceu.gtceu.data.model.BlockstateModelLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class BlockBreakingEvent {


    //behold the worst code known to man

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getLevel().isClientSide()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        Player player = event.getEntity();
        if (player.isCreative()) return;


        ItemStack itemInHand = player.getMainHandItem();
        BlockState state = event.getLevel().getBlockState(event.getPos());




        if (state.getDestroySpeed(null, null) <= 0.0F) {
            event.setCanceled(false);
        } else if (allowedBlocks(state)) {
            event.setCanceled(false);
        } else if (isMissingCorrectTool(state, itemInHand)) {
                event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        BlockState state = event.getState();

        if (player.isCreative()) return;

        if (state.getDestroySpeed(null, null) <= 0.0F) {
            event.setCanceled(false);
        } else if (allowedBlocks(state)) {
            event.setCanceled(false);
        } else if (isMissingCorrectTool(state, player.getMainHandItem())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        BlockState state = event.getState();

        if (player.level().isClientSide() || player.isCreative()) return;

        if (state.getDestroySpeed(null, null) <= 0.0F) {
            event.setCanceled(false);
        } else if (allowedBlocks(state)) {
            event.setCanceled(false);
        } else if (isMissingCorrectTool(state, player.getMainHandItem())) {
            event.setCanceled(true);
        }
    }

    private static boolean isMissingCorrectTool(BlockState state, ItemStack itemInHand) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) && !itemInHand.is(ItemTags.TOOLS)
                || state.is(BlockTags.MINEABLE_WITH_AXE) && !itemInHand.is(ItemTags.AXES)
                || state.is(BlockTags.MINEABLE_WITH_SHOVEL) && !itemInHand.is(ItemTags.TOOLS)
                || state.is(BlockTags.MINEABLE_WITH_HOE) && !itemInHand.is(ItemTags.TOOLS);
    }

    //exclude these blocks as they are needed for progression

    private static boolean allowedBlocks(BlockState state) {
        return state.is(BlockTags.SAND) || state.is(BlockTags.DIRT) || state.is(Tags.Blocks.GRAVEL) || state.is(BlockTags.SAND)
                || state.is(BlockTags.LEAVES);
    }
}