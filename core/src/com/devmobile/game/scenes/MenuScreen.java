package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class MenuScreen implements Screen {

    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    Texture playButtonInactive;
    Texture playButtonPressed;
    Texture optionsButtonInactive;
    Texture optionsButtonPressed;

    public MenuScreen (DevMobile game){
        this.game = game;
        playButtonInactive = new Texture("Menu/red/play.png");
        playButtonPressed = new Texture("Menu/red/play_pressed.png");
        optionsButtonInactive = new Texture("Menu/red/options.png");
        optionsButtonPressed = new Texture("Menu/red/options_pressed.png");

        //Configuração da camera e do viewport da tela
        mainCamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        gameViewport = new StretchViewport(GameInfo.WIDHT, GameInfo.HEIGHT, mainCamera);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Parte da configuração da camera
        game.batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();

        game.batch.begin();

        float x = (GameInfo.WIDHT / 2 + 98);
        if(Gdx.input.getX() < x + playButtonInactive.getWidth() && Gdx.input.getX() > x &&  Gdx.input.getY() < (GameInfo.HEIGHT / 2) + playButtonInactive.getHeight() && Gdx.input.getY() > GameInfo.HEIGHT / 2){
            game.batch.draw(playButtonInactive, x, GameInfo.HEIGHT / 2, 147, 60);
        }else{
            game.batch.draw(playButtonPressed, x, GameInfo.HEIGHT / 2, 147, 60);
        }

        game.batch.draw(optionsButtonInactive, GameInfo.WIDHT / 2 + 98 ,100, 147, 60);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
