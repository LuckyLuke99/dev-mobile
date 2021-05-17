package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.MapManager;

public class GameScreen implements Screen {
    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    MapManager mapManager; //Parte que vai gerando o mapa do jogo

    public GameScreen (final DevMobile game){
        this.game = game;

        //Configuração da camera e do viewport da tela
        mainCamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        gameViewport = new StretchViewport(GameInfo.WIDHT, GameInfo.HEIGHT, mainCamera);

        mapManager = new MapManager();

        System.out.println("Height :" + Gdx.graphics.getHeight() + "Wight: " + Gdx.graphics.getWidth());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainCamera.update();
        game.batch.setProjectionMatrix(mainCamera.combined);

        mainCamera.position.x += GameInfo.velCamera * GameInfo.deltaTime;

        GameInfo.deltaTime = Gdx.graphics.getDeltaTime();
        //Atualizando todas as classes
        mapManager.update(mainCamera);

        game.batch.begin();
        mapManager.draw(game.batch, mainCamera);
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
