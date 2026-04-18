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
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

    public class SteamCrusher {
        public static final MultiblockMachineDefinition SteamFoundry = REGISTRATE
                .multiblock("steam_crusher", (holder) -> new SteamParallelMultiblockMachine(holder, 8))
                .rotationState(RotationState.ALL)
                .appearanceBlock(BRONZE_BRICKS_HULL)
                .recipeType(GTRecipeTypes.COMPRESSOR_RECIPES)
                .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
                .addOutputLimit(ItemRecipeCapability.CAP, 1)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle(" BBB ", " F F ", " F F ", " BBB ")
                        .aisle("BBBBB", "FBBBF", "FB BF", "BBBBB")
                        .aisle("BBBBB", " B#B ", "  S  ", "BBGBB")
                        .aisle("BBBBB", "FBBBF", "FB BF", "BBBBB")
                        .aisle(" BCB ", " F F ", " F F ", " BBB ")
                        .where('C', Predicates.controller(blocks(definition.getBlock())))
                        .where('B', blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(40)
                                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                                .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                        .where('F', frames(GTMaterials.Bronze))
                        .where('#', Predicates.air())
                        .where(' ', Predicates.any())
                        .where('S', blocks(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.Steel)))
                        .where('G', blocks(CASING_STEEL_GEARBOX.get()))
                        .build())
                .model(GTMachineModels.createWorkableCasingMachineModel(
                        GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                        GTCEu.id("block/machines/compressor")))
                .register();

        public static void init() {
        }
    }