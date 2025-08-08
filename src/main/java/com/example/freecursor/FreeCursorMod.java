package com.example.freecursor;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FreeCursorMod implements ClientModInitializer {
    private static KeyBinding toggleKey;
    
    @Override
    public void onInitializeClient() {
        toggleKey = new KeyBinding("key.freecursor.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F6, "category.freecursor.main");
    }
    
    public static void tick(net.minecraft.client.MinecraftClient client) {
        if (toggleKey.wasPressed()) {
            if (client.getCurrentFps() > 0) {
                client.setScreen(new FreeCursorScreen());
            }
        }
    }
}
