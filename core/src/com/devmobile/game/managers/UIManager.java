package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;

public class UIManager {
    final DevMobile game;

    private Table table;
    private ButtonsManager manager;

    public UIManager(final DevMobile game){
        this.game = game;

    }

    public void invisible(Table table){
        table.setVisible(false);
    }

    public void visible(Table table){
        table.setVisible(true);
    }

    public void clearTable(){
        table.clear();
    }

    public void draw(SpriteBatch batch) {

    }
}
