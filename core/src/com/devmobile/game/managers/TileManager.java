package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;

public class TileManager {
    private TextureAtlas textureAtlas;
    private ObjectMap<String, TextureAtlas.AtlasRegion> tiles;

    public TileManager(){
        textureAtlas = new TextureAtlas(Gdx.files.internal("TesteAtlas.atlas"));
        tiles = new ObjectMap<>();
        configTiles();
    }
    public TextureAtlas.AtlasRegion getTexture(String string) {
        return tiles.get(string);
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

    public void dispose(){
        textureAtlas.dispose();
    }

    private void configTiles(){
        //Grassland BG
        tiles.put(GameInfo.grasslandBG + "01", textureAtlas.findRegion(GameInfo.grasslandBG + "01"));
        tiles.put(GameInfo.grasslandBG + "02", textureAtlas.findRegion(GameInfo.grasslandBG + "02"));
        tiles.put(GameInfo.grasslandBG + "03", textureAtlas.findRegion(GameInfo.grasslandBG + "03"));
        tiles.put(GameInfo.grasslandBG + "04", textureAtlas.findRegion(GameInfo.grasslandBG + "04"));

        //Autumn Forest BG
        tiles.put(GameInfo.autumnForestBG + "01", textureAtlas.findRegion(GameInfo.autumnForestBG + "01"));
        tiles.put(GameInfo.autumnForestBG + "02", textureAtlas.findRegion(GameInfo.autumnForestBG + "02"));
        tiles.put(GameInfo.autumnForestBG + "03", textureAtlas.findRegion(GameInfo.autumnForestBG + "03"));
        tiles.put(GameInfo.autumnForestBG + "04", textureAtlas.findRegion(GameInfo.autumnForestBG + "04"));

        //Tropics BG
        tiles.put(GameInfo.tropicsBG + "01", textureAtlas.findRegion(GameInfo.tropicsBG + "01"));
        tiles.put(GameInfo.tropicsBG + "02", textureAtlas.findRegion(GameInfo.tropicsBG + "02"));
        tiles.put(GameInfo.tropicsBG + "03", textureAtlas.findRegion(GameInfo.tropicsBG + "03"));
        tiles.put(GameInfo.tropicsBG + "04", textureAtlas.findRegion(GameInfo.tropicsBG + "04"));

        //Winter World BG
        tiles.put(GameInfo.winterWorldBG + "01", textureAtlas.findRegion(GameInfo.winterWorldBG + "01"));
        tiles.put(GameInfo.winterWorldBG + "02", textureAtlas.findRegion(GameInfo.winterWorldBG + "02"));
        tiles.put(GameInfo.winterWorldBG + "03", textureAtlas.findRegion(GameInfo.winterWorldBG + "03"));
        tiles.put(GameInfo.winterWorldBG + "04", textureAtlas.findRegion(GameInfo.winterWorldBG + "04"));

        //Grassland terrain
        tiles.put("Grassland_Terrain_01", textureAtlas.findRegion("Grassland_Terrain_01"));
        tiles.put("Grassland_Terrain_02", textureAtlas.findRegion("Grassland_Terrain_02"));
        tiles.put("Grassland_Terrain_03", textureAtlas.findRegion("Grassland_Terrain_03"));
        tiles.put("Grassland_Terrain_04", textureAtlas.findRegion("Grassland_Terrain_04"));
        tiles.put("Grassland_Terrain_05", textureAtlas.findRegion("Grassland_Terrain_05"));
        tiles.put("Grassland_Terrain_06", textureAtlas.findRegion("Grassland_Terrain_06"));
        tiles.put("Grassland_Terrain_07", textureAtlas.findRegion("Grassland_Terrain_07"));
        tiles.put("Grassland_Terrain_08", textureAtlas.findRegion("Grassland_Terrain_08"));
        tiles.put("Grassland_Terrain_09", textureAtlas.findRegion("Grassland_Terrain_09"));
        tiles.put("Grassland_Terrain_10", textureAtlas.findRegion("Grassland_Terrain_10"));
        tiles.put("Grassland_Terrain_11", textureAtlas.findRegion("Grassland_Terrain_11"));

        //Autumn Forest
        tiles.put("AutumnForest_Terrain_01", textureAtlas.findRegion("AutumnForest_Terrain_01"));
        tiles.put("AutumnForest_Terrain_02", textureAtlas.findRegion("AutumnForest_Terrain_02"));
        tiles.put("AutumnForest_Terrain_03", textureAtlas.findRegion("AutumnForest_Terrain_03"));
        tiles.put("AutumnForest_Terrain_04", textureAtlas.findRegion("AutumnForest_Terrain_04"));
        tiles.put("AutumnForest_Terrain_05", textureAtlas.findRegion("AutumnForest_Terrain_05"));
        tiles.put("AutumnForest_Terrain_06", textureAtlas.findRegion("AutumnForest_Terrain_06"));
        tiles.put("AutumnForest_Terrain_07", textureAtlas.findRegion("AutumnForest_Terrain_07"));
        tiles.put("AutumnForest_Terrain_08", textureAtlas.findRegion("AutumnForest_Terrain_08"));
        tiles.put("AutumnForest_Terrain_09", textureAtlas.findRegion("AutumnForest_Terrain_09"));
        tiles.put("AutumnForest_Terrain_10", textureAtlas.findRegion("AutumnForest_Terrain_10"));
        tiles.put("AutumnForest_Terrain_11", textureAtlas.findRegion("AutumnForest_Terrain_11"));

        //Tropics
        tiles.put("Tropics_Terrain_01", textureAtlas.findRegion("Tropics_Terrain_01"));
        tiles.put("Tropics_Terrain_02", textureAtlas.findRegion("Tropics_Terrain_02"));
        tiles.put("Tropics_Terrain_03", textureAtlas.findRegion("Tropics_Terrain_03"));
        tiles.put("Tropics_Terrain_04", textureAtlas.findRegion("Tropics_Terrain_04"));
        tiles.put("Tropics_Terrain_05", textureAtlas.findRegion("Tropics_Terrain_05"));
        tiles.put("Tropics_Terrain_06", textureAtlas.findRegion("Tropics_Terrain_06"));
        tiles.put("Tropics_Terrain_07", textureAtlas.findRegion("Tropics_Terrain_07"));
        tiles.put("Tropics_Terrain_08", textureAtlas.findRegion("Tropics_Terrain_08"));
        tiles.put("Tropics_Terrain_09", textureAtlas.findRegion("Tropics_Terrain_09"));
        tiles.put("Tropics_Terrain_10", textureAtlas.findRegion("Tropics_Terrain_10"));
        tiles.put("Tropics_Terrain_11", textureAtlas.findRegion("Tropics_Terrain_11"));

        //Winter World
        tiles.put("WinterWorld_Terrain_01", textureAtlas.findRegion("WinterWorld_Terrain_01"));
        tiles.put("WinterWorld_Terrain_02", textureAtlas.findRegion("WinterWorld_Terrain_02"));
        tiles.put("WinterWorld_Terrain_03", textureAtlas.findRegion("WinterWorld_Terrain_03"));
        tiles.put("WinterWorld_Terrain_04", textureAtlas.findRegion("WinterWorld_Terrain_04"));
        tiles.put("WinterWorld_Terrain_05", textureAtlas.findRegion("WinterWorld_Terrain_05"));
        tiles.put("WinterWorld_Terrain_06", textureAtlas.findRegion("WinterWorld_Terrain_06"));
        tiles.put("WinterWorld_Terrain_07", textureAtlas.findRegion("WinterWorld_Terrain_07"));
        tiles.put("WinterWorld_Terrain_08", textureAtlas.findRegion("WinterWorld_Terrain_08"));
        tiles.put("WinterWorld_Terrain_09", textureAtlas.findRegion("WinterWorld_Terrain_09"));
        tiles.put("WinterWorld_Terrain_10", textureAtlas.findRegion("WinterWorld_Terrain_10"));
        tiles.put("WinterWorld_Terrain_11", textureAtlas.findRegion("WinterWorld_Terrain_11"));
    }
}
