package com.dominioncore.client.gui.core;

import net.minecraft.client.gui.DrawContext;

public final class PanelRenderer {
    private PanelRenderer() {
    }

    public static void drawPanel(DrawContext context, int x, int y, int width, int height) {
        context.fill(x, y, x + width, y + height, DominionPalette.PANEL);
        context.fill(x, y, x + width, y + 1, DominionPalette.PANEL_BORDER);
        context.fill(x, y + height - 1, x + width, y + height, DominionPalette.PANEL_BORDER);
        context.fill(x, y, x + 1, y + height, DominionPalette.PANEL_BORDER);
        context.fill(x + width - 1, y, x + width, y + height, DominionPalette.PANEL_BORDER);
    }
}
