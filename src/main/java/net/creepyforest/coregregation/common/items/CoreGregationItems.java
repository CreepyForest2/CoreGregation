package net.creepyforest.coregregation.common.items;

import net.creepyforest.coregregation.CoreGregation;
import net.creepyforest.coregregation.common.items.special.FireStarterItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreGregationItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, CoreGregation.MOD_ID);


    //simple items

    public static final RegistryObject<Item> NETHER_PORTAL_ACTIVATOR_ITEM = ITEMS.register("nether_portal_activator", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METALLURGICAL_SILICON_ITEM = ITEMS.register("metallurgical_silicon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONTAMINATED_SILICON_BOULE = ITEMS.register("contaminated_silicon_boule", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLINT_SHARD = ITEMS.register("flint_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLANT_FIBER = ITEMS.register("plant_fiber", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLANT_STRING = ITEMS.register("plant_string", () -> new Item(new Item.Properties()));

    //tools

    public static final RegistryObject<Item> FLINT_KNIFE = ITEMS.register("flint_knife",
            () -> new SwordItem(CoreGregationToolTiers.FLINT, 0, 0.5f, new Item.Properties()));
    public static final RegistryObject<Item> FLINT_HATCHET = ITEMS.register("flint_hatchet",
            () -> new AxeItem(CoreGregationToolTiers.FLINT, 0, 1f, new Item.Properties()));

    //flint tools



    public static final RegistryObject<Item> FIRE_STARTER = ITEMS.register("fire_starter",
            () -> new FireStarterItem());

     public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
     }
}

