package net.creepyforest.coregregation.common.data.machine.multiblock;

import net.creepyforest.coregregation.api.machine.multiblock.electric.CartridgeProductionLine;
import net.creepyforest.coregregation.api.machine.multiblock.primitive.Bloomery;
import net.creepyforest.coregregation.api.machine.multiblock.primitive.CookingPot;
import net.creepyforest.coregregation.api.machine.multiblock.primitive.OvenMachine;
import net.creepyforest.coregregation.api.machine.multiblock.steam.*;
import net.creepyforest.coregregation.common.blocks.special.CartridgeAssemblingMechanismBlock;


public class MultiBlockMachines {
    public static void init() {
        LargeSteamForgeHammer.init();
        SteamFoundry.init();
        SteamCrusher.init();
        SteamSucker.init();
        SteamOreWashingPlant.init();
        SteamMixingVessel.init();
        SteamCentrifugalUnit.init();
        OvenMachine.init();
        CookingPot.init();
        Bloomery.init();
        CartridgeProductionLine.init();
    }
}