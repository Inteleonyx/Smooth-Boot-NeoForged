package com.inteleonyx.smoothboot;

import com.inteleonyx.smoothboot.config.ConfigHandler;
import com.inteleonyx.smoothboot.config.SmoothBootConfig;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod("smoothboot")
public class SmoothBoot {
    public static final String MOD_ID = "smoothboot";
    public static final String NAME = "Smooth Boot (NeoForged)";

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static SmoothBootConfig config;

    public static boolean initConfig = false;
    public static boolean initMainWorker = false;
    public static boolean initIOWorker = false;

    public static int getMaxBackgroundThreads() {
        String string = System.getProperty("max.bg.threads");
        if (string != null) {
            try {
                int i = Integer.parseInt(string);
                if (i >= 1 && i <= 255) {
                    return i;
                }
            }
            catch (NumberFormatException ignored) {}
        }
        return 255;
    }

    public static void regConfig() {
        // Init config
        try {
            config = ConfigHandler.readConfig();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        LOGGER.info(NAME + " config initialized");
    }

}