package net.creepyforest.coregregation.common.data.datagen;

import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;
import net.creepyforest.coregregation.CoreGregation;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CoreGregationDataGenerators {
    //original code by Pheonix

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();

        if (event.includeClient()) {
            event.getGenerator().addProvider(
                    true,
                    new SoundEntryBuilder.SoundEntryProvider(packOutput, CoreGregation.MOD_ID));
        }
    }
}