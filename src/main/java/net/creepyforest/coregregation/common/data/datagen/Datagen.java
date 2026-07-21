package net.creepyforest.coregregation.common.data.datagen;

import com.tterrag.registrate.providers.ProviderType;
import net.creepyforest.coregregation.common.data.lang.CoreGregationLangHandler;
import org.apache.logging.log4j.core.Core;

import static net.creepyforest.coregregation.CoreGregation.REGISTRATE;

public class Datagen {

    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, CoreGregationLangHandler::init);
        REGISTRATE.addDataGenerator(ProviderType.ITEM_MODEL, CoreGregationItemModelProvider::init);
        
    }
}
