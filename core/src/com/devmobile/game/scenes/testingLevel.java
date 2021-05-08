package com.devmobile.game.scenes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class testingLevel implements Screen {
    final DevMobile game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    TextureAtlas textureAtlas;
    Sprite tile032;
    int[] mapX;
    int[] mapY;

    float tileX;
    float tileY;
    float pointX;
    float pointY;

    public testingLevel (final DevMobile game){
        this.game = game;

        //Configuração da câmera
        mainCamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        gameViewport = new StretchViewport(GameInfo.WIDHT, GameInfo.HEIGHT, mainCamera);

        //Testando spite sheet
        textureAtlas = new TextureAtlas("sprites.txt");
        tile032 = textureAtlas.createSprite("tile032");

        //Tentando criar o mapa
        tileX = 1f/GameInfo.tileSizeX;
        tileY = 1f/GameInfo.tileSizeY;

        //map = new int[GameInfo.tileSizeX][GameInfo.tileSizeY];
    }

    public void drawMap(Batch batch){
        for (int x = 0; x < GameInfo.tileSizeX; x++) {
            for (int y = 0; y < GameInfo.tileSizeY ; y++) {
                //batch.draw(tile032, map[x][y].x, map[x][y].y);
            }
        }
    }

    public void movePoint(){

        float x;
        float y;
    }

    public float getMapX(int X){
        float tileX = 1f / GameInfo.tileSizeX;
        tileX *= X;
        return tileX;
    }

    public float getMapXY(int Y){
        float tileY = 1f / GameInfo.tileSizeY;
        tileY *= Y;
        return tileY;
    }

    public void startMap(){
        for (int x = 0; x <= GameInfo.tileSizeX; x++) {
            for (int y = 0; y <= GameInfo.tileSizeY; y++) {
                //mapX[x][y] = x;
                //mapY[x][y] = y;

                //0,0
                //0,1
                //0,2
                //0,3
                //...
                //63,63
            }
        }
    }

    @Override
    public void render(float delta) {
        game.batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        tile032.draw(game.batch);
        drawMap(game.batch);
        game.batch.end();

    }

    @Override
    public void show() {

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
        textureAtlas.dispose();
    }
}
