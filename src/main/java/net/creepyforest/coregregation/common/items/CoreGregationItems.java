package net.creepyforest.coregregation.common.items;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.items.special.FireStarterItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class CoreGregationItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, CoreGregation.MOD_ID);



    public static ItemEntry<Item> NETHER_PORTAL_ACTIVATOR_ITEM;
    public static ItemEntry<Item> METALLURGICAL_SILICON;
    public static ItemEntry<Item> CONTAMINATED_SILICON_BOULE;
    public static ItemEntry<Item> FLINT_SHARD;
    public static ItemEntry<Item> PLANT_FIBER;
    public static ItemEntry<Item> PLANT_STRING;
    public static ItemEntry<Item> FLINT_SAW_HEAD;
    public static ItemEntry<Item> SMALL_BRASS_CASING_DISK;
    public static ItemEntry<Item> MEDIUM_SIZED_BRASS_CASING_DISK;
    public static ItemEntry<Item> BIG_CASING_BRASS_CASING_DISK;
    public static ItemEntry<Item> HUGE_CASING_BRASS_CASING_DISK;
    public static ItemEntry<Item> SMALL_STEEL_CASING_DISK;
    public static ItemEntry<Item> MEDIUM_SIZED_STEEL_CASING_DISK;
    public static ItemEntry<Item> BIG_STEEL_CASING_DISK;
    public static ItemEntry<Item> HUGE_STEEL_CASING_DISK;
    public static ItemEntry<Item> SMALL_COPPER_BULLET_DISK;
    public static ItemEntry<Item> MEDIUM_SIZED_COPPER_BULLET_DISK;
    public static ItemEntry<Item> BIG_COPPER_BULLET_DISK;
    public static ItemEntry<Item> HUGE_COPPER_BULLET_DISK;
    public static ItemEntry<Item> UNFINISHED_LV_CONVEYOR_MODULE;
    public static ItemEntry<Item> UNFINISHED_LV_ROBOT_ARM;
    public static ItemEntry<Item> UNFINISHED_LV_ELECTRIC_PUMP;
    public static ItemEntry<Item> UNFINISHED_LV_ELECTRIC_PISTON;
    public static ItemEntry<Item> RUBBER_BELT;
    public static ItemEntry<Item> WEAK_MICA_INSULATOR_SHEET;
    public static ItemEntry<Item> MICA_INSULATOR_SHEET;
    public static ItemEntry<Item> MICA_INSULATOR_FOIL;

    public static ItemEntry<SwordItem> FLINT_KNIFE;
    public static ItemEntry<AxeItem> FLINT_HATCHET;
    public static ItemEntry<SwordItem> FLINT_SWORD;
    public static ItemEntry<PickaxeItem> FLINT_PICKAXE;
    public static ItemEntry<AxeItem> FLINT_AXE;
    public static ItemEntry<ShovelItem> FLINT_SHOVEL;
    public static ItemEntry<HoeItem> FLINT_HOE;
    public static ItemEntry<FireStarterItem> FIRE_STARTER;
    public static ItemEntry<SwordItem> FLINT_SAW;






    static {
        //to be implemented REGISTRATE.creativeModeTab(() -> CoreGregationCreativeModeTabs.COREGREGATION_ITEMS_TAB);

        //simple items
        NETHER_PORTAL_ACTIVATOR_ITEM = REGISTRATE.item("nether_portal_activator", Item::new).lang("Nether Portal Activator").register();
        CONTAMINATED_SILICON_BOULE = REGISTRATE.item("contaminated_silicon_boule", Item::new).lang("Contaminated Silicon Boule").register();
       METALLURGICAL_SILICON = REGISTRATE.item("metallurgical_silicon", Item::new).lang("Metallurgical Silicon").model(NonNullBiConsumer.noop()).register();
        FLINT_SHARD = REGISTRATE.item("flint_shard", Item::new).lang("Flint Shard").register();
        PLANT_FIBER = REGISTRATE.item("plant_fiber", Item::new).lang("Plant Fiber").register();
        PLANT_STRING = REGISTRATE.item("plant_string", Item::new).lang("Plant String").register();
        FLINT_SAW_HEAD = REGISTRATE.item("flint_saw_head", Item::new).lang("Flint Saw Head").register();
        METALLURGICAL_SILICON = REGISTRATE.item("metallurgical_silicon", Item::new).lang("Nether Portal Activator").register();
        METALLURGICAL_SILICON = REGISTRATE.item("metallurgical_silicon", Item::new).lang("Nether Portal Activator").register();
        METALLURGICAL_SILICON = REGISTRATE.item("metallurgical_silicon", Item::new).lang("Nether Portal Activator").register();
        METALLURGICAL_SILICON = REGISTRATE.item("metallurgical_silicon", Item::new).lang("Nether Portal Activator").register();

        //bullet related things
        SMALL_BRASS_CASING_DISK = REGISTRATE.item("small_brass_casing_disk", Item::new).lang("Small Brass Casing Disk").register();
        MEDIUM_SIZED_BRASS_CASING_DISK = REGISTRATE.item("medium_sized_brass_casing_disk", Item::new).lang("Medium Sized Brass Casing Disk").register();
        BIG_CASING_BRASS_CASING_DISK = REGISTRATE.item("big_brass_casing_disk", Item::new).lang("Big Brass Casing Disk").register();
        HUGE_CASING_BRASS_CASING_DISK = REGISTRATE.item("huge_brass_casing_disk", Item::new).lang("Huge Brass Casing Disk").register();

        SMALL_STEEL_CASING_DISK = REGISTRATE.item("small_steel_casing_disk", Item::new).lang("Small Steel Casing Disk").register();
        MEDIUM_SIZED_STEEL_CASING_DISK = REGISTRATE.item("medium_sized_steel_casing_disk", Item::new).lang("Medium Sized Steel Casing Disk").register();
        BIG_STEEL_CASING_DISK = REGISTRATE.item("big_steel_casing_disk", Item::new).lang("Big Steel Casing Disk").register();
        HUGE_STEEL_CASING_DISK = REGISTRATE.item("huge_steel_casing_disk", Item::new).lang("Huge Steel Casing Disk").register();

        SMALL_COPPER_BULLET_DISK = REGISTRATE.item("small_copper_bullet_disk", Item::new).lang("Small Copper Bullet Disk").register();
        MEDIUM_SIZED_COPPER_BULLET_DISK = REGISTRATE.item("medium_sized_copper_bullet_disk", Item::new).lang("Medium Sized Copper Bullet Disk").register();
        BIG_COPPER_BULLET_DISK = REGISTRATE.item("big_copper_bullet_disk", Item::new).lang("Big Copper Bullet Disk").register();
        HUGE_COPPER_BULLET_DISK = REGISTRATE.item("huge_copper_bullet_disk", Item::new).lang("Huge Copper Bullet Disk").register();

        //intermediate stuff
        UNFINISHED_LV_CONVEYOR_MODULE = REGISTRATE.item("unfinished_lv_conveyor_module", Item::new).lang("Unfinished LV Conveyor Module").register();
        UNFINISHED_LV_ROBOT_ARM = REGISTRATE.item("unfinished_lv_robot_arm", Item::new).lang("Unfinished LV Robot Arm").register();
        UNFINISHED_LV_ELECTRIC_PUMP = REGISTRATE.item("unfinished_lv_electric_pump", Item::new).lang("Unfinished LV Electric Pump").register();
        UNFINISHED_LV_ELECTRIC_PISTON = REGISTRATE.item("unfinished_lv_electric_piston", Item::new).lang("Unfinished LV Electric Piston").register();
        RUBBER_BELT = REGISTRATE.item("rubber_belt", Item::new).lang("Rubber Belt").register();
        WEAK_MICA_INSULATOR_SHEET = REGISTRATE.item("weak_mica_insulator_sheet", Item::new).lang("Weak Mica Insulator Sheet").register();
        MICA_INSULATOR_SHEET = REGISTRATE.item("mica_insulator_sheet", Item::new).lang("Mica Insulator Sheet").register();
        MICA_INSULATOR_FOIL = REGISTRATE.item("mica_insulator_foil", Item::new).lang("Mica Insulator Foil").register();

        //tools
        FLINT_KNIFE = REGISTRATE.item("flint_knife",properties -> new SwordItem(CoreGregationToolTiers.FLINT, 0, 0.5f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.SWORDS)
                .register();
        FLINT_HATCHET = REGISTRATE.item("flint_hatchet",properties -> new AxeItem(CoreGregationToolTiers.FLINT_HATCHET_TIER, 0, -3.15f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.AXES)
                .register();

        FLINT_SWORD = REGISTRATE.item("flint_sword",properties -> new SwordItem(CoreGregationToolTiers.FLINT, 3, -2.4f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.SWORDS)
                .register();
        FLINT_PICKAXE = REGISTRATE.item("flint_pickaxe",properties -> new PickaxeItem(CoreGregationToolTiers.FLINT, 1, -2.4f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.PICKAXES)
                .register();
        FLINT_AXE = REGISTRATE.item("flint_axe",properties -> new AxeItem(CoreGregationToolTiers.FLINT, 6, -3.15f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.AXES)
                .register();
        FLINT_SHOVEL = REGISTRATE.item("flint_axe",properties -> new ShovelItem(CoreGregationToolTiers.FLINT, 1, -3.0f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.SHOVELS)
                .register();
        FLINT_HOE = REGISTRATE.item("flint_hoe",properties -> new HoeItem(CoreGregationToolTiers.FLINT, 3, -1.5f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .tag(ItemTags.HOES)
                .register();

        FIRE_STARTER = REGISTRATE.item("fire_starter",properties -> new FireStarterItem(properties.durability(10)))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .register();
        FLINT_SAW = REGISTRATE.item("flint_saw",properties -> new SwordItem(CoreGregationToolTiers.FLINT, 2, -3f, properties))
                .model((context, provider) -> provider.handheld(context::getEntry))
                .register();
    }
     public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
     }
}

