package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.StatusLife;
import com.devmobile.game.objects.buttons.Exit;
import com.devmobile.game.objects.buttons.Life;
import com.devmobile.game.objects.buttons.Score;
import com.devmobile.game.objects.buttons.Timer;
import com.devmobile.game.objects.tables.GamePausedTable;
import com.devmobile.game.objects.tables.GameTable;
import com.devmobile.game.objects.tables.MenuTable;

public class ButtonsManager {
    final DevMobile game;
    private OrthographicCamera mainCamera;
    private Stage stage, stage2, stage3;
    private BitmapFont fonte, fonte2;
    private Skin skin;
    private Table mainTable, gameTable, gamePausedTable;
    private Score score, score02;
    private Timer timer, timer02;
    private StatusLife statusLife, statusLife02;


    public ButtonsManager (final DevMobile game){
        this.game = game;

        //Configuração da camera
        mainCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mainCamera.position.set(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 0f);
        mainCamera.update();

        //Não sei
        stage = new Stage();
        stage2 = new Stage();
        stage3 = new Stage();

        //Aparencia
        skin = GameInfo.tileManager.getMenu();

        //Cria a fonte
        fonte = GameInfo.criarFonte("FreePixel.ttf", Gdx.graphics.getWidth()/20);
        fonte.getData().setScale(1f);

        fonte2 = GameInfo.criarFonte("FreePixel.ttf", Gdx.graphics.getWidth()/20);
        fonte2.getData().setScale(0.5f);

        score = new Score(String.valueOf((int) GameInfo.mainScore), fonte2);
        score02 = new Score(String.valueOf((int) GameInfo.mainScore), fonte2);

        timer = new Timer(fonte2);
        timer02 = new Timer(fonte2);

        statusLife = new StatusLife();
        statusLife02 = new StatusLife();
        stage2.addActor(statusLife);
        stage3.addActor(statusLife02);

        mainTable = new MenuTable(skin, stage, game, fonte);
        gameTable = new GameTable(skin, stage2, game, fonte, fonte2, score, timer);
        gamePausedTable = new GamePausedTable(skin, stage3, game, fonte, fonte2, score02, timer02);

        game.multiplexer.addProcessor(stage);
        game.multiplexer.addProcessor(stage2);
        game.multiplexer.addProcessor(stage3);
    }

    public BitmapFont getFonte (){
        return fonte;
    }

    private void statusUpdate(){
        score.getButton().setText(String.valueOf((int) GameInfo.mainScore));
        score02.getButton().setText(String.valueOf((int) GameInfo.mainScore));
        timer.update();
        timer02.update();
    }

    public void draw(){
        statusUpdate();
        game.batch.setProjectionMatrix(mainCamera.combined);
        switch (GameInfo.currentScreen) {
            case MENU:
                stage.act(Gdx.graphics.getDeltaTime());
                stage.draw();
                break;
            case GAMERUNNING:
                stage2.act(Gdx.graphics.getDeltaTime());
                stage2.draw();
                break;
            case GAMEPAUSE:
                stage3.act(Gdx.graphics.getDeltaTime());
                stage3.draw();
        }
    }
}
