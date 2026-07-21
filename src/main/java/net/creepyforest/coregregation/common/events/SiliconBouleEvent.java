package net.creepyforest.coregregation.common.events;

import com.gregtechceu.gtceu.common.data.GTItems;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SiliconBouleEvent {


    //OMFD I WROTE THIS ENTIRE CLASS (mostly) ALL BY MYSELF AND ACTUALLY UNDERSTOOD WTF WAS GOING ON
    //AND I ALSO REUSED A METHOD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.tickCount % 20 != 0) return;
        if (event.getEntity().level().isClientSide()) return;
        if (!ChemicalBurnEvent.hasHazmatSuit(player)) {
            for(int i = 0; i < player.getInventory().getContainerSize(); i++ ) {
                ItemStack stack = player.getInventory().getItem(i);
                if (stack.is(GTItems.SILICON_BOULE.get())) {
                    stack.shrink(1);

                   player.addItem(new ItemStack(CoreGregationItems.CONTAMINATED_SILICON_BOULE.get()));
                    player.displayClientMessage(Component.translatable("message.coregregation.ruined_silicon_boule"), true);

                    break;
                }
            }
        }
    }
}
