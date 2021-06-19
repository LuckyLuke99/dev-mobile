package com.devmobile.game.objects.tables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.buttons.Moeda;
import com.devmobile.game.objects.buttons.Pause;
import com.devmobile.game.objects.buttons.Score;
import com.devmobile.game.objects.buttons.Timer;

public class GameTable extends Table{
    private Pause buttonPause;
    private Moeda moeda;

    public GameTable(Skin skin, Stage stage, final DevMobile game, BitmapFont font, BitmapFont font1, Score score, Timer timer){
        super(skin);
        setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() * 0.90f);
        buttonPause = new Pause(game, font, 4);
        moeda = new Moeda(game, font1, 2);
        this.add(moeda.getButton()).padRight(Gdx.graphics.getWidth() * 0.01f);
        this.add(score.getButton()).padRight(Gdx.graphics.getWidth() * 0.30f);
        this.add(timer.getButton()).padRight(Gdx.graphics.getWidth() * 0.30f).padBottom(Gdx.graphics.getWidth() * 0.05f);
        this.add(buttonPause.getButton());
        stage.addActor(this);
    }
}
