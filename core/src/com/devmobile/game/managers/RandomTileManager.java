package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.GenericTile;
import com.devmobile.game.objects.Terrains;
import com.devmobile.game.objects.items.CoinLarger;
import com.devmobile.game.objects.items.CoinMedium;
import com.devmobile.game.objects.items.CoinSmall;
import com.devmobile.game.objects.items.GenericItem;

//Classe retorna qual vai ser o próximo tile gerado baseado na posição atual do gerador

public class RandomTileManager {
    final TileManager tileManager; // Parte que retorna as texturas do atlas
    boolean firstGeneration;

    Array<Terrains> downTerrains;
    Array<Terrains> topTerrains;

    int nextDownGround, nextTopGround;

    public RandomTileManager (final TileManager tileManager){
        this.tileManager = tileManager;
        downTerrains = new Array<>();
        topTerrains = new Array<>();
        firstGeneration = true;
        nextDownGround = 0;
    }

    public void reset(){
        for (Terrains terrain : downTerrains){
            terrain.destroyBody();
        }
        for (Terrains terrain : topTerrains){
            terrain.destroyBody();
        }
        downTerrains = new Array<>();
        topTerrains = new Array<>();
        firstGeneration = true;
        nextDownGround = 0;
        nextTopGround = 0;
    }

    //Cria um GenericTile para passar depois as texturas
    public GenericTile newTile(int currentX, int currentY){
       return new GenericTile(groundGeneration(currentX, currentY));
    }

    //Gera as áreas dos terrenos e retorna os tiles deles
    public TextureRegion groundGeneration (int currentX, int currentY){
        //Caso seja a primeira geração cria um terreno maior e muda a próxima posição do nextTopGround
        if(firstGeneration){
            int wight = 70;
            int hight = GameInfo.downGroundMaxHeight;
            int space = 3;

            downTerrains.add(new Terrains(0, 0, wight, hight));
            nextDownGround += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
            nextTopGround += nextDownGround;
            firstGeneration = false;
        }

        //Checa se é pra gerar o próximo downTerrains
        if(currentX == nextDownGround)
            nextDownGround();

        //Checa se é pra gerar o próximo topTerrains
        if(currentX == nextTopGround)
            nextTopGround();

        //Returna uma tile de caso esteja dentro dos terrenos, se não tiver returna null
        return TileGeneration(currentX, currentY);
    }

    //Próxima posição do topTerrains
    private void nextTopGround(){
        int nextY, wight, space;
        nextY = MathUtils.random(GameInfo.topGroundMinPosition, GameInfo.topGroundMaxPosition);
        wight = MathUtils.random(3, GameInfo.topGroundMaxWight);
        space = MathUtils.random(1, GameInfo.topGroundMaxSpace);

        topTerrains.add(new Terrains(
                nextTopGround,
                nextY * GameInfo.sizeTexture,
                wight,
                1
        ));
        GameInfo.enemyManager.enemyGeneration(nextTopGround, (nextY + 1) * GameInfo.sizeTexture, wight);
        //GameInfo.itemManager.itemGeneration(nextTopGround, (nextY + 1) * GameInfo.sizeTexture, wight);
        nextTopGround += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
    }

    //Próxima posição do downTerrains
    private void nextDownGround(){
        int hight, wight, space;
        hight = MathUtils.random(GameInfo.downGroundMinHeight, GameInfo.downGroundMaxHeight);
        wight = MathUtils.random(3, GameInfo.downGroundMaxWight);
        space = MathUtils.random(GameInfo.downGroundMinSpace, GameInfo.downGroundMaxSpace);

        downTerrains.add(new Terrains(
                nextDownGround,
                0,
                wight,
                hight
        ));
        GameInfo.enemyManager.enemyGeneration(nextDownGround, hight * GameInfo.sizeTexture, wight);
        //GameInfo.itemManager.itemGeneration(nextDownGround, hight * GameInfo.sizeTexture, wight);
        nextDownGround += (wight * GameInfo.sizeTexture) + (space * GameInfo.sizeTexture);
    }

    //Returna os tiles caso o currentX e currentY esteja dentro de um dos terrenos
    public TextureRegion TileGeneration(int currentX, int currentY){
        //Verifica se é a parte de baixo
        if(currentY < GameInfo.downGroundMaxHeight * GameInfo.sizeTexture){
            for (Terrains terrain : downTerrains) {
                if (terrain.isCenter(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_05");
                } else if (terrain.isFirstColumn(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_04");
                } else if (terrain.isLastColumn(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_06");
                } else if (terrain.isUpColumn(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_02");
                } else if (terrain.isCornerLeft(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_01");
                } else if (terrain.isCornerRight(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_03");
                }
            }
        }
        //Verifica se é a parte de cima
        else if(currentY >= GameInfo.topGroundMinPosition * GameInfo.sizeTexture && currentY <= GameInfo.topGroundMaxPosition * GameInfo.sizeTexture){
            for (Terrains terrain : topTerrains){
                if (terrain.isUpColumn(currentX, currentY)){
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_10");
                }
                else if (terrain.isCornerLeft(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_09");
                } else if (terrain.isCornerRight(currentX, currentY)) {
                    return tileManager.getTexture(GameInfo.currentBiome + "_Terrain_11");
                }
            }
        }
        return null;
    }
}
