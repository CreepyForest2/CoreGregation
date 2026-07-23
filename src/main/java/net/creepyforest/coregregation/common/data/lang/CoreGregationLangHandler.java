package net.creepyforest.coregregation.common.data.lang;

import java.util.Set;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.registries.RegistryObject;


public class CoreGregationLangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {


    private static final Set<Material> MATERIALS = Set.of();

    public static void init(RegistrateLangProvider provider) {
        Tooltips(provider);
        Common(provider);
        Items(provider);
    }

    public static void Common(RegistrateLangProvider provider) {
        replace(provider,"death.attack.chemical_burn", "%1$s realized the air is 24%% corrosive gas");
        replace(provider,"death.attack.chemical_burn.player", "%1$s realized the air is 24%% corrosive gas while fighting %2$s");
        replace(provider, "block.coregregation.cartridge.assembling.mechanism", "Cartridge Assembling Mechanism");

        replace(provider, "effect.coregregation.chemical_burn", "Chemical Burn");

        //random


        replace(provider, "message.coregregation.ruined_silicon_boule", "You need a hazmat suit to not contaminate silicon boules.");
        replace(provider, "message.coregregation.portal_blocked", "You need a nether portal activator to open the portal.");
    }

    public static void Tooltips(RegistrateLangProvider provider) {

        //steam

        provider.add("coregregation.large.steam.forge.hammer.tooltip.0", "Forging your plates 8 at a time");
        provider.add("coregregation.steam_parallel_tooltip", "Has §6Steam Parallel,§r meaning it will run 8 recipes §3in parallel§r as fast as 5.3 LV machines of the same kind");
    }

    public static void Items(RegistrateLangProvider provider) {

        replace(provider, "item.coregregation.nether_portal_activator", "Nether Portal Activator");
        replace(provider, "item.coregregation.contaminated_silicon_boule", "Contaminated Silicon Boule");
        replace(provider, "item.coregregation.flint_shard", "Flint Shard");
        replace(provider, "item.coregregation.flint_knife", "Flint Knife");
        replace(provider, "item.coregregation.plant_fiber", "Plant Fiber");
    }



























    private static void initItemTooltips(RegistrateLangProvider provider) {
        for (Material material : MATERIALS) {
            provider.add(material.getUnlocalizedName(), FormattingUtil.toEnglishName(material.getName()));
        }

    }
}