package net.creepyforest.coregregation.common.effects;

import net.creepyforest.coregregation.CoreGregation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.logging.Level;

public class CoregregationEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CoreGregation.MOD_ID);

    public static final RegistryObject<MobEffect> CHEMICAL_BURN = MOB_EFFECTS.register("chemical_burn",
            () -> new ChemicalBurnEffect(MobEffectCategory.HARMFUL, 0x6D7917));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
