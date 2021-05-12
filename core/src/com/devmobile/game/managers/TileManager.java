package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

public class TileManager {
    private TextureAtlas textureAtlas;
    private ObjectMap<String, TextureAtlas.AtlasRegion> tiles;

    public TileManager(){
        textureAtlas = new TextureAtlas(Gdx.files.internal("Terrenos_Teste.txt"));
        tiles = new ObjectMap<>();
    }
    public TextureAtlas.AtlasRegion getTexture(String string) {
        return textureAtlas.findRegion(string);
    }

// Exemplo do método para retornar a animação baseado na string passada
//    public Animation getAnimation(String string) {
//        if(string.equals("tile")) {
//            return animation01;
//        }
//        else if (string.equals("tilee")){
//            return animation02;
//        }
//        return null;
//    }

//    public int getSize(){
//        return tiles.size;
//    }

    public TextureAtlas getAtlas (){
        return textureAtlas;
    }
}
