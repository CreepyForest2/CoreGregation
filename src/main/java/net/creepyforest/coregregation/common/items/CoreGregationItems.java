package net.creepyforest.coregregation.common.items;

import net.creepyforest.coregregation.CoreGregation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreGregationItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, CoreGregation.MOD_ID);


    public static final RegistryObject<Item> NETHER_PORTAL_ACTIVATOR = ITEMS.register("nether_portal_activator", () -> new Item(new Item.Properties()));


     public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
     }
}
