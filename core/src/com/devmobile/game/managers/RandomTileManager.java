package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador
public class RandomTileManager {
    private TileManager tileManager;
    ObjectMap<String, Float> randomTile;
    private String grasslandTerrain, autumnForestTerrain, tropicsTerrain, winterWorldTerrain;
    String currentBiome;
    boolean isGeneratingGround;
    //Gerando a parte de baixo do terreno
    int groundNumber;
    int groundHeight;


    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();
        currentBiome = "Grassland";
        configTerrains();

        groundNumber = 1;
        groundHeight = MathUtils.round(GameInfo.sizeTexture * 3);
    }

    public GenericTile newTile(float currentY){
//        if(groundHeight > currentY){
//            GenericTile genericTile = new GenericTile(randomTile());
//            return genericTile;
//        }
//        else {
            return new GenericTile(groundGeneration());
//        }
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


    private TextureAtlas.AtlasRegion groundGeneration (){
        //Se for o tile do meio do ground = 2
        //Começando pelo 2 porque a maioria vai ser o do meio
        if (groundNumber == 2){
            return tileManager.getTexture(GameInfo.autumnForestTerrain + "02");
        }
        //Se for o primeiro tile do ground = 1
        else if (groundNumber == 1){
            groundNumber = 2;
            return tileManager.getTexture(GameInfo.autumnForestTerrain + "01");
        }
        //Se for o ultimo tile do ground = 3
        else {
            groundNumber = 0;
            return tileManager.getTexture(GameInfo.autumnForestTerrain + "03");
        }
    }

    public void checkGroundHeight(){
    }

    public void setGeneratingGourd (boolean b){
        isGeneratingGround = b;
    }

    private void configTerrains(){
        //Grassland
        randomTile.put(GameInfo.grasslandTerrain + "01", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "02", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "03", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "04", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "05", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "06", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "07", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "08", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "09", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "10", 1f);
        randomTile.put(GameInfo.grasslandTerrain + "11", 1f);

        //Autumn Forest
        randomTile.put(GameInfo.autumnForestTerrain + "01", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "02", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "03", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "04", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "05", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "06", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "07", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "08", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "09", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "10", 1f);
        randomTile.put(GameInfo.autumnForestTerrain + "11", 1f);

        //Tropics
        randomTile.put(GameInfo.tropicsTerrain + "01", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "02", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "03", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "04", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "05", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "06", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "07", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "08", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "09", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "10", 1f);
        randomTile.put(GameInfo.tropicsTerrain + "11", 1f);

        //Winter World
        randomTile.put(GameInfo.winterWorldTerrain + "01", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "02", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "03", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "04", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "05", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "06", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "07", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "08", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "09", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "10", 1f);
        randomTile.put(GameInfo.winterWorldTerrain + "11", 1f);
    }
}
