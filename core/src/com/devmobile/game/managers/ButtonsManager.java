package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class ButtonsManager {
    final DevMobile game;
    private OrthographicCamera mainCamera;
    private Stage stage;
    private BitmapFont fonte;
    private Skin skin;
    private Table mainTable;

    public ButtonsManager (final DevMobile game){
        this.game = game;

        //Configuração da camera e do viewport da tela
        mainCamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);

        //Não sei
        stage = new Stage();

        //Aparencia
        skin = GameInfo.tileManager.getMenu();

        //Cria a fonte
        fonte = GameInfo.criarFonte("FreePixel.ttf", Gdx.graphics.getWidth()/20);
        fonte.getData().setScale(1f);

        //Guarda os buttons
        mainTable = new Table(skin);
        mainTable.setBounds(0, 0, Gdx.graphics.getWidth()*1.50f, Gdx.graphics.getHeight());
    }

    public void addButton(TextButton button){
        mainTable.add(button);
    }

    public void resetButton(){
        mainTable.clear();
    }

    public void draw(){
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}
