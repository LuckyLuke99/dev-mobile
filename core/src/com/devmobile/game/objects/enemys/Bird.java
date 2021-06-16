package com.devmobile.game.objects.enemys;

import com.devmobile.game.objects.enemys.animations.RunAndAttack;

public class Bird extends RunAndAttack {
    public Bird(float x, float y, float range) {
        super("Bird", 16, 16, x, y);
    }
}
