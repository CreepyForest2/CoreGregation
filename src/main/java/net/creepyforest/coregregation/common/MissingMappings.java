package net.creepyforest.coregregation.common;

import com.gregtechceu.gtceu.forge.ForgeCommonEventListener;
import net.creepyforest.coregregation.common.items.CoreGregationItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.MissingMappingsEvent;

public class MissingMappings {

    //credit to the tfg team for the code


    @SubscribeEvent
    public static void remapIds(MissingMappingsEvent event) {
       // event.getAllMappings(Registries.ITEM).forEach(ForgeCommonEventListener::remapItems);
    }


    private static void remapItems(MissingMappingsEvent.Mapping<Item> mapping) {
        if(mapping.getKey().equals("notreepunching:fire_starter")) mapping.remap(CoreGregationItems.FIRE_STARTER.get());
    }
}
