package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.devmobile.game.helpers.GameInfo;

public class GenericLife extends GenericButton{
    public GenericLife(BitmapFont fonte, int tamanho) {
        super(GameInfo.menuSkin.getDrawable("play"), GameInfo.menuSkin.getDrawable("play_pressed"), fonte, tamanho);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("IsChanging");
            }
        });
    }
}
