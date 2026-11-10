package net.creepyforest.coregregation.api.materials.ores;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import net.creepyforest.coregregation.CoreGregation;

public class CoreGregationOres {

    public static Material LightOilSands;

    public static void register() {
        LightOilSands = new Material.Builder(CoreGregation.id("light_oilsands"))
                .ore()
                .dust()
                .color(0xFFDF80).secondaryColor(0x840707).iconSet(MaterialIconSet.CERTUS)
                .buildAndRegister();
    }
}
