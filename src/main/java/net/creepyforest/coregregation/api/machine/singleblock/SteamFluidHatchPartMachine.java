package net.creepyforest.coregregation.api.machine.singleblock;

import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;
import net.creepyforest.coregregation.common.data.singleblock.SingleBlockMachines;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SteamFluidHatchPartMachine extends FluidHatchPartMachine {

    public SteamFluidHatchPartMachine(IMachineBlockEntity holder, IO io, long initialCapacity, int slots, Object... args) {
        super(holder, 0, io, 8000, 1, args);
    }

    @Override
    public boolean swapIO() {
        BlockPos blockPos = getHolder().pos();
        MachineDefinition newDefinition = null;

        if (io == IO.IN) {
            newDefinition = SingleBlockMachines.STEAM_EXPORT_HATCH;
        } else if (io == IO.OUT) {
            newDefinition = SingleBlockMachines.STEAM_IMPORT_HATCH;
        }
        if (newDefinition == null) return false;



        BlockState newBlockState = newDefinition.getBlock().defaultBlockState();

        getLevel().setBlockAndUpdate(blockPos, newBlockState);

        if (getLevel().getBlockEntity(blockPos) instanceof IMachineBlockEntity newHolder) {
            if (newHolder.getMetaMachine() instanceof SteamFluidHatchPartMachine newMachine) {
                newMachine.setFrontFacing(this.getFrontFacing());
                newMachine.setUpwardsFacing(this.getUpwardsFacing());
                newMachine.setPaintingColor(this.getPaintingColor());
                for (int i = 0; i < this.tank.getTanks(); i++) {
                    newMachine.tank.setFluidInTank(i, this.tank.getFluidInTank(i));
                }
            }
        }
        return true;
    }
}