package com.example.freecursor.mixin;

import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
    
    @Inject(method = "load", at = @At("TAIL"))
    private void onLoad(CallbackInfo ci) {
        // Убеждаемся, что наш keybinding зарегистрирован в системе
        GameOptions options = (GameOptions)(Object)this;
        // KeyBinding будет автоматически добавлен в список при инициализации мода
    }
}
