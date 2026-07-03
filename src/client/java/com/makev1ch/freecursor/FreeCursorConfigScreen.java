package com.makev1ch.freecursor;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public class FreeCursorConfigScreen extends Screen {
    private final Screen parent;
    private FreeCursorConfig config;
    private Button simulateF1Button;
    private Button disableBlurButton;

    public FreeCursorConfigScreen(Screen parent) {
        super(Component.translatable("config.freecursor.title"));
        this.parent = parent;
        this.config = FreeCursorConfig.getInstance();
    }

    @Override
    protected void init() {
        super.init();
        GridLayout gridWidget = new GridLayout();
        gridWidget.defaultCellSetting().paddingHorizontal(5).paddingBottom(4).alignHorizontallyCenter();
        GridLayout.RowHelper adder = gridWidget.createRowHelper(1);

        Component simulateF1Text = Component.translatable("config.freecursor.simulate_f1");
        Component simulateF1Status = config.isSimulateF1() ? Component.translatable("options.on") : Component.translatable("options.off");
        simulateF1Button = Button.builder(
            Component.literal(simulateF1Text.getString() + ": " + simulateF1Status.getString()),
            button -> { config.setSimulateF1(!config.isSimulateF1()); updateButtonTexts(); }
        ).width(200).build();
        adder.addChild(simulateF1Button);

        Component disableBlurText = Component.translatable("config.freecursor.disable_blur");
        Component disableBlurStatus = config.isDisableBlur() ? Component.translatable("options.on") : Component.translatable("options.off");
        disableBlurButton = Button.builder(
            Component.literal(disableBlurText.getString() + ": " + disableBlurStatus.getString()),
            button -> { config.setDisableBlur(!config.isDisableBlur()); updateButtonTexts(); }
        ).width(200).build();
        adder.addChild(disableBlurButton);

        adder.addChild(Button.builder(CommonComponents.GUI_DONE, button -> this.onClose()).width(200).build());
        gridWidget.arrangeElements();
        FrameLayout.alignInRectangle(gridWidget, 0, this.height / 6 + 10, this.width, this.height, 0.5f, 0.0f);
        gridWidget.visitWidgets(this::addRenderableWidget);
    }

    private void updateButtonTexts() {
        Component simulateF1Text = Component.translatable("config.freecursor.simulate_f1");
        Component simulateF1Status = config.isSimulateF1() ? Component.translatable("options.on") : Component.translatable("options.off");
        simulateF1Button.setMessage(Component.literal(simulateF1Text.getString() + ": " + simulateF1Status.getString()));

        Component disableBlurText = Component.translatable("config.freecursor.disable_blur");
        Component disableBlurStatus = config.isDisableBlur() ? Component.translatable("options.on") : Component.translatable("options.off");
        disableBlurButton.setMessage(Component.literal(disableBlurText.getString() + ": " + disableBlurStatus.getString()));
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);
        Component title = Component.translatable("config.freecursor.title");
        graphics.centeredText(this.font, title, this.width / 2, this.height / 6 - 10, 0xFFFFFF);
        int tooltipY = this.height - 40;
        if (simulateF1Button.isHovered()) {
            Component tooltip = Component.translatable("config.freecursor.simulate_f1.tooltip");
            graphics.centeredText(this.font, tooltip, this.width / 2, tooltipY, 0xFFFFFF);
        }
        if (disableBlurButton.isHovered()) {
            Component tooltip = Component.translatable("config.freecursor.disable_blur.tooltip");
            graphics.centeredText(this.font, tooltip, this.width / 2, tooltipY, 0xFFFFFF);
        }
    }

    @Override
    public void onClose() { if (this.minecraft != null) this.minecraft.setScreen(this.parent); }

    @Override
    public boolean isPauseScreen() { return false; }

    @Override
    public boolean isAllowedInPortal() { return true; }
}
