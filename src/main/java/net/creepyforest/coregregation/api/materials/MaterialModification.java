package net.creepyforest.coregregation.api.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.ArmorProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.item.armor.GTArmorItem;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Copper;


public class MaterialModification {

    public static void modifyMaterials() {
        if (Copper.hasProperty(PropertyKey.TOOL)) {
            Copper.removeProperty(PropertyKey.TOOL);
        }
        Copper.setProperty(PropertyKey.TOOL,
                (ToolProperty.Builder.of(5, 5, 180, 1,
                                GTToolType.SWORD,
                                GTToolType.PICKAXE,
                                GTToolType.AXE,
                                GTToolType.SHOVEL,
                                GTToolType.HOE)
                        .build()));
        Copper.setProperty(PropertyKey.ARMOR,
                ArmorProperty.Builder.of(10, new int[]{2, 5, 4, 1})
                        .enchantability(8)
                        .build());
    }

    public static void init() {
    }
}
