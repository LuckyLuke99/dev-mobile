package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class Moeda extends GenericButton {
    public Moeda(final DevMobile game, BitmapFont font, int tamanho) {
        super(GameInfo.menuSkin.getDrawable("coin_medium_01"), font, tamanho);
    }
}
