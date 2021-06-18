package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.scenes.GameScreen;
import com.devmobile.game.scenes.MenuScreen;

public class Exit extends GenericButton{

    public Exit(final DevMobile game, BitmapFont font, int tamanho) {
        super(GameInfo.menuSkin.getDrawable("exit"),GameInfo.menuSkin.getDrawable("exit_pressed"), font, tamanho);
        button.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                switch (GameInfo.currentScreen){
                    case MENU:
                        Gdx.app.exit();
                        break;
                    case GAMEPAUSE:
                        game.setScreen(new MenuScreen(game));
                        break;
                }
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
