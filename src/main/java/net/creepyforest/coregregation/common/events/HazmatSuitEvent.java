package net.creepyforest.coregregation.common.events;

import com.gregtechceu.gtceu.common.data.GTItems;
import net.creepyforest.coregregation.common.effects.CoregregationEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HazmatSuitEvent {
    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getEntity().level().dimension() != Level.NETHER) return;
        if (event.getEntity().level().isClientSide()) return;
        if (player.tickCount % 40 != 0) return;

        if (!hasHazmatSuit(player)) {
            player.addEffect(new MobEffectInstance(CoregregationEffects.CHEMICAL_BURN.get(), 60, 3));
        }
    }

    private static boolean hasHazmatSuit(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(GTItems.HAZMAT_HELMET.get())
                && player.getItemBySlot(EquipmentSlot.CHEST).is(GTItems.HAZMAT_CHESTPLATE.get())
                && player.getItemBySlot(EquipmentSlot.LEGS).is(GTItems.HAZMAT_LEGGINGS.get())
                && player.getItemBySlot(EquipmentSlot.FEET).is(GTItems.HAZMAT_BOOTS.get());
    }}


