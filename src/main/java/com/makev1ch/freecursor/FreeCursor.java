package com.makev1ch.freecursor;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FreeCursor implements ModInitializer {
    public static final String MOD_ID = "freecursor";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("FreeCursor mod initialized!");
        FreeCursorConfig.getInstance();
    }
}
