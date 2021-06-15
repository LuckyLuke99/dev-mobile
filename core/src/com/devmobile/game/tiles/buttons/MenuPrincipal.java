package com.devmobile.game.tiles.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class MenuPrincipal {
    private Table table;
    private Play buttonPlay;
    private BitmapFont font;

    public MenuPrincipal (final DevMobile game, BitmapFont font){
        table = new Table(GameInfo.menuSkin);
        this.font = font;
        table.setBounds(0, 0, Gdx.graphics.getWidth()*1.50f, Gdx.graphics.getHeight());
        buttonPlay = new Play(game, font, 6);
        table.add(buttonPlay.getButton());
        table.row();
        table.debug();
    }
}
