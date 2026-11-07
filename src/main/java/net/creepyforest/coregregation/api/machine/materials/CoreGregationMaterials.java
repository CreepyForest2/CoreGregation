package net.creepyforest.coregregation.api.machine.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.creepyforest.coregregation.CoreGregation;

public class CoreGregationMaterials {

    public static Material Tombac;
    public static Material SmokelessPowder;
    public static Material MicaPaste;
    public static Material Asurine;
    public static Material Crimsite;
    public static Material Limestone;
    public static Material Ochrum;
    public static Material Scoria;
    public static Material Scorchia;
    public static Material Veridium;



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
        MicaPaste = new Material.Builder(CoreGregation.id("mica_paste"))
                .fluid()
                .color(0xCC8BC7).secondaryColor(0xA9DA).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();



        Asurine = new Material.Builder(CoreGregation.id("asurine"))
                .dust()
                .color(0x4D8FAD).secondaryColor(0x75B8CC).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Crimsite = new Material.Builder(CoreGregation.id("crimsite"))
                .dust()
                .color(0xA94A55).secondaryColor(0xC76B72).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Limestone = new Material.Builder(CoreGregation.id("limestone"))
                .dust()
                .color(0xD8D2B5).secondaryColor(0xEEE6CC).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Ochrum = new Material.Builder(CoreGregation.id("ochrum"))
                .dust()
                .color(0xC9A34C).secondaryColor(0xE4C574).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Scoria = new Material.Builder(CoreGregation.id("scoria"))
                .dust()
                .color(0x5B403A).secondaryColor(0x806057).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Scorchia = new Material.Builder(CoreGregation.id("scorchia"))
                .dust()
                .color(0x4C4148).secondaryColor(0x75636C).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        Veridium = new Material.Builder(CoreGregation.id("veridium_"))
                .dust()
                .color(0x568C78).secondaryColor(0x82B39A).iconSet(MaterialIconSet.DULL)
                .langValue("aaaaaaaaaaaaaaaaaaaaa")
                .buildAndRegister();
    }
}
