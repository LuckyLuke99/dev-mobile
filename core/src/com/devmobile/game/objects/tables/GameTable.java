package com.devmobile.game.objects.tables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;
import com.devmobile.game.objects.buttons.Pause;

public class GameTable extends Table{
    private Pause buttonPause;
    private Texture score;

    public GameTable(Skin skin, Stage stage, final DevMobile game, BitmapFont font){
        super(skin);
        setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        debug();
        setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        buttonPause = new Pause(game, font, 6);
        score = new Texture("Seasonal_Tilesets/Autumn_Forest/Background/AutumnForest_BG_04.png");
        this.add(buttonPause.getButton());
        this.row();
        this.debug();
        stage.addActor(this);
    }
}
