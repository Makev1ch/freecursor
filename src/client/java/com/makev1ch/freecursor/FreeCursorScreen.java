package com.makev1ch.freecursor;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class FreeCursorScreen extends Screen {
    
    private final boolean originalHideGui;
    private final int originalMenuBackgroundBlurriness;
    
    public FreeCursorScreen(boolean originalHideGui, int originalMenuBackgroundBlurriness) {
        super(Text.translatable("screen.freecursor.title"));
        this.originalHideGui = originalHideGui;
        this.originalMenuBackgroundBlurriness = originalMenuBackgroundBlurriness;
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            closeScreen();
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            closeScreen();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    private void closeScreen() {
        if (this.client != null) {
            FreeCursorConfig config = FreeCursorConfig.getInstance();
            
            if (config.isSimulateF1()) {
                this.client.options.hudHidden = originalHideGui;
            }
            
            if (config.isDisableBlur()) {
                this.client.options.getMenuBackgroundBlurriness().setValue(originalMenuBackgroundBlurriness);
            }
            
            this.client.setScreen(null);
        }
    }
}
