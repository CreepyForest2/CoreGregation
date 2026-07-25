package net.creepyforest.coregregation.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Flint;

public class MaterialModification {

    public static void modifyMaterials() {
        if (GTMaterials.Flint.hasProperty(PropertyKey.TOOL)) {
            GTMaterials.Flint.removeProperty(PropertyKey.TOOL);
        }
        Flint.setProperty(PropertyKey.TOOL,
                (ToolProperty.Builder.of(4, 4, 64, 0,
                                GTToolType.SWORD,
                                GTToolType.PICKAXE,
                                GTToolType.AXE,
                                GTToolType.SHOVEL,
                                GTToolType.HOE,
                                GTToolType.MORTAR)
                        .build()));
    }

    public static void init() {
    }
}
