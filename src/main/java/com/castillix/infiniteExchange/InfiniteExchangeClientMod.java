package com.castillix.infiniteExchange;

import com.castillix.infiniteExchange.Screens.CustomScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class InfiniteExchangeClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        InfiniteExchangeMod.LOGGER.info("client loaded");
        ScreenRegistry.register(InfiniteExchangeMod.CUSTOM_SCREEN_HANDLER, CustomScreen::new);
    }
}
