package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Mountain;
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
    int nextHeight;

    Mountain[] mountains;


    public RandomTileManager (){
        tileManager = new TileManager();
        randomTile = new ObjectMap<>();
        terrainsFirstColumn = new ObjectMap<>();
        currentBiome = "Grassland";
        configTerrains();

        groundNumber = 0;
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


    class groundArea {
        // altura, largura (primeira columna e última)
    }


    public TextureAtlas.AtlasRegion groundGeneration (int currentX, int currentY){
        TextureAtlas.AtlasRegion atlasRegion = null;
        // Se for o primeiro tile do chão pega a primeira coluna e decidi qual vai ser a altura do chão
        if (groundNumber == 0){
            mountains = new Mountain[3];
            mountains[0] = new Mountain(currentX, currentY, 2, 2, 1);
            mountains[1] = new Mountain(currentX, currentY, 4, 4, 2);
            mountains[2] = new Mountain(currentX, currentY, 8, 8, 4);


//            firstColumn = mountain.getX();
//            lastColumn = mountain.getX2();
//            groundHeight = mountain.getY2();
            groundNumber = 1;
        }
        //Se for a altura do chão passa as texturas da parte de cima
//        for (Mountain mountain : mountains){
//            if(mountain.isOnBounds(currentX, currentY)){
//                atlasRegion = mountainGenerator(mountain, currentX, currentY);
//            }
//        }
        if(mountains[0].isOnBounds(currentX, currentY)){
            atlasRegion = mountainGenerator(mountains[0], currentX, currentY);
        }
        else if(mountains[1].isOnBounds(currentX, currentY)){
            atlasRegion = mountainGenerator(mountains[1], currentX, currentY);
        }
        else if(mountains[2].isOnBounds(currentX, currentY)){
            atlasRegion = mountainGenerator(mountains[2], currentX, currentY);
        }
//        else if(mountains[0].getY2() > currentY){
//            atlasRegion = mountainGenerator(mountains[1], currentX, currentY);
//        }
        return atlasRegion;
    }

    public void checkGroundHeight(){
    }

    public TextureAtlas.AtlasRegion mountainGenerator (Mountain mountain, int currentX, int currentY){
        if(currentY == mountain.getY2())
        {
            if (currentX > mountain.getX()){
                if(!(currentX == mountain.getX2())){
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "02");
                }
                else {
                    nextHeight = 0;
                    mountain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, 6)));
                    mountain.setX2(mountain.getX() + (mountain.getType() * (GameInfo.sizeTexture * MathUtils.random(3, 30))));
                    mountain.setY2(mountain.getType() * (GameInfo.sizeTexture * MathUtils.random(1, 4)));
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "03");
                }
            }
            else if (currentX == mountain.getX()){
                return tileManager.getTexture(GameInfo.autumnForestTerrain + "01");
            }
            else {
                return null;
            }
        }
        else {
            if(currentY > mountain.getY2()){
                return null;
            }
            else {
                if(currentX > mountain.getX()){
                    if(!(currentX == mountain.getX2())){
                        return tileManager.getTexture(GameInfo.autumnForestTerrain + "05");
                    }
                    else {
                        return tileManager.getTexture(GameInfo.autumnForestTerrain + "06");
                    }
                }
                else if (currentX == mountain.getX()){
                    return tileManager.getTexture(GameInfo.autumnForestTerrain + "04");
                }
                else {
                    return null;
                }
            }
        }
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
