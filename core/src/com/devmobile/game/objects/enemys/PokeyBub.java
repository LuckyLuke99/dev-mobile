package com.devmobile.game.objects.enemys;

import com.devmobile.game.objects.enemys.animations.JustRun;
import com.devmobile.game.objects.enemys.movements.SideToSide;

public class PokeyBub extends JustRun {
    private SideToSide movement;
    public PokeyBub(float x, float y, float range) {
        super("PokeyBub", 16, 16, x, y);
        movement = new SideToSide(this, range, 30);
    }

    @Override
    public void update() {
        movement.update();
        isFlipped = movement.isMovingRight();
    }
}
