package com.castillix.infiniteExchange.Mixins;

import com.castillix.infiniteExchange.InfiniteExchangeMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class EventLogger {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        InfiniteExchangeMod.LOGGER.info("Mod successfully loaded!");
    }
}
