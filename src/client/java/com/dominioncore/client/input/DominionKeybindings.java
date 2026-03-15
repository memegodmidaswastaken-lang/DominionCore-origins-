package com.dominioncore.client.input;

import com.dominioncore.client.gui.screen.DominionManagerScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class DominionKeybindings {
    private static final String CATEGORY = "key.categories.dominioncore";

    private static KeyBinding openDominionManager;

    private DominionKeybindings() {
    }

    public static void register() {
        openDominionManager = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.dominioncore.open_dominion_manager",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(DominionKeybindings::onClientTick);
    }

    private static void onClientTick(MinecraftClient client) {
        while (openDominionManager.wasPressed()) {
            if (client.player != null) {
                client.setScreen(new DominionManagerScreen());
            }
        }
    }
}
