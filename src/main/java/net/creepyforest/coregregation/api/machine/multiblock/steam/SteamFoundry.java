package net.creepyforest.coregregation.api.machine.multiblock.steam;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels; // only once
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SteamFoundry {
    public static final MultiblockMachineDefinition SteamFoundry = REGISTRATE
            .multiblock("steam_foundry", (holder) -> new SteamParallelMultiblockMachine(holder, 8))
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FFFFF", "BBBBB", "BBBBB")
                    .aisle("FFFFF", "BPPPB", "BBBBB")
                    .aisle("FFFFF", "BGCGB", "BBBBB")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('B', blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(15)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .where('F', blocks(FIREBOX_BRONZE.get()).setMinGlobalLimited(10)
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('G', blocks(Blocks.GLASS))
                    .where('P', blocks(CASING_BRONZE_PIPE.get()))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/alloy_smelter")))
            .register();

    public static void init() {}
}