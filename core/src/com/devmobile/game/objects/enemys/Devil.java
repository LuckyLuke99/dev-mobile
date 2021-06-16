package com.devmobile.game.objects.enemys;

import com.devmobile.game.objects.enemys.animations.RunAndAttack;

public class Devil extends RunAndAttack {
    public Devil(float x, float y, float range) {
        super("Devil", 16, 16, x, y);
    }
}
