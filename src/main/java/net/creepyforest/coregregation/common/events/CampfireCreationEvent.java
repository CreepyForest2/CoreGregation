package net.creepyforest.coregregation.common.events;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.item.tool.ToolHelper;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.creepyforest.coregregation.sounds.CoreGregationSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CampfireCreationEvent {


    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        if (event.getLevel().isClientSide()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        Player player = event.getEntity();

        if (player.isCreative()) return;

        ItemStack itemInHand = player.getMainHandItem();
        BlockState state = event.getLevel().getBlockState(event.getPos());

        if (!state.is(BlockTags.LOGS) && !itemInHand.is(CoreGregationItems.FLINT_SAW.get()) || (!ToolHelper.is(itemInHand, GTToolType.SAW))) {
            return;
        } else if (state.is(BlockTags.LOGS) && !itemInHand.is(CoreGregationItems.FLINT_SAW.get()) || (ToolHelper.is(itemInHand, GTToolType.SAW))) {

            Level level = event.getLevel();
            BlockPos pos = event.getPos();

            level.setBlockAndUpdate(pos, Blocks.CAMPFIRE.defaultBlockState().setValue(CampfireBlock.LIT, false));
            event.getLevel().playSound(null, pos, SoundEvent.createVariableRangeEvent(new ResourceLocation("gtceu:saw")), SoundSource.BLOCKS, 1.0f, 1.0f);
            itemInHand.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }
}

