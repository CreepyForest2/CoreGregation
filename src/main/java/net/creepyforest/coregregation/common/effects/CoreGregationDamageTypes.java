package net.creepyforest.coregregation.common.effects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class CoreGregationDamageTypes {
    public static final ResourceKey<DamageType> CHEMICAL_BURN = ResourceKey.create(
            Registries.DAMAGE_TYPE,
            new ResourceLocation("coregregation", "chemical_burn")
    );
}
