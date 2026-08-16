package net.creepyforest.coregregation.common.events;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.creepyforest.coregregation.common.data.datagen.CoreGregationGlobalLootModifiersProvider.KNIVES_TAG;

public class KnifeGrassBreakingEvent {

    @SubscribeEvent

    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {


        Player player = event.getEntity();
        ItemStack itemInHand = player.getMainHandItem();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);



        if (event.getLevel().isClientSide()) return;
        if (!itemInHand.is(KNIVES_TAG)) return;
        if (!allowedBLocks(state)) return;

        if(itemInHand.is(KNIVES_TAG) && allowedBLocks(state)) {
            itemInHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }

    private static boolean allowedBLocks(BlockState state) {
        return(state.is(Blocks.GRASS) || state.is(Blocks.TALL_GRASS) || state.is(Blocks.FERN) || state.is(Blocks.LARGE_FERN));
    }
}
