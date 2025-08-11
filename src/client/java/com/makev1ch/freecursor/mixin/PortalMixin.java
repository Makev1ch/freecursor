package com.makev1ch.freecursor.mixin;

import com.makev1ch.freecursor.FreeCursorConfigScreen;
import com.makev1ch.freecursor.FreeCursorScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;

@Mixin(ClientPlayerEntity.class)
public class PortalMixin {
    @Redirect(method = "tickNausea", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;"))
    private Screen tickNauseaCurrentScreen(MinecraftClient client) {
        Screen current = client.currentScreen;
        if (current instanceof FreeCursorScreen || current instanceof FreeCursorConfigScreen) return null;
        return current;
    }
}
