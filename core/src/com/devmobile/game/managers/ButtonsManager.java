package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.buttons.Exit;
import com.devmobile.game.objects.tables.GameTable;
import com.devmobile.game.objects.tables.MenuTable;

public class ButtonsManager {
    final DevMobile game;
    private OrthographicCamera mainCamera;
    private Stage stage, stage2;
    private BitmapFont fonte, fonte2;
    private Skin skin;
    private Table mainTable, gameTable;

    public enum states{
        MENU,
        GAME
    }

    private states currentState;

    public ButtonsManager (final DevMobile game){
        this.game = game;

        //Configuração da camera
        mainCamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);

        //Não sei
        stage = new Stage();
        stage2 = new Stage();

        //Aparencia
        skin = GameInfo.tileManager.getMenu();

        //Cria a fonte
        fonte = GameInfo.criarFonte("FreePixel.ttf", Gdx.graphics.getWidth()/20);
        fonte.getData().setScale(1f);

        fonte2 = GameInfo.criarFonte("FreePixel.ttf", Gdx.graphics.getWidth()/20);
        fonte2.getData().setScale(0.5f);

        currentState = states.MENU;

        if (currentState == states.MENU){
            iniciarMenuUI();
            Gdx.input.setInputProcessor(stage);
        }else if(Exit.isPressed == true){
            currentState = states.GAME;
            iniciarGameUI();
            Gdx.input.setInputProcessor(stage2);
        }

//        InputMultiplexer im = new InputMultiplexer(stage, stage2);
//
//        Gdx.input.setInputProcessor(im);

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
        switch (currentState) {
            case MENU:
                stage.act(Gdx.graphics.getDeltaTime());
                stage.draw();
            case GAME:
                stage2.act(Gdx.graphics.getDeltaTime());
                stage2.draw();
        }

    }

    public void configCamera(){
        game.batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
    }
}
