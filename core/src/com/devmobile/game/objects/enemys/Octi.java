package com.devmobile.game.objects.enemys;

import com.devmobile.game.objects.enemys.types.JustRun;
import com.devmobile.game.objects.enemys.types.SideToSide;
import com.devmobile.game.objects.enemys.types.UpAndDown;

public class Octi extends JustRun {
    private UpAndDown movement;
    public Octi(float x, float y, float range) {
        super("Octi", 16, 16, x, y);
        movement = new UpAndDown(this, range, 30);
    }

    @Override
    public void update() {
        movement.update();
    }
}
