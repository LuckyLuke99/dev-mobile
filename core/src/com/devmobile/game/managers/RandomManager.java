package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.tiles.GenericTile;

public class RandomManager {
    private TileManager tileManager;
    private ObjectMap<Integer, String> randomTile;
    private int randNumber;

    public RandomManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();

        randomTile.put(0, "tile");
        randomTile.put(1, "tilee");
    }

    public GenericTile newTile(){
        GenericTile genericTile = new GenericTile(randomTile());
        return genericTile;
    }

    private Animation randomTile(){
        randNumber = MathUtils.random(0, randomTile.size - 1);
        return tileManager.getAnimation(randomTile.get(randNumber));
    }
}
