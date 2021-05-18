package com.devmobile.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;

public class TileManager {
    private TextureAtlas textureAtlas;
    private TextureAtlas textureCharacters;
    private ObjectMap<String, TextureAtlas.AtlasRegion> tiles;
    private ObjectMap<String, Array<TextureAtlas.AtlasRegion>> characters;

    public TileManager(){
        textureAtlas = new TextureAtlas(Gdx.files.internal("TesteAtlas.atlas"));
        textureCharacters = new TextureAtlas(Gdx.files.internal("Characters.atlas"));

        tiles = new ObjectMap<>();
        characters = new ObjectMap<>();

        configCharacter();
        configTiles();
    }
    public TextureAtlas.AtlasRegion getTexture(String string) {
        return tiles.get(string);
    }

    public TextureAtlas getAtlas (){
        return textureAtlas;
    }

    public ObjectMap<String, Array<TextureAtlas.AtlasRegion>> getCharacters(){
        return characters;
    }

    public void dispose(){
        textureAtlas.dispose();
    }

    //Find all characters animations
    private void configCharacter(){
        //Holly Animations
        characters.put("Holly_attack", textureCharacters.findRegions("Holly_attack"));
        characters.put("Holly_falling", textureCharacters.findRegions("Holly_falling"));
        characters.put("Holly_run", textureCharacters.findRegions("Holly_run"));
        characters.put("Holly_hurt", textureCharacters.findRegions("Holly_hurt"));
        characters.put("Holly_jumping", textureCharacters.findRegions("Holly_jumping"));

        //Lil Animations
        characters.put("Lil_attack", textureCharacters.findRegions("Lil_attack"));
        characters.put("Lil_falling", textureCharacters.findRegions("Lil_falling"));
        characters.put("Lil_hurt", textureCharacters.findRegions("Lil_hurt"));
        characters.put("Lil_jumping", textureCharacters.findRegions("Lil_jumping"));
        characters.put("Lil_projectile", textureCharacters.findRegions("Lil_projectile"));
        characters.put("Lil_run", textureCharacters.findRegions("Lil_run"));

        //MrMan
        characters.put("MrMan_attack", textureCharacters.findRegions("MrMan_attack"));
        characters.put("MrMan_run", textureCharacters.findRegions("MrMan_run"));
        characters.put("MrMan_falling", textureCharacters.findRegions("MrMan_falling"));
        characters.put("MrMan_jumping", textureCharacters.findRegions("MrMan_jumping"));
        characters.put("MrMan_hurt", textureCharacters.findRegions("MrMan_hurt"));

        //MrMochi
        characters.put("MrMochi_jumping", textureCharacters.findRegions("MrMochi_jumping"));
        characters.put("MrMochi_run", textureCharacters.findRegions("MrMochi_run"));
        characters.put("MrMochi_hurt", textureCharacters.findRegions("MrMochi_hurt"));

        //Tommy
        characters.put("Tommy_jumping", textureCharacters.findRegions("Tommy_jumping"));
        characters.put("Tommy_run", textureCharacters.findRegions("Tommy_run"));
        characters.put("Tommy_falling", textureCharacters.findRegions("Tommy_falling"));
        characters.put("Tommy_hurt", textureCharacters.findRegions("Tommy_hurt"));

        //Twiggy
        characters.put("Twiggy_jumping", textureCharacters.findRegions("Twiggy_jumping"));
        characters.put("Twiggy_run", textureCharacters.findRegions("Twiggy_run"));
        characters.put("Twiggy_falling", textureCharacters.findRegions("Twiggy_falling"));
    }

    //Find all tiles
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
