package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;

public class TileManager {
    private TextureAtlas textureAtlas;
    private ObjectMap<String, TextureAtlas.AtlasRegion> tiles;

    public TileManager(){
        textureAtlas = new TextureAtlas(Gdx.files.internal("sprites.txt"));
        tiles = new ObjectMap<>();

        //Adicionando tiles
        tiles.put("floor", textureAtlas.findRegion("tile014"));
        tiles.put("one", textureAtlas.findRegion("tile096"));
        tiles.put("two", textureAtlas.findRegion("tile097"));
        tiles.put("three", textureAtlas.findRegion("tile098"));
        tiles.put("four", textureAtlas.findRegion("tile099"));
    }
    public TextureAtlas.AtlasRegion getTexture(String string) {
        return tiles.get(string);
    }

    public int getSize(){
        return tiles.size;
    }
}
