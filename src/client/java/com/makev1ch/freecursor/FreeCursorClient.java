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
                if (canOpenFreeCursor(client)) {
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
            }
            
            while (configKey.wasPressed()) {
                client.setScreen(new FreeCursorConfigScreen(client.currentScreen));
            }
        });
    }
    
    public static KeyBinding getFreeCursorKey() {
        return freeCursorKey;
    }
    
    private static boolean canOpenFreeCursor(net.minecraft.client.MinecraftClient client) {
        if (client.currentScreen == null) return true;
        
        String screenClass = client.currentScreen.getClass().getSimpleName();
        
        if (screenClass.contains("FreeCursor")) return false;
        if (screenClass.contains("Config")) return false;
        if (screenClass.contains("Menu")) return false;
        if (screenClass.contains("Pause")) return false;
        if (screenClass.contains("Options")) return false;
        if (screenClass.contains("Inventory")) return false;
        if (screenClass.contains("Creative")) return false;
        if (screenClass.contains("Survival")) return false;
        if (screenClass.contains("Chat")) return false;
        if (screenClass.contains("Book")) return false;
        if (screenClass.contains("Sign")) return false;
        if (screenClass.contains("Anvil")) return false;
        if (screenClass.contains("Crafting")) return false;
        if (screenClass.contains("Furnace")) return false;
        if (screenClass.contains("Chest")) return false;
        if (screenClass.contains("Hopper")) return false;
        if (screenClass.contains("Dispenser")) return false;
        if (screenClass.contains("Dropper")) return false;
        if (screenClass.contains("Shulker")) return false;
        if (screenClass.contains("Barrel")) return false;
        if (screenClass.contains("Blast")) return false;
        if (screenClass.contains("Smoker")) return false;
        if (screenClass.contains("Brewing")) return false;
        if (screenClass.contains("Beacon")) return false;
        if (screenClass.contains("Enchanting")) return false;
        if (screenClass.contains("Villager")) return false;
        if (screenClass.contains("Horse")) return false;
        if (screenClass.contains("Donkey")) return false;
        if (screenClass.contains("Mule")) return false;
        if (screenClass.contains("Llama")) return false;
        if (screenClass.contains("Camel")) return false;
        if (screenClass.contains("Boat")) return false;
        if (screenClass.contains("Minecart")) return false;
        if (screenClass.contains("Jukebox")) return false;
        if (screenClass.contains("Note")) return false;
        if (screenClass.contains("Command")) return false;
        if (screenClass.contains("Structure")) return false;
        if (screenClass.contains("Advancement")) return false;
        if (screenClass.contains("Recipe")) return false;
        if (screenClass.contains("Lectern")) return false;
        if (screenClass.contains("Loom")) return false;
        if (screenClass.contains("Stonecutter")) return false;
        if (screenClass.contains("Grindstone")) return false;
        if (screenClass.contains("Smithing")) return false;
        if (screenClass.contains("Cartography")) return false;
        if (screenClass.contains("Fletching")) return false;
        if (screenClass.contains("Cauldron")) return false;
        if (screenClass.contains("Composter")) return false;
        if (screenClass.contains("Beehive")) return false;
        if (screenClass.contains("Bee")) return false;
        if (screenClass.contains("Honey")) return false;
        
        return true;
    }
}
