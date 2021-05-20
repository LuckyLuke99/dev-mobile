package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Terrains;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador

public class RandomTileManager {
    final TileManager tileManager;
    boolean firstGeneration;
    Terrains[] terrains;

    public RandomTileManager (final TileManager tileManager){
        this.tileManager = tileManager;
        firstGeneration = true;
    }

    public GenericTile newTile(int currentX, int currentY){
       return new GenericTile(groundGeneration(currentX, currentY));
    }

    public TextureRegion groundGeneration (int currentX, int currentY){
        TextureRegion textureRegion = null;

        //Executa caso seja a primeira vez criando os tiles
        if (firstGeneration){
            terrains = new Terrains[2];
            terrains[0] = new Terrains(currentX, currentY, 100, 8);
            terrains[1] = new Terrains(currentX, currentY + GameInfo.sizeTexture * GameInfo.highGroundMaxPosition, 5, 3);
            firstGeneration = false;
        }

       if(terrains[0].isOnBounds(currentX, currentY)){
           textureRegion = terrainGenerator(terrains[0], currentX, currentY);
        }

       else {
            textureRegion = highTerrainGenerator(terrains[1], currentX, currentY);
       }

        return textureRegion;
    }

    //Método que cria a parte de cima do chão baseado no currentX, currentY e o currentBioma
    public TextureRegion highTerrainGenerator (Terrains terrain, int currentX, int currentY){
        if((currentY == terrain.getY() && (currentX >= terrain.getX())))
        {
            if (currentX > terrain.getX()){
                if(!(currentX == terrain.getX2())){
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_10");
                }
                else {
                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxSpace)));
                    terrain.setX2(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxWight)));
                    terrain.setY((GameInfo.sizeTexture * MathUtils.random(GameInfo.highGroundMinPosition, GameInfo.highGroundMaxPosition)));
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_11");
                }
            }
            else {
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_09");
            }
        }
        else {
            return null;
        }
    }

    //Método que cria a parte de baixo do chão baseado no currentX, currentY e o currentBioma
    public TextureRegion terrainGenerator (Terrains terrain, int currentX, int currentY){
        if(currentY == terrain.getY2())
        {
            if (currentX > terrain.getX()){
                if(!(currentX == terrain.getX2())){
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_02");
                }
                else {
                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxSpace)));
                    terrain.setX2(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxWidght)));
                    terrain.setY2(GameInfo.sizeTexture * MathUtils.random(GameInfo.groundMinPosition, GameInfo.groundMaxPosition));
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_03");
                }
            }
            else if (currentX == terrain.getX()){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_01");
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
                        return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_05");
                    }
                    else {
                        return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_06");
                    }
                }
                else if (currentX == terrain.getX()){
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_04");
                }
                else {
                    return null;
                }
            }
        }
    }
}
