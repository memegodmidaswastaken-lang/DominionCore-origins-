package com.dominioncore;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DominionCoreMod implements ModInitializer {
    public static final String MOD_ID = "dominioncore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("DominionCore initialized: core systems online.");
    }
}
