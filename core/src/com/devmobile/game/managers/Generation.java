package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Generation {
    int[][] map;
    Texture img;

    public Generation (){
        map = new int[64][64];
        img = new Texture(Gdx.files.internal("tileText10x10.png"));

    }

    private void startMap(){
        for (int i = 0; i < map.length; i++) {
            for (int x = 0; x <map.length ; x++) {
                map[i][x] = 0;
            }
        }
    }
}
