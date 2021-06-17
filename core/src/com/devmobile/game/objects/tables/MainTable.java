package com.devmobile.game.objects.tables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.devmobile.game.DevMobile;
import com.devmobile.game.objects.buttons.Exit;
import com.devmobile.game.objects.buttons.Play;

public class MainTable extends Table{
    private Play buttonPlay;
    private Exit buttonExit;

    public MainTable(Skin skin, Stage stage, final DevMobile game, BitmapFont font){
        super(skin);
        setBounds(0, 0, Gdx.graphics.getWidth()*1.50f, Gdx.graphics.getHeight());
        debug();
        buttonPlay = new Play(game, font, 6);
        buttonExit = new Exit(game, font, 6);
        this.add(buttonPlay.getButton());
        this.row();
        this.add(buttonExit.getButton());
        stage.addActor(this);
    }

}
