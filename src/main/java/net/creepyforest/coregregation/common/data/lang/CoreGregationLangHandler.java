package net.creepyforest.coregregation.common.data.lang;

import java.util.Set;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.gregtechceu.gtceu.utils.FormattingUtil;


public class CoreGregationLangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {


    private static final Set<Material> MATERIALS = Set.of();

    public static void init(RegistrateLangProvider provider) {
        Tooltips(provider);
    }

    public static void Tooltips(RegistrateLangProvider provider) {
        provider.add("coregregation.large.steam.forge.hammer.tooltip.0", "Forging your plates 8 at a time");
    }



























    private static void initItemTooltips(RegistrateLangProvider provider) {
        for (Material material : MATERIALS) {
            provider.add(material.getUnlocalizedName(), FormattingUtil.toEnglishName(material.getName()));
        }

    }
}