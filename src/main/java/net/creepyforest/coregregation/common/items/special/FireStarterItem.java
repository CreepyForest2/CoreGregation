package net.creepyforest.coregregation.common.items.special;



import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;




public class FireStarterItem extends Item {


    //lowk spent the past half an hour trying to rewrite this with the og code for reference but i basically copied it so
    //credit to alcatrazescape for the code


    public FireStarterItem(Properties properties) {
        super(new Properties().durability(10));
    }

    @Override

    //no idea what this does, its not mine and the thing dosent work without it

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.PASS, player.getItemInHand(hand));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {

        if (entity instanceof Player player) {

            BlockHitResult result = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
            if (result.getType() == HitResult.Type.BLOCK) {


                BlockPos pos = result.getBlockPos();

                if (!level.isClientSide) {

                    stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                    level.setBlockAndUpdate(pos.above(), Blocks.FIRE.defaultBlockState());

                    BlockState state = level.getBlockState(pos);

                    if(CampfireBlock.canLight(state)) {
                        level.setBlock(pos, state.setValue(BlockStateProperties.LIT, true), 11);
                    }

                }
            }
        }
        return stack;
    }



    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 30;
    }



}
