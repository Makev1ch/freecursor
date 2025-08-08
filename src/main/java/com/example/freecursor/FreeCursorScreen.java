package com.example.freecursor;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class FreeCursorScreen extends Screen {
    public FreeCursorScreen() {
        super(Text.empty());
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.close();
        return true;
    }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
}
