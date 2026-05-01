    package net.creepyforest.coregregation;


    import com.gregtechceu.gtceu.api.GTCEuAPI;
    import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
    import com.gregtechceu.gtceu.api.machine.MachineDefinition;
    import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
    import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

    import com.mojang.logging.LogUtils;
    import net.creepyforest.coregregation.api.machine.part.CoreGregationPartAbility;
    import net.creepyforest.coregregation.common.data.datagen.Datagen;
    import net.creepyforest.coregregation.common.data.machine.multiblock.MultiBlockMachines;
    import net.creepyforest.coregregation.common.data.materials.CoreGregationMaterials;
    import net.creepyforest.coregregation.common.data.singleblock.SingleBlockMachines;
    import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
    import net.minecraft.resources.ResourceLocation;
    import net.minecraftforge.api.distmarker.Dist;
    import net.minecraftforge.common.MinecraftForge;
    import net.minecraftforge.event.server.ServerStartingEvent;
    import net.minecraftforge.eventbus.api.IEventBus;
    import net.minecraftforge.eventbus.api.SubscribeEvent;
    import net.minecraftforge.fml.common.Mod;
    import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
    import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
    import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
    import org.slf4j.Logger;



    @Mod(CoreGregation.MOD_ID)
    public class CoreGregation {
        public static final String MOD_ID = "coregregation";
        public static final Logger LOGGER = LogUtils.getLogger();

        public static final GTRegistrate REGISTRATE = GTRegistrate.create(MOD_ID);

        public CoreGregation() {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            REGISTRATE.registerEventListeners(modEventBus);

            Datagen.init();


            modEventBus.addListener(this::commonSetup);
            MinecraftForge.EVENT_BUS.register(this);

            modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
            modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
            modEventBus.addListener(this::registerMaterials);
        }

        public static void init() {
        }

        public static ResourceLocation id(String path) {
            return new ResourceLocation(MOD_ID, path);
        }


        private void commonSetup(final FMLCommonSetupEvent event) {
        }



        // You can use SubscribeEvent and let the Event Bus discover methods to call
        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event) {
        }
        @SubscribeEvent
        public void registerMaterials(MaterialEvent event) {
            CoreGregationMaterials.register();
        }

        public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
            CoreGregationRecipeTypes.init();
        }

        private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
            CoreGregationRecipeTypes.init();
            CoreGregationPartAbility.init();
            SingleBlockMachines.init();
            MultiBlockMachines.init();
        }



        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {

            }
        }

    }