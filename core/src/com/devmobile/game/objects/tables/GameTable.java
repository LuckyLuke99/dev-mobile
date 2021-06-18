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

public class GameTable extends Table{
    private Pause buttonPause;
    private Moeda moeda;
    private Score score;

    public GameTable(Skin skin, Stage stage, final DevMobile game, BitmapFont font, BitmapFont font1){
        super(skin);
        debug();
        setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 110);
        buttonPause = new Pause(game, font, 4);
        moeda = new Moeda(game, font1, 2);
        score = new Score(String.valueOf(GameInfo.mainScore), font1);
        this.add(moeda.getButton());
        this.add(score.getButton()).padRight(1600);
        this.add(buttonPause.getButton());
        this.debug();
        stage.addActor(this);
    }


}
