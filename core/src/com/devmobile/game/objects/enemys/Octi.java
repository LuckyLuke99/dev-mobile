package com.devmobile.game.objects.enemys;

import com.devmobile.game.objects.enemys.animations.JustRun;
import com.devmobile.game.objects.enemys.movements.ToPlayer;

public class Octi extends JustRun {
    private ToPlayer movement;
    public Octi(float x, float y, float range) {
        super("Octi", 16, 16, x, y);
        movement = new ToPlayer(this, range, 30, 1);
    }

    @Override
    public void update() {
        movement.update();
    }
}
