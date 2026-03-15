package com.dominioncore.client;

import com.dominioncore.client.input.DominionKeybindings;
import net.fabricmc.api.ClientModInitializer;

public class DominionCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DominionKeybindings.register();
    }
}
