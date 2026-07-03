package com.makev1ch.freecursor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyMapping.Category;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class FreeCursorClient implements ClientModInitializer {
    private static final Category FREECURSOR_CATEGORY = Category.register(Identifier.fromNamespaceAndPath("freecursor", "freecursor"));

    private static KeyMapping freeCursorKey;
    private static KeyMapping configKey;

    @Override
    public void onInitializeClient() {
        FreeCursor.LOGGER.info("FreeCursor client initialized!");

        freeCursorKey = KeyMappingHelper.registerKeyMapping(
            new KeyMapping(
                "key.freecursor.toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_F6,
                FREECURSOR_CATEGORY
            )
        );

        configKey = KeyMappingHelper.registerKeyMapping(
            new KeyMapping(
                "key.freecursor.config",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                FREECURSOR_CATEGORY
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (freeCursorKey.consumeClick()) {
                FreeCursorConfig config = FreeCursorConfig.getInstance();

                boolean originalHideGui = client.options.hideGui;
                int originalMenuBackgroundBlurriness = client.options.menuBackgroundBlurriness().get();

                if (config.isSimulateF1()) {
                    client.options.hideGui = true;
                }

                if (config.isDisableBlur()) {
                    client.options.menuBackgroundBlurriness().set(0);
                }

                FreeCursorScreen screen = new FreeCursorScreen(originalHideGui, originalMenuBackgroundBlurriness);
                client.setScreen(screen);
            }

            while (configKey.consumeClick()) {
                client.setScreen(new FreeCursorConfigScreen(client.screen));
            }
        });
    }

    public static KeyMapping getFreeCursorKey() {
        return freeCursorKey;
    }
}
