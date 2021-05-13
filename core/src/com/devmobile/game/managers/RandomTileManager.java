package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador
public class RandomTileManager {
    private TileManager tileManager;
    ObjectMap<String, Float> randomTile, terrainsFirstColumn;
    private String grasslandTerrain, autumnForestTerrain, tropicsTerrain, winterWorldTerrain;
    String currentBiome;
    boolean isGeneratingGround;
    //Gerando a parte de baixo do terreno
    int groundNumber;
    int groundHeight;
    int firstColumn;
    int lastColumn;


    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();
        terrainsFirstColumn = new ObjectMap<>();
        currentBiome = "Grassland";
        configTerrains();

        groundNumber = 0;
    }

    public GenericTile newTile(float currentX, float currentY){
       return new GenericTile(groundGeneration(currentX, currentY));
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
        return tileManager.getTexture(tileName);
    }


    public TextureAtlas.AtlasRegion groundGeneration (float currentX, float currentY){
        // Se for o primeiro tile do chão pega a primeira coluna e decidi qual vai ser a altura do chão
        if (groundNumber == 0){
            firstColumn = MathUtils.round(currentX);
            lastColumn = firstColumn + (GameInfo.sizeTexture * 70);
            groundHeight = MathUtils.round(GameInfo.sizeTexture * 3);
            groundNumber = 1;
        }
        else if(currentX == lastColumn){
            groundNumber = 3;
        }

        //Se for a altura do chão passa as texturas da parte de cima
        if(currentY == groundHeight)
        {
            if (currentX > firstColumn){
                if(!(currentX == lastColumn)){
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "02");
                }
                else {
                    firstColumn = MathUtils.round(currentX) + (GameInfo.sizeTexture * MathUtils.random(5, 10));
                    lastColumn = firstColumn + (GameInfo.sizeTexture * MathUtils.random(3, 30));
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "03");
                }
            }
            else if (currentX == firstColumn){
                return tileManager.getTexture(GameInfo.autumnForestTerrain + "01");
            }
            else {
                return null;
            }
        }
        else {
            if(currentY > groundHeight){
                return null;
            }
            else {
                if(currentX > firstColumn){
                    if(!(currentX == lastColumn)){
                        return tileManager.getTexture(GameInfo.autumnForestTerrain + "05");
                    }
                    else {
                        return tileManager.getTexture(GameInfo.autumnForestTerrain + "06");
                    }
                }
                else if (currentX == firstColumn){
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "04");
                }
                else {
                    return null;
                }
            }
        }
    }

    public void checkGroundHeight(){
    }

    public void setGeneratingGourd (boolean b){
        isGeneratingGround = b;
    }

    private void configTerrains(){
        terrainsFirstColumn.put(GameInfo.autumnForestTerrain + "01", 1f);
        terrainsFirstColumn.put(GameInfo.autumnForestTerrain + "04", 1f);

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
