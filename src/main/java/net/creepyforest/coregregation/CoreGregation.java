    package net.creepyforest.coregregation;


    import com.gregtechceu.gtceu.api.GTCEuAPI;
    import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
    import com.gregtechceu.gtceu.api.machine.MachineDefinition;
    import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
    import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

    import com.mojang.logging.LogUtils;

    import net.creepyforest.coregregation.api.machine.part.CoreGregationPartAbility;
    //import net.creepyforest.coregregation.events.NetherPortalEvent;
    import net.creepyforest.coregregation.common.data.datagen.CoreGregationDataGenerators;
    import net.creepyforest.coregregation.common.data.datagen.Datagen;
    import net.creepyforest.coregregation.common.data.machine.multiblock.MultiBlockMachines;
    import net.creepyforest.coregregation.common.data.materials.CoreGregationMaterials;
    import net.creepyforest.coregregation.api.machine.singleblock.SingleBlockMachines;
    import net.creepyforest.coregregation.common.effects.CoregregationEffects;
    import net.creepyforest.coregregation.common.events.HazmatSuitEvent;
    import net.creepyforest.coregregation.common.events.NetherPortalEvent;
    import net.creepyforest.coregregation.common.items.CoreGregationItems;
    import net.creepyforest.coregregation.common.recipe.CoreGregationRecipeTypes;
    import net.minecraft.resources.ResourceLocation;
    import net.minecraft.world.item.CreativeModeTabs;
    import net.minecraftforge.api.distmarker.Dist;
    import net.minecraftforge.common.MinecraftForge;
    import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

//i want to blow my shit smooth off, this is so confusing
        //all i do is take code from other mods and pray that they work, fuck this
        //fuck constructors mannnnnnnnnnnnnnnnnnnnnnnnn
        //also fuck lambdas
        //and james gosling



        public static final GTRegistrate REGISTRATE = GTRegistrate.create(CoreGregation.MOD_ID);

        public CoreGregation() {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            REGISTRATE.registerEventListeners(modEventBus);

            CoreGregationItems.register(modEventBus);



            MinecraftForge.EVENT_BUS.register(NetherPortalEvent.class);
            Datagen.init();





            modEventBus.addListener(this::commonSetup);
            MinecraftForge.EVENT_BUS.register(this);
            CoregregationEffects.register(modEventBus);
            modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
            modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
            modEventBus.addListener(this::registerMaterials);
            modEventBus.addListener(this::addCreative);
            modEventBus.register(CoreGregationDataGenerators.class);
        }

        private void addCreative(BuildCreativeModeTabContentsEvent event) {
            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                event.accept(CoreGregationItems.NETHER_PORTAL_ACTIVATOR);
            }
        }

        public static void init() {
        }

        public static ResourceLocation id(String path) {
            return new ResourceLocation(MOD_ID, path);
        }


        private void commonSetup(final FMLCommonSetupEvent event) {
            MinecraftForge.EVENT_BUS.register(HazmatSuitEvent.class);
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
            CoreGregationPartAbility.init();
            SingleBlockMachines.init();
            MultiBlockMachines.init();
        }



        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                REGISTRATE.registerRegistrate();
            }
        }

    }