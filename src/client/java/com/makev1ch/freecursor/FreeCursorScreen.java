package com.makev1ch.freecursor;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
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
    public boolean mouseClicked(Click click, boolean doubled) {
        if (click.button() == 0) {
            closeScreen();
            return true;
        }
        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        if (input.key() == GLFW.GLFW_KEY_ESCAPE) {
            closeScreen();
            return true;
        }
        return super.keyPressed(input);
    }

    private void closeScreen() {
        if (this.client != null) {
            FreeCursorConfig config = FreeCursorConfig.getInstance();
            if (config.isSimulateF1()) this.client.options.hudHidden = originalHideGui;
            if (config.isDisableBlur()) this.client.options.getMenuBackgroundBlurriness().setValue(originalMenuBackgroundBlurriness);
            this.client.setScreen(null);
        }
    }
}
