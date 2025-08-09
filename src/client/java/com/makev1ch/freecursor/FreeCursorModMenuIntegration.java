package com.makev1ch.freecursor;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screen.Screen;

public class FreeCursorModMenuIntegration implements ModMenuApi {
    
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }
    
    private Screen createConfigScreen(Screen parent) {
        return new FreeCursorConfigScreen(parent);
    }
}
