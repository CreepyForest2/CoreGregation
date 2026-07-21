
package net.creepyforest.coregregation.api.machine.multiblock.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import net.creepyforest.coregregation.common.blocks.CoreGregationBlocks;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;


public class CartridgeProductionLine {

    //TODO vezi cum faci cu necking si cu trim
    public static final MachineDefinition CartridgeProductionLine = REGISTRATE
            .multiblock("cartridge_production_line", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.nullToEmpty("coregregation"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(CoreGregationRecipeTypes.CARTRIDGE_PRODUCTION_LINE_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("SSSSS", "F   F", "F   F", "F   F", "SSSSS")
                    .aisle("SSSSS", " SSS ", " SGS ", " SSS ", "SSSSS")
                    .aisle("SSSSS", " SBS " ," GMG ", " SBS ", "SSSSS")
                    .aisle("SSSSS", " SBS ", " GMG ", " SBS ", "SSSSS")
                    .aisle("SSSSS", " SBS ", " GMG ", " SBS ", "SSSSS")
                    .aisle("SSSSS", " SBS ", " GMG ", " SBS ", "SSSSS")
                    .aisle("SSSSS", " SBS ", " GMG ", " SBS ", "SSSSS")
                    .aisle("SSSSS", " SCS ", " SGS ", " SSS ", "SSSSS")
                    .aisle("SSSSS", "F   F", "F   F", "F   F", "SSSSS")
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where(' ', any())
                    .where('G', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('S', blocks(GTBlocks.CASING_STEEL_SOLID.get())
                                    .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(1)))
                    .where('B', blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('M', blocks(CoreGregationBlocks.CARTRIDGE_ASSEMBLING_MECHANISM_BLOCK.get()))
                    .where('F', frames(GTMaterials.Invar))
                    .build())
                    .model(GTMachineModels.createWorkableCasingMachineModel(
                      GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                      GTCEu.id("block/multiblock/blast_furnace")))
            .register();



    public static void init() {}
}







