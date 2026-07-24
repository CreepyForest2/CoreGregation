package net.creepyforest.coregregation.common.data.datagen;

import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
import net.creepyforest.coregregation.sounds.CoreGregationSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class CoreGregationDataGenerators {
    //original code by Phoenix

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();




        if (event.includeClient()) {
            event.getGenerator().addProvider(true, new SoundEntryBuilder.SoundEntryProvider(packOutput, CoreGregation.MOD_ID));
            event.getGenerator().addProvider(true, new CoreGregationItemModelProvider(packOutput, existingFileHelper));
        }

        generator.addProvider(event.includeServer(), new CoreGregationGlobalLootModifiersProvider(packOutput));
        generator.addProvider(event.includeServer(), new CoreGregationRecipeProvider(packOutput));
    }
}