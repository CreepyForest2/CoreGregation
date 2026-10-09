package net.creepyforest.coregregation.api.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.creepyforest.coregregation.CoreGregation;

public class CoreGregationMaterials {

    public static Material Tombac;
    public static Material SmokelessPowder;
    public static Material RoastedCobalt; //credit to gtnh




    public static void register() {
        Tombac = new Material.Builder(CoreGregation.id("tombac"))
                .ingot()
                .components(GTMaterials.Zinc, 1, GTMaterials.Copper, 4)
                .color(0xFFDF80).secondaryColor(0x840707).iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_ROD)
                .buildAndRegister();
        SmokelessPowder = new Material.Builder(CoreGregation.id("smokeless_powder"))
                .dust()
                .color(0xC7ABA7).secondaryColor(0xDECDC8).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        RoastedCobalt = new Material.Builder(CoreGregation.id("roasted_cobalt"))
                .dust()
                .color(0xB8CC9B).secondaryColor(0x959E85).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
    }
}
