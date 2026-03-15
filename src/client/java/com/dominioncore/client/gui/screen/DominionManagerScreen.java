package com.dominioncore.client.gui.screen;

import com.dominioncore.client.gui.core.DominionPalette;
import com.dominioncore.client.gui.core.PanelRenderer;
import com.dominioncore.client.gui.core.UiAnimator;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class DominionManagerScreen extends Screen {
    private static final int PANEL_WIDTH = 320;
    private static final int PANEL_HEIGHT = 200;

    private long openedAtMs;

    public DominionManagerScreen() {
        super(Text.translatable("screen.dominioncore.dominion_manager"));
    }

    @Override
    protected void init() {
        super.init();
        this.openedAtMs = System.currentTimeMillis();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        float elapsed = (System.currentTimeMillis() - openedAtMs) / 350.0F;
        float anim = UiAnimator.easeOutCubic(elapsed);

        int animatedWidth = (int) (PANEL_WIDTH * anim);
        int x = centerX - animatedWidth / 2;
        int y = centerY - PANEL_HEIGHT / 2;

        context.fill(0, 0, this.width, this.height, DominionPalette.BACKDROP);
        PanelRenderer.drawPanel(context, x, y, animatedWidth, PANEL_HEIGHT);

        if (animatedWidth > 120) {
            context.drawText(this.textRenderer,
                    Text.translatable("screen.dominioncore.dominion_manager"),
                    x + 12,
                    y + 10,
                    DominionPalette.TEXT_PRIMARY,
                    false);

            context.drawText(this.textRenderer,
                    Text.translatable("screen.dominioncore.tabs"),
                    x + 12,
                    y + 28,
                    DominionPalette.TEXT_MUTED,
                    false);

            drawTab(context, x + 12, y + 42, "Bloodlines");
            drawTab(context, x + 98, y + 42, "Dominions");
            drawTab(context, x + 184, y + 42, "Factions");
            drawTab(context, x + 250, y + 42, "Religion");

            context.drawText(this.textRenderer,
                    Text.translatable("screen.dominioncore.placeholder"),
                    x + 12,
                    y + 85,
                    DominionPalette.TEXT_MUTED,
                    false);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawTab(DrawContext context, int x, int y, String title) {
        int tabWidth = 64;
        int tabHeight = 16;
        context.fill(x, y, x + tabWidth, y + tabHeight, 0x55324B77);
        context.fill(x, y + tabHeight - 1, x + tabWidth, y + tabHeight, DominionPalette.ACCENT_PRIMARY);
        context.drawText(this.textRenderer, Text.literal(title), x + 5, y + 4, DominionPalette.TEXT_PRIMARY, false);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
