package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.tiles.GenericTile;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador
public class RandomTileManager {
    private TileManager tileManager;
    private ObjectMap<Integer, String> randomTile;
    private int randNumber;

    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();

        ;
        randomTile.put(0, "tile");
        randomTile.put(1, "tilee");
    }

    public GenericTile newTile(){
        GenericTile genericTile = new GenericTile(randomTile());
        return genericTile;
    }

    private Animation randomTile(){
        randNumber = MathUtils.random(0, randomTile.size - 1);
        return tileManager.getTexture(randomTile.get(randNumber));
    }
}
