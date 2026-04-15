package net.creepyforest.coregregation.common.data.singleblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;

import net.creepyforest.coregregation.api.machine.singleblock.SteamFluidHatchPartMachine;

import net.minecraft.resources.ResourceLocation;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class SingleBlockMachines {

    //Steam:

    //Input hatch

    public static final MachineDefinition STEAM_IMPORT_HATCH = REGISTRATE
            .machine("steam_fluid_input_hatch", holder -> new SteamFluidHatchPartMachine(holder, IO.IN, 4000, 1))
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .colorOverlaySteamHullModel(
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_pipe"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"),
                    new ResourceLocation(GTCEu.MOD_ID, "block/overlay/machine/overlay_fluid_hatch"))
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .langValue("Steam Fluid Input Hatch")
            .register();
    public static void init() {
    }
}
