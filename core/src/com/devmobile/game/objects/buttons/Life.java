package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

import org.w3c.dom.Text;

import java.awt.Button;

public class Life{
    GenericLife life01, life02, life03;
    public Life(BitmapFont font){
        life01 = new GenericLife(font, 4);
        life02 = new GenericLife(font, 4);
        life03 = new GenericLife(font, 4);
    }

    public TextButton getButton (){
        return life01.getButton();
    }
}
