package net.creepyforest.coregregation.api.machine.multiblock.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.api.recipe.CoreGregationRecipeTypes;
import net.creepyforest.coregregation.common.blocks.CoreGregationBlocks;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class ElectricOven {

    public static final MachineDefinition ElectricOven = REGISTRATE
            .multiblock("electric_oven", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(CoreGregationRecipeTypes.OVEN_RECIPES)
            .recipeType(GTRecipeTypes.FURNACE_RECIPES)
            .appearanceBlock(CoreGregationBlocks.PORCELAIN_ENAMELED_STEEL_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("PPPPP", "F###F", "PPPPP")
                    .aisle("PPPPP", "#ccc#", "PPPPP")
                    .aisle("PPPPP", "#c c#", "PPPPP")
                    .aisle("PPPPP", "#ccc#", "PPPPP")
                    .aisle("PPCPP", "F###F", "PPPPP")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where(' ', any())
                    .where('c', heatingCoils())
                    .where('P', blocks(CoreGregationBlocks.PORCELAIN_ENAMELED_STEEL_CASING.get()).setMinGlobalLimited(30)
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY)))
                    .where('F', frames(GTMaterials.BlackSteel))
                    .where('#', air())
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    CoreGregation.id("block/casings/porcelain_enameled_steel_casing"),
                    GTCEu.id("block/multiblock/blast_furnace")))
            .tooltips(Component.translatable("coregregation.electric_oven.tooltip"),
                    Component.translatable("gtceu.machine.available_recipe_map_2.tooltip", "Oven Recipes", "Smoker Recipes"))
            .register();



    public static void init() {}
}

