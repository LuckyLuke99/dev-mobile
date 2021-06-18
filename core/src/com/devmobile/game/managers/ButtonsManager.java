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
import com.devmobile.game.objects.buttons.Exit;
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


        mainTable = new MenuTable(skin, stage, game, fonte);
        gameTable = new GameTable(skin, stage2, game, fonte, fonte2);
        gamePausedTable = new GamePausedTable(skin, stage3, game, fonte, fonte2);

        game.multiplexer.addProcessor(stage);
        game.multiplexer.addProcessor(stage2);
        game.multiplexer.addProcessor(stage3);
    }

    public void iniciarMenuUI(){
        mainTable = new MenuTable(skin, stage, game, fonte);
    }

    public void iniciarGameUI(){
        gameTable = new GameTable(skin, stage2, game, fonte, fonte2);
    }

    public void addButton(TextButton button){
        mainTable.add(button);
        mainTable.row();
    }

    public BitmapFont getFonte (){
        return fonte;
    }

    public void resetButton(){
        mainTable.clear();
    }

    public void draw(){
        game.batch.setProjectionMatrix(mainCamera.combined);
        switch (GameInfo.currentScreen) {
            case MENU:
                System.out.println("Stage 1");
                stage.act(Gdx.graphics.getDeltaTime());
                stage.draw();
                break;
            case GAMERUNNING:
                System.out.println("Stage 2");
                stage2.act(Gdx.graphics.getDeltaTime());
                stage2.draw();
                break;
            case GAMEPAUSE:
                System.out.println("Stage ");
                stage3.act(Gdx.graphics.getDeltaTime());
                stage3.draw();
        }

    }
}
