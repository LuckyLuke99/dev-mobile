package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class Exit extends GenericButton{
    public static boolean isPressed;

    public Exit(final DevMobile game, BitmapFont font, int tamanho) {
        super(GameInfo.menuSkin.getDrawable("exit"),GameInfo.menuSkin.getDrawable("exit_pressed"), font, tamanho);
        button.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

//                Gdx.app.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}

