package com.dominioncore.client.gui.core;

public final class UiAnimator {
    private UiAnimator() {
    }

    public static float easeOutCubic(float t) {
        float clamped = Math.max(0.0F, Math.min(1.0F, t));
        return 1.0F - (float) Math.pow(1.0F - clamped, 3);
    }
}
