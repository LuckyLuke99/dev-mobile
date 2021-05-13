package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Terrains;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador

public class RandomTileManager {
    private TileManager tileManager;
    ObjectMap<String, Float> randomTile, terrainsFirstColumn;
    boolean firstGeneration;
    Terrains[] terrains;


    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();
        terrainsFirstColumn = new ObjectMap<>();;
        configTerrains();

        firstGeneration = true;
    }

    public GenericTile newTile(int currentX, int currentY){
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

    public TextureAtlas.AtlasRegion groundGeneration (int currentX, int currentY){
        TextureAtlas.AtlasRegion atlasRegion = null;

        //Executa caso seja a primeira vez criando os tiles
        if (firstGeneration){
            terrains = new Terrains[2];
            terrains[0] = new Terrains(currentX, currentY, 3, 2, 1);
            terrains[1] = new Terrains(currentX, currentY + GameInfo.sizeTexture * 3, 5, 3, 1);
            firstGeneration = false;
        }

       if(terrains[0].isOnBounds(currentX, currentY)){
           atlasRegion = terrainGenerator(terrains[0], currentX, currentY);
        }

       else {
            atlasRegion = highTerrainGenerator(terrains[1], currentX, currentY);
       }

        return atlasRegion;
    }

    //Método que cria a parte de cima do chão baseado no currentX, currentY e o currentBioma
    public TextureAtlas.AtlasRegion highTerrainGenerator (Terrains terrain, int currentX, int currentY){
        if((currentY == terrain.getY() && (currentX >= terrain.getX())))
        {
            if (currentX > terrain.getX()){
                if(!(currentX == terrain.getX2())){
                    return tileManager.getTexture(GameInfo.currentBiome + "10");
                }
                else {
                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxSpace)));
                    terrain.setX2(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxWight)));
                    terrain.setY((GameInfo.sizeTexture * MathUtils.random(GameInfo.highGroundMinPosition, GameInfo.highGroundMaxPosition)));
                    return tileManager.getTexture(GameInfo.currentBiome + "11");
                }
            }
            else {
                return tileManager.getTexture(GameInfo.currentBiome + "09");
            }
        }
        else {
            return null;
        }
    }

    //Método que cria a parte de baixo do chão baseado no currentX, currentY e o currentBioma
    public TextureAtlas.AtlasRegion terrainGenerator (Terrains terrain, int currentX, int currentY){
        if(currentY == terrain.getY2())
        {
            if (currentX > terrain.getX()){
                if(!(currentX == terrain.getX2())){
                    return tileManager.getTexture(GameInfo.currentBiome + "02");
                }
                else {
                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxSpace)));
                    terrain.setX2(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxWidght)));
                    terrain.setY2(GameInfo.sizeTexture * MathUtils.random(GameInfo.groundMinPosition, GameInfo.groundMaxPosition));
                    return tileManager.getTexture(GameInfo.currentBiome + "03");
                }
            }
            else if (currentX == terrain.getX()){
                return tileManager.getTexture(GameInfo.currentBiome + "01");
            }
            else {
                return null;
            }
        }
        else {
            if(currentY > terrain.getY2()){
                return null;
            }
            else {
                if(currentX > terrain.getX()){
                    if(!(currentX == terrain.getX2())){
                        return tileManager.getTexture(GameInfo.currentBiome + "05");
                    }
                    else {
                        return tileManager.getTexture(GameInfo.currentBiome + "06");
                    }
                }
                else if (currentX == terrain.getX()){
                    return tileManager.getTexture(GameInfo.currentBiome + "04");
                }
                else {
                    return null;
                }
            }
        }
    }

    //Configuração dos nomes dos terrenos é os pesos de cada um
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
