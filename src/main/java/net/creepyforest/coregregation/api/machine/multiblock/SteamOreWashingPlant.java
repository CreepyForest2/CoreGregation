package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
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
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GCYMBlocks.CASING_INDUSTRIAL_STEAM;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_PIPE;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SteamOreWashingPlant {
        public static final MultiblockMachineDefinition SteamOreWashingPlant = REGISTRATE
                .multiblock("steam_ore_washing_plant", (holder) -> new SteamParallelMultiblockMachine(holder, 8))
                .rotationState(RotationState.ALL)
                .appearanceBlock(CASING_INDUSTRIAL_STEAM)
                .recipeType(GTRecipeTypes.ORE_WASHER_RECIPES)
                .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
                .addOutputLimit(ItemRecipeCapability.CAP, 1)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("BBBBB", "BBBBB", "BBBBB")
                        .aisle("BBBBB", "BPPPB", "BGGGB")
                        .aisle("BBBBB", "BF#FB", "BGGGB")
                        .aisle("BBBBB", "BPPPB", "BGGGB")
                        .aisle("BBBBB", "BF#FB", "BGGGB")
                        .aisle("BBBBB", "BPPPB", "BGGGB")
                        .aisle("BBBBB", "BBCBB", "BBBBB")
                        .where('C', Predicates.controller(blocks(definition.getBlock())))
                        .where('B', blocks(CASING_INDUSTRIAL_STEAM.get()).setMinGlobalLimited(20)
                                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                                .or(Predicates.abilities(CoreGregationPartAbility.STEAM_IMPORT_HATCH).setExactLimit(1)))
                        .where('G', blocks(Blocks.GLASS))
                        .where('F', frames(GTMaterials.Steel))
                        .where('#', Predicates.air())
                        .where('P', blocks(CASING_STEEL_PIPE.get()))
                        .build())
                .model(GTMachineModels.createWorkableCasingMachineModel(
                        GTCEu.id("block/casings/gcym/industrial_steam_casing"),
                        GTCEu.id("block/machines/ore_washer")))
                .register();

        public static void init() {}
    }

