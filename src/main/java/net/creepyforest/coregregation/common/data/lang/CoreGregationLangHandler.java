package net.creepyforest.coregregation.common.data.lang;

import java.util.Set;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.gregtechceu.gtceu.utils.FormattingUtil;




public class CoreGregationLangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {


    private static final Set<Material> MATERIALS = Set.of();

    public static void init(RegistrateLangProvider provider) {
        Tooltips(provider);
        Common(provider);
        CreativeModeTabs(provider);
    }

    public static void Common(RegistrateLangProvider provider) {
        replace(provider, "death.attack.chemical_burn", "%1$s realized the air is 24%% corrosive gas");
        replace(provider, "death.attack.chemical_burn.player", "%1$s realized the air is 24%% corrosive gas while fighting %2$s");


        replace(provider, "effect.coregregation.chemical_burn", "Chemical Burn");

        //random


        replace(provider, "message.coregregation.ruined_silicon_boule", "You need a hazmat suit to not contaminate silicon boules.");
        replace(provider, "message.coregregation.portal_blocked", "You need a nether portal activator to open the portal.");
    }

    public static void Tooltips(RegistrateLangProvider provider) {

        //steam
        provider.add("coregregation.large_steam_forge_hammer.tooltip", "Forging your plates 8 at a time, with §eSteam");
        provider.add("coregregation.large_steam_centrifugal_unit.tooltip", "Making things spin really fast with the power of §eSteam");
        provider.add("coregregation.large_steam_crusher.tooltip", "Crushing and compacting like never before, with §eSteam");
        provider.add("coregregation.large_steam_foundry.tooltip", "Amalgamating your ingots using hot-hot §eSteam");
        provider.add("coregregation.large_steam_mixing_vessel.tooltip", "Mixing your dough evenly with §eSteam");
        provider.add("coregregation.large_steam_ore_washing_plant.tooltip", "Washing your ores with liquid §eSteam,§r with §eSteam");
        provider.add("coregregation.large_steam_sucker.tooltip", "This sucks! With §eSteam");

        provider.add("coregregation.casing_production_line.tooltip", "Twisting and pulling brass all day");
        provider.add("coregregation.firearm_assember.tooltip", "For all your firearm making needs");


        provider.add("coregregation.steam_parallel_tooltip", "Has §6Steam Parallel,§r meaning it will run 8 recipes §3in parallel§r as fast as 5.3 LV machines of the same kind");
        provider.add("coregregation.steam_energy_tier_tooltip", "Can only run recipes up to the §8LV tier");
        provider.add("coregregation.one_energy_hatch_allowed", "May only accept §bone§r energy hatch");


        //other
        provider.add("coregregation.silicon_boule_tooltip", "§8Don't ask why this item is not from GregTech...");
    }


    public static void CreativeModeTabs(RegistrateLangProvider provider) {

        replace(provider, "creativetab.coregregation_items_tab", "CoreGregation Items");
        replace(provider, "creativetab.coregregation_tools_tab", "CoreGregation Tools");
        replace(provider, "creativetab.coregregation_blocks_tab", "CoreGregation Blocks");
    }
}
