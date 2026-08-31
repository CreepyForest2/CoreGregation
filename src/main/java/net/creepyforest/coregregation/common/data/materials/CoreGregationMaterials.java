package net.creepyforest.coregregation.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.creepyforest.coregregation.CoreGregation;

public class CoreGregationMaterials {

    public static Material Tombac;
    public static Material Duraluminium;




    public static void register() {
        Tombac = new Material.Builder(CoreGregation.id("tombac"))
                .ingot()
                .components(GTMaterials.Zinc, 1, GTMaterials.Copper, 4)
                .color(0xFFDF80).secondaryColor(0x840707).iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_ROD)
                .buildAndRegister();
        Duraluminium = new Material.Builder(CoreGregation.id("duraluminium"))
                .ingot()
                .components(GTMaterials.Aluminium, 8, GTMaterials.Copper, 1, GTMaterials.Magnesium, 1)
                .color(0x0077B3).secondaryColor(0x00334D).iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_ROD)
                .buildAndRegister();
    }
}
