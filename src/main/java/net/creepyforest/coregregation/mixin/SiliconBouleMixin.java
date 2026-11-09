package net.creepyforest.coregregation.mixin;

import net.creepyforest.coregregation.common.events.ChemicalBurnEvent;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public abstract class SiliconBouleMixin {

    @Unique
    private static final ResourceLocation COREGREGATION$BOULE = new ResourceLocation("gtceu", "silicon_boule");

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    private void coregregation$bouleTick(ItemStack stack, Level level, Entity entity,
                                         int slotId, boolean isSelected, CallbackInfo ci) {
        if (level.isClientSide() || !(entity instanceof Player player)) return;
        if (!COREGREGATION$BOULE.equals(ForgeRegistries.ITEMS.getKey((Item) (Object) this))) return;
        if (ChemicalBurnEvent.hasHazmatSuit(player)) return;

        int count = stack.getCount();
        stack.shrink(count);

        ItemStack ruined = new ItemStack(CoreGregationItems.CONTAMINATED_SILICON_BOULE.get(), count);
        if (!player.getInventory().add(ruined)) {
            player.drop(ruined, false);
        }
        player.displayClientMessage(Component.translatable("message.coregregation.ruined_silicon_boule"), true);
    }
}