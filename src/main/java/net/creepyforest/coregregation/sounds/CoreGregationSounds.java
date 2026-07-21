package net.creepyforest.coregregation.sounds;

import net.creepyforest.coregregation.CoreGregation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreGregationSounds {

    @SuppressWarnings("deprecated")

        public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
                ForgeRegistries.SOUND_EVENTS, CoreGregation.MOD_ID);


        public static final RegistryObject<SoundEvent> FLINT_KNAPPING = registerSoundEvents("knapping");



        private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
            return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                    new ResourceLocation(CoreGregation.MOD_ID, name)));
        }





        public static void register(IEventBus eventBus) {
            SOUND_EVENTS.register(eventBus);
        }

        public static void init() {}
}
