package net.creepyforest.coregregation.common.data.singleblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;

import net.creepyforest.coregregation.api.machine.part.CoreGregationPartAbility;
import net.creepyforest.coregregation.api.machine.singleblock.SteamFluidHatchPartMachine;

import net.minecraft.resources.ResourceLocation;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SingleBlockMachines {

    //Steam:

    //Input hatch

    public static final MachineDefinition STEAM_IMPORT_HATCH = REGISTRATE
            .machine("steam_fluid_input_hatch", holder -> new SteamFluidHatchPartMachine(holder, IO.IN, 8000, 1))
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .abilities(CoreGregationPartAbility.STEAM_IMPORT_FLUIDS)
            .colorOverlaySteamHullModel(
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_pipe"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"))
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .langValue("Steam Fluid Input Hatch")
            .register();
    public static final MachineDefinition STEAM_EXPORT_HATCH = REGISTRATE
            .machine("steam_fluid_output_hatch", holder -> new SteamFluidHatchPartMachine(holder, IO.OUT, 8000, 1))
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.EXPORT_FLUIDS)
            .abilities(CoreGregationPartAbility.STEAM_EXPORT_FLUIDS)
            .colorOverlaySteamHullModel(new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_pipe"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"))
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .langValue("Fluid Output Hatch (Steam)")
            .register();
    public static void init() {
    }
}
