package net.creepyforest.coregregation.api.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.DrumMachineItem;
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
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_GEARBOX;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SteamCentrifugalUnit {
    public static final MultiblockMachineDefinition SteamCentrifugalUnit = REGISTRATE
            .multiblock("steam_centrifugal_unit", (holder) -> new SteamParallelMultiblockMachine(holder, 8))
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_INDUSTRIAL_STEAM)
            .recipeType(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("         ", "  BBBBB  ", "         ")
                    .aisle("  BBBBB  ", " BB#b#BB ", "  BBBBB  ")
                    .aisle(" BBBBBBB ", "BB##W##BB", " BBBBBBB ")
                    .aisle(" BBBBBBB ", "B###W###B", " BBBBBBB ")
                    .aisle(" BBBBBBB ", "BdWWGWWdB", " BBBGBBB ")
                    .aisle(" BBBBBBB ", "B###W###B", " BBBBBBB ")
                    .aisle(" BBBBBBB ", "BB##W##BB", " BBBBBBB ")
                    .aisle("  BBBBB  ", " BB#b#BB ", "  BBBBB  ")
                    .aisle("         ", "  BBCBB  ", "         ")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('B', blocks(CASING_INDUSTRIAL_STEAM.get()).setMinGlobalLimited(100)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(CoreGregationPartAbility.STEAM_IMPORT_FLUIDS).setExactLimit(1))
                            .or(Predicates.abilities(CoreGregationPartAbility.STEAM_EXPORT_FLUIDS).setExactLimit(1)))
                    .where('#', Predicates.air())
                    .where('W', blocks(ChemicalHelper.getBlock(TagPrefix.block, GTMaterials.WroughtIron)))
                    .where('d', blocks(CASING_BRONZE_PIPE.get()))
                    .where('b', blocks(Blocks.BARREL))
                    .where('G', blocks(CASING_STEEL_GEARBOX.get()))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/gcym/industrial_steam_casing"),
                    GTCEu.id("block/multiblock/generator/large_steam_turbine")))
            .register();

    public static void init() {}
}

