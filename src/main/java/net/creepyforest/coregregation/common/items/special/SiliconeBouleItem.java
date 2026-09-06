package net.creepyforest.coregregation.common.items.special;

import net.creepyforest.coregregation.common.events.ChemicalBurnEvent;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SiliconeBouleItem extends Item {

    public SiliconeBouleItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {

        tooltipComponents.add(Component.translatable("coregregation.silicon_boule_tooltip"));
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {

        if (level.isClientSide()) return;
        if (ChemicalBurnEvent.hasHazmatSuit(player)) return; //reusing method cuz why not

        if (!ChemicalBurnEvent.hasHazmatSuit(player)) {
            stack.shrink(1);
            player.addItem(new ItemStack(CoreGregationItems.CONTAMINATED_SILICON_BOULE.get()));
            player.displayClientMessage(Component.translatable("message.coregregation.ruined_silicon_boule"), true);
        }
    }
}

