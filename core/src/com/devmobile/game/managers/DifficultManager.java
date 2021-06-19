package com.devmobile.game.managers;

import com.devmobile.game.helpers.GameInfo;

public class DifficultManager {
    private float startVelCamera;
    private int startCoinChance;
    private int startEnemyChance;


    public enum states {
        LEVEL01,
        LEVEL02,
        LEVEL03,
    }
    private states currentLevel;
    public DifficultManager (){
        startVelCamera = GameInfo.velCamera;
        startCoinChance = GameInfo.coinChance;
        startEnemyChance = GameInfo.enemyChance;
        reset();
    }
    public void reset(){
        currentLevel = states.LEVEL01;
        GameInfo.velCamera = startVelCamera;
        GameInfo.coinChance = startCoinChance;
        GameInfo.enemyChance = startEnemyChance;
    }

    public void update(){
        switch (currentLevel){
            case LEVEL01:
                if(GameInfo.mainScore > 100){
                    currentLevel = states.LEVEL02;
                }
                break;
            case LEVEL02:
                GameInfo.velCamera += 10;
                if(GameInfo.mainScore > 200){
                    currentLevel = states.LEVEL03;
                }
                break;
            case LEVEL03:
                if(GameInfo.mainScore > 300){
                    currentLevel = states.LEVEL03;
                }
        }
    }

    private void configLevel01(){

    }

    private void configLevel02(){

    }

    private void configLevel03(){

    }
}
