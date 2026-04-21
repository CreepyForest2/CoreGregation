package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.api.machine.part.CoreGregationPartAbility;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GCYMBlocks.CASING_INDUSTRIAL_STEAM;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_GEARBOX;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SteamMixingVessel {
    public static final MultiblockMachineDefinition SteamMixingVessel = REGISTRATE
            .multiblock("steam_mixing_vessel", (holder) -> new SteamParallelMultiblockMachine(holder, 8))
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_INDUSTRIAL_STEAM)
            .recipeType(GTRecipeTypes.MIXER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" BBB ", " BBB ", " BBB ", " BBB ", " BBB ", "  F  ", "  B  ")
                    .aisle("BBBBB", "BS#SB", "B###B", "BS#SB", "B###B", "     ", " BBB ")
                    .aisle("BBBBB", "B#G#B", "B#G#B", "B#G#B", "B#G#B", "F G F", "BBBBB")
                    .aisle("BBBBB", "BS#SB", "B###B", "BS#SB", "B###B", "     ", " BBB ")
                    .aisle(" BBB ", " BCB ", " BBB ", " BBB ", " BBB ", "  F  ", "  B  ")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('B', blocks(CASING_INDUSTRIAL_STEAM.get()).setMinGlobalLimited(20)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(CoreGregationPartAbility.STEAM_IMPORT_FLUIDS).setExactLimit(1))
                            .or(Predicates.abilities(CoreGregationPartAbility.STEAM_EXPORT_FLUIDS).setExactLimit(1)))
                    .where('F', frames(GTMaterials.Steel))
                    .where('#', Predicates.air())
                    .where('S', blocks(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.WroughtIron)))
                    .where('G', blocks(CASING_STEEL_GEARBOX.get()))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/gcym/industrial_steam_casing"),
                    GTCEu.id("block/multiblock/gcym/large_cutter")))
            .register();

    public static void init() {}
}

