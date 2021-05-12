package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.tiles.GenericTile;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador
public class RandomTileManager {
    private TileManager tileManager;
    private ObjectMap<String, Float> randomTile;
    private int randNumber;
    String grasslandTerrain, grasslandTerrainName;

    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();

        //Grassland
        grasslandTerrain = "Grassland/Terrain/";
        grasslandTerrainName = "Grassland_Terrain_";

        randomTile.put(grasslandTerrainName + "01", 1f);
        randomTile.put(grasslandTerrainName + "02", 1f);
        randomTile.put(grasslandTerrainName + "03", 1f);
        randomTile.put(grasslandTerrainName + "04", 1f);
        randomTile.put(grasslandTerrainName + "05", 1f);
        randomTile.put(grasslandTerrainName + "06", 1f);
        randomTile.put(grasslandTerrainName + "07", 1f);
        randomTile.put(grasslandTerrainName + "08", 1f);
        randomTile.put(grasslandTerrainName + "09", 1f);
        randomTile.put(grasslandTerrainName + "10", 1f);
        randomTile.put(grasslandTerrainName + "11", 1f);
    }

    public GenericTile newTile(){
        GenericTile genericTile = new GenericTile(randomTile());
        return genericTile;
    }

    private TextureAtlas.AtlasRegion randomTile(){
        float num = 0f;
        String tileName = "";

        for (String key: randomTile.keys()){
            float randomNum = MathUtils.random(0f, 1f);
            randomNum *= randomTile.get(key);
            if(randomNum > num){
                num = randomNum;
                tileName = key;
            }
        }
        System.out.println(tileName);
        return tileManager.getTexture(tileName);
    }
}
