package com.makev1ch.freecursor;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.platform.InputConstants;

public class FreeCursorScreen extends Screen {
    private final boolean originalHideGui;
    private final int originalMenuBackgroundBlurriness;

    public FreeCursorScreen(boolean originalHideGui, int originalMenuBackgroundBlurriness) {
        super(Component.translatable("screen.freecursor.title"));
        this.originalHideGui = originalHideGui;
        this.originalMenuBackgroundBlurriness = originalMenuBackgroundBlurriness;
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean isAllowedInPortal() {
        return true;
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubled) {
        if (event.button() == InputConstants.MOUSE_BUTTON_LEFT) {
            closeScreen();
            return true;
        }
        return super.mouseClicked(event, doubled);
    }

    @Override
    public boolean keyPressed(KeyEvent event) {
        if (event.key() == InputConstants.KEY_ESCAPE) {
            closeScreen();
            return true;
        }
        return super.keyPressed(event);
    }

    private void closeScreen() {
        if (this.minecraft != null) {
            this.minecraft.gui.setScreen(null);
        }
    }

    // Restore the options here rather than in closeScreen(): removed() is called by Minecraft
    // whenever this screen is torn down for ANY reason — click, ESC, or the game swapping the
    // screen out from under us (e.g. going through a portal into another dimension, which loads
    // a new world and replaces the current screen without routing through closeScreen()). This
    // prevents hideGui/blur from getting "stuck" after a dimension change.
    @Override
    public void removed() {
        if (this.minecraft != null) {
            FreeCursorConfig config = FreeCursorConfig.getInstance();
            if (config.isSimulateF1() && this.minecraft.gui.hud.isHidden() != originalHideGui) this.minecraft.gui.hud.toggle();
            if (config.isDisableBlur()) this.minecraft.options.menuBackgroundBlurriness().set(originalMenuBackgroundBlurriness);
        }
        super.removed();
    }
}
