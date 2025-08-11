package com.makev1ch.freecursor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FreeCursorClient implements ClientModInitializer {
    
    private static KeyBinding freeCursorKey;
    private static KeyBinding configKey;
    
    @Override
    public void onInitializeClient() {
        FreeCursor.LOGGER.info("FreeCursor client initialized!");
        
        freeCursorKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.freecursor.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_F6,
            "category.freecursor"
        ));
        
        configKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.freecursor.config",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_N,
            "category.freecursor"
        ));
        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (freeCursorKey.wasPressed()) {
                FreeCursorConfig config = FreeCursorConfig.getInstance();
                
                boolean originalHideGui = client.options.hudHidden;
                int originalMenuBackgroundBlurriness = client.options.getMenuBackgroundBlurriness().getValue();
                
                if (config.isSimulateF1()) {
                    client.options.hudHidden = true;
                }
                
                if (config.isDisableBlur()) {
                    client.options.getMenuBackgroundBlurriness().setValue(0);
                }
                
                FreeCursorScreen screen = new FreeCursorScreen(originalHideGui, originalMenuBackgroundBlurriness);
                client.setScreen(screen);
            }
            
            while (configKey.wasPressed()) {
                client.setScreen(new FreeCursorConfigScreen(client.currentScreen));
            }
        });
    }
    
    public static KeyBinding getFreeCursorKey() {
        return freeCursorKey;
    }
}
