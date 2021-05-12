package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;

public class MapManager {
    TileManager tileManager;
    RandomManager random;
    GenericTile[][] tiles;

    int sizeX, sizeY;
    float currentX, currentY;

    public MapManager(){
        //Tamanho do mapa
        sizeX = Math.round((GameInfo.WIDHT / GameInfo.sizeTexture)*2);
        sizeY = Math.round((GameInfo.HEIGHT / GameInfo.sizeTexture)*2);
        currentX = 0;
        currentY = 0;

        random = new RandomManager();
        //Inciando o tileMap
        tileManager = new TileManager();

        //Criando o mapa
        tiles = new GenericTile[sizeX][sizeY];
        startMap();
    }

    public void startMap(){
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                tiles[x][y] = random.newTile();
                tiles[x][y].setPosition(currentX, currentY);
                currentY += GameInfo.sizeTexture;
            }
            currentX += GameInfo.sizeTexture;
            currentY = 0;
        }
    }

    public void update(OrthographicCamera camera){
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if(isOutBound(camera, tiles[x][y])){
                    currentX += GameInfo.sizeTexture;
                    for (int i = 0; i < sizeY; i++) {
                        tiles[x][i].setX(currentX);
                    }
                }
            }
        }
    }

    public void draw(SpriteBatch batch, OrthographicCamera camera){
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                tiles[x][y].draw(batch);
            }
        }
    }

    public boolean isOutBound(OrthographicCamera camera, GenericTile tile){
        float cameraX = camera.position.x - (GameInfo.WIDHT * 0.6f);
        if(tile.x < cameraX){
            return true;
        }
        return false;
    }
}
