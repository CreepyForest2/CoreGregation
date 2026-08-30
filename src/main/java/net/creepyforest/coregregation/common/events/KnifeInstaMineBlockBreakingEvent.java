package net.creepyforest.coregregation.common.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.creepyforest.coregregation.common.data.datagen.CoreGregationGlobalLootModifiersProvider.KNIVES_TAG;

public class KnifeInstaMineBlockBreakingEvent {

    @SubscribeEvent

    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {


        //so basically what this does is if the player is holding a knife out and breaks a block that is instamineable (grass, flowers etc) it damages it by 1

        Player player = event.getEntity();
        ItemStack itemInHand = player.getMainHandItem();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);



        if (event.getLevel().isClientSide()) return;
        if (!itemInHand.is(KNIVES_TAG)) return;
        if (!(state.getDestroySpeed(null, null) <= 0.0F)) return;

        if(itemInHand.is(KNIVES_TAG) && state.getDestroySpeed(null, null) <= 0.0F) {
            itemInHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }
}
