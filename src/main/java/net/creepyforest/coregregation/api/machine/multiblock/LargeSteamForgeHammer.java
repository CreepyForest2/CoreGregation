package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.api.machine.multiblock.StrongSteamParallelMultiBlockMachine;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import org.apache.logging.log4j.core.Core;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.createWorkableCasingMachineModel;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class LargeSteamForgeHammer {

    public static final MultiblockMachineDefinition LargeSteamForgeHammer = REGISTRATE
            .multiblock("large_steam_forge_hammer", StrongSteamParallelMultiBlockMachine::new)
            .rotationState(RotationState.ALL)
            .appearanceBlock(BRONZE_BRICKS_HULL)
            .recipeType(GTRecipeTypes.FORGE_HAMMER_RECIPES)
            .recipeModifier(StrongSteamParallelMultiBlockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" AAA ", "     ", "     ", "     ", "     ", " AAA ", "     ")
                    .aisle("AAAAA", " AAA ", " B B ", " B B ", " B B ", "AAAAA", "     ")
                    .aisle("AAAAA", "AA#AA", "A   A", "A S A", "A S A", "AADAA", "  D  ")
                    .aisle("AAAAA", " AAA ", " B B ", " B B ", " B B ", "AAAAA", "     ")
                    .aisle(" AAA ", "  C  ", "     ", "     ", "     ", " AAA ", "     ")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('A', blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('B', frames(GTMaterials.Bronze))
                    .where('S', blocks(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.Steel)))
                    .where('D', blocks(CASING_STEEL_GEARBOX.get()))
                    .build())
            .model(createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    CoreGregation.id("block/multiblock/large_steam_forge_hammer")))
            .register();

    public static void init() {}
}