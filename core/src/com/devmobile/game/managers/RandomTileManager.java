package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.GenericCharacter;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Terrains;

import java.util.Iterator;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador

public class RandomTileManager {
    final TileManager tileManager;
    boolean firstGeneration;
    Array<Terrains> terrains;

    int nextDownGround, nextTopGroundX, nextTopGroundY;

    public RandomTileManager (final TileManager tileManager){
        this.tileManager = tileManager;
        terrains = new Array<>();
        firstGeneration = true;
        nextDownGround = 0;
        nextTopGroundX = 0;
        nextTopGroundY = 0;
    }

    public GenericTile newTile(int currentX, int currentY){
       return new GenericTile(groundGeneration(currentX, currentY));
    }

    public void checkColisitionGrounds(GenericCharacter genericCharacter){
        for (Terrains terrain : terrains){
            if(genericCharacter.overlaps(terrain)){
                genericCharacter.setY(terrain.getY() + terrain.getHeight());
            }
        }
    }

    public TextureRegion groundGeneration (int currentX, int currentY){
        TextureRegion textureRegion = null;
        //Executa caso seja a primeira vez criando os tiles
        if(firstGeneration){
            int wight = 30;
            int hight = GameInfo.downGroundMaxHeight;
            int space = 3;

            terrains.add(new Terrains(0, 0, wight, hight));
            nextDownGround += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
            firstGeneration = false;
        }

        if(currentX == nextDownGround){
            nextDownGround();
            if(GameInfo.downGroundMaxHeight >= currentY / GameInfo.sizeTexture){
            }
        }
        textureRegion = downTileGeneration(currentX, currentY);
        return textureRegion;
    }


//    private TextureRegion topGeneration(int currentX, int currentY){
//
//        if(currentX == nextTopGroundX){
////            if(GameInfo.topGroundMinPosition <= currentY / GameInfo.sizeTexture && GameInfo.topGroundMaxPosition >= currentY / GameInfo.sizeTexture){
//                nextTopGround();
//                return topGroundGeneration(currentX, currentY);
////            }
//        }
//    }

    private void nextTopGround(){
        int nextY, wight, space;
        nextY = MathUtils.random(GameInfo.topGroundMinPosition, GameInfo.topGroundMaxPosition);
        wight = MathUtils.random(3, GameInfo.topGroundMaxWight);
        space = MathUtils.random(1, GameInfo.topGroundMaxSpace);

        terrains.add(new Terrains(
                nextTopGroundX,
                nextY,
                wight,
                1
        ));
        nextTopGroundX += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
    }

    private void nextDownGround(){
        int hight, wight, space;
        hight = MathUtils.random(GameInfo.downGroundMinHeight, GameInfo.downGroundMaxHeight);
        wight = MathUtils.random(3, GameInfo.downGroundMaxWight);
        space = MathUtils.random(GameInfo.downGroundMinSpace, GameInfo.downGroundMaxSpace);

        terrains.add(new Terrains(
                nextDownGround,
                0,
                wight,
                hight
        ));
        nextDownGround += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
    }

    //Gerar região de baixo
    public TextureRegion downTileGeneration(int currentX, int currentY){
        for(Terrains terrain : terrains){
            if(terrain.isCenter(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_05");
            }
            else if(terrain.isFirstColumn(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_04");
            }
            else if(terrain.isLastColumn(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_06");
            }
            else if(terrain.isUpColumn(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_02");
            }
            else if(terrain.isCornerLeft(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_01");
            }
            else if(terrain.isCornerRight(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_03");
            }
        }
        return null;
    }

    public TextureRegion topGroundGeneration(int currentX, int currentY){
        for(Terrains terrain : terrains){
            if(terrain.isCenter(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_10");
            }
            else if(terrain.isCornerLeft(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_09");
            }
            else if(terrain.isCornerRight(currentX, currentY)){
                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_11");
            }
        }
        return  null;
    }

    //Gerar região de cima
        //Checar se está na região de cima
            //Chegar em qual parte do terreno está


//    //Método que cria a parte de cima do chão baseado no currentX, currentY e o currentBioma
//    public TextureRegion highTerrainGenerator (Terrains terrain, int currentX, int currentY){
//        if((currentY == terrain.getY() && (currentX >= terrain.getX())))
//        {
//            if (currentX > terrain.getX()){
//                if(!(currentX == terrain.getWidth())){
//                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_10");
//                }
//                else {
//                    //Adicionar outro terreno em vez de tirar
//                    terrains.add(new Terrains(
//                            currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxSpace)),
//                            GameInfo.sizeTexture * MathUtils.random(GameInfo.highGroundMinPosition, GameInfo.highGroundMaxPosition),
//                            Math.round(terrain.getX()) + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxWight)),
//                            1
//                    ));
////                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxSpace)));
////                    terrain.setX2(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.highGroundMaxWight)));
////                    terrain.setY((GameInfo.sizeTexture * MathUtils.random(GameInfo.highGroundMinPosition, GameInfo.highGroundMaxPosition)));
//                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_11");
//                }
//            }
//            else {
//                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_09");
//            }
//        }
//        else {
//            return null;
//        }
//    }
//
//    //Método que cria a parte de baixo do chão baseado no currentX, currentY e o currentBioma
//    public TextureRegion terrainGenerator (Terrains terrain, int currentX, int currentY){
//        if(currentY == terrain.getHeight())
//        {
//            if (currentX > terrain.getX()){
//                if(!(currentX == terrain.getWidth())){
//                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_02");
//                }
//                else {
//                    terrains.add(new Terrains(
//                            currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxSpace)),
//                            0,
//                            Math.round(terrain.getX()) + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxWidght)),
//                            GameInfo.sizeTexture * MathUtils.random(GameInfo.groundMinPosition, GameInfo.groundMaxPosition)
//                    ));
////                    terrain.setX(currentX + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxSpace)));
////                    terrain.setWidth(terrain.getX() + (GameInfo.sizeTexture * MathUtils.random(3, GameInfo.groundMaxWidght)));
////                    terrain.setHeight(GameInfo.sizeTexture * MathUtils.random(GameInfo.groundMinPosition, GameInfo.groundMaxPosition));
//                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_03");
//                }
//            }
//            else if (currentX == terrain.getX()){
//                return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_01");
//            }
//            else {
//                return null;
//            }
//        }
//        else {
//            if(currentY > terrain.getHeight()){
//                return null;
//            }
//            else {
//                if(currentX > terrain.getX()){
//                    if(!(currentX == terrain.getWidth())){
//                        return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_05");
//                    }
//                    else {
//                        return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_06");
//                    }
//                }
//                else if (currentX == terrain.getX()){
//                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_04");
//                }
//                else {
//                    return null;
//                }
//            }
//        }
//    }
}
