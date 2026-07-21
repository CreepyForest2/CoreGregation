

package net.creepyforest.coregregation.common.events;

import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class NetherPortalEvent {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();

        var item = event.getItemStack().getItem();
        if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) return;


        BlockPos pos = event.getPos();
        BlockPos inside = pos.relative(event.getFace());
        Level level = player.level();

        Direction.Axis[] axes = {Direction.Axis.X, Direction.Axis.Z};

        boolean validFrame = false;
        for (Direction.Axis axis : axes) {
            if (PortalShape.findEmptyPortalShape(level, inside, axis).isPresent()) {
                validFrame = true;
                break;
            }
        }
        if (!validFrame) return;

        boolean hasItem = false;
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.is(CoreGregationItems.NETHER_PORTAL_ACTIVATOR_ITEM.get())) {
                stack.shrink(1);
                hasItem = true;
                break;
            }
        }
        if (!hasItem) {
            event.setCanceled(true);
            player.displayClientMessage(Component.translatable("message.coregregation.portal_blocked"), true);
        }
    }
}




