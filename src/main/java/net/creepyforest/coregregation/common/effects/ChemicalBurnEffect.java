package net.creepyforest.coregregation.common.effects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import vectorwing.farmersdelight.common.registry.ModDamageTypes;

public class ChemicalBurnEffect extends MobEffect {
    public ChemicalBurnEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
        @Override
        public void applyEffectTick(LivingEntity entity, int amplifier) {
            DamageSource source = new DamageSource(
                    entity.level().registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(CoreGregationDamageTypes.CHEMICAL_BURN));
            entity.hurt(source, 2.0f * (amplifier + 1));
        }

        @Override
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration % 20 == 0;
        }
}

