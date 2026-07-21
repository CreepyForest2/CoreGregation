package net.creepyforest.coregregation.common.events;

import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.creepyforest.coregregation.sounds.CoreGregationSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class FlintKnappingEvent {

    private static final Random rd = new Random();

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        Player player = event.getEntity();
        ItemStack itemInHand = player.getMainHandItem();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);

        if (event.getLevel().isClientSide()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (!state.is(Tags.Blocks.STONE)) return;

        if (itemInHand.is(Items.FLINT) && state.is(Tags.Blocks.STONE)) {


            int knappingChance = rd.nextInt(1,3 );
            if (knappingChance == 1) {
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.getLevel().playSound(null, pos, CoreGregationSounds.FLINT_KNAPPING.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
            } else {

                itemInHand.shrink(1);
                player.addItem(new ItemStack(CoreGregationItems.FLINT_SHARD.get(), 2));

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.getLevel().playSound(null, pos, CoreGregationSounds.FLINT_KNAPPING.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
     }
}
