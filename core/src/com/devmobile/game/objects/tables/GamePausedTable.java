package com.devmobile.game.objects.tables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.buttons.Exit;
import com.devmobile.game.objects.buttons.Moeda;
import com.devmobile.game.objects.buttons.Pause;
import com.devmobile.game.objects.buttons.Score;

public class GamePausedTable extends Table {
    private Moeda moeda;
    private Score score;
    private Table mainTable;

    public GamePausedTable(Skin skin, Stage stage, final DevMobile game, BitmapFont font, BitmapFont font1){
        super(skin);
        mainTable = new MenuTable(skin, stage, game, font);
        setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() * 0.90f);
        moeda = new Moeda(game, font1, 2);
        score = new Score(String.valueOf(GameInfo.mainScore), font1);
        this.add(moeda.getButton()).padRight(Gdx.graphics.getWidth() * 0.01f);
        this.add(score.getButton()).padRight(Gdx.graphics.getWidth() * 0.825f);
        stage.addActor(this);
    }
}
