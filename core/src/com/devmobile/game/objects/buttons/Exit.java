package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class Exit extends GenericButton{
    public static boolean isPressed;

    public Exit(final DevMobile game, BitmapFont font, int tamanho) {
        super(GameInfo.menuSkin.getDrawable("exit"),GameInfo.menuSkin.getDrawable("exit_pressed"), font, tamanho);
        isPressed = false;
        button.addListener(new ClickListener(){
            @Override
            public boolean isPressed() {
                return isPressed = true;
            }

        });

    }

}
