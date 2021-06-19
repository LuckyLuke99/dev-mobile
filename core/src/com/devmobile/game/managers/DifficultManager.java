package com.devmobile.game.managers;

import com.badlogic.gdx.Game;
import com.devmobile.game.helpers.GameInfo;

public class DifficultManager {
    private float startVelCamera;

    private int startCoinChance;
    private int startCoinSmall;
    private int startCoinMedium;
    private int startCoinLarger;


    private int startEnemyChance;
    private int startEnemyOcti;
    private int startEnemyPokeyBub;
    private int startEnemyRoboPumkin;
    private int startEnemySpikeyBub;
    private int startEnemyBlockyBub;
    private int startEnemyBub;


    private int startDownGroundMaxHeight;
    private int startDownGroundMinHeight;
    private int startDownGroundMinWight;
    private int startDownGroundMaxWight ;
    private int startDownGroundMinSpace;
    private int startDownGroundMaxSpace ;
    private int startTopGroundMinPosition;
    private int startTopGroundMaxPosition ;
    private int startTopGroundMinSpace;
    private int startTopGroundMaxSpace;
    private int startTopGroundMinWight ;
    private int startTopGroundMaxWight ;


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
        configLevel01();
    }
    public void reset(){
        currentLevel = states.LEVEL01;
        GameInfo.velCamera  = startVelCamera;
        GameInfo.coinChance  = startCoinChance;
        GameInfo.enemyChance = startEnemyChance;
        GameInfo.coinSmallChance = startCoinSmall;
        GameInfo.coinMediumChance = startCoinMedium;
        GameInfo.coinLargerChance = startCoinLarger;
        GameInfo.enemyOctiChance = startEnemyOcti;
        GameInfo.enemyPokeyBubChance = startEnemyPokeyBub;
        GameInfo.enemyRoboPumpkinChance = startEnemyRoboPumkin;
        GameInfo.enemySpikeyBubChance = startEnemySpikeyBub;
        GameInfo.enemyBlockyBubChance = startEnemyBlockyBub;
        GameInfo.enemyBubChance = startEnemyBub;
        GameInfo.downGroundMaxHeight = startDownGroundMaxHeight;
        GameInfo.downGroundMinHeight = startDownGroundMinHeight;
        GameInfo.downGroundMinWight = startDownGroundMinWight;
        GameInfo.downGroundMaxWight  = startDownGroundMaxWight;
        GameInfo.downGroundMinSpace = startDownGroundMinSpace;
        GameInfo.downGroundMaxSpace  = startDownGroundMaxSpace;
        GameInfo.topGroundMinPosition = startTopGroundMinPosition;
        GameInfo.topGroundMaxPosition  = startTopGroundMaxPosition;
        GameInfo.topGroundMinSpace = startTopGroundMinSpace;
        GameInfo.topGroundMaxSpace = startTopGroundMaxSpace;
        GameInfo.topGroundMinWight  = startTopGroundMinWight;
        GameInfo.topGroundMaxWight  = startTopGroundMaxWight;
    }

    public void update(){
        switch (currentLevel){
            case LEVEL01:
                if(GameInfo.mainScore > 1000){
                    currentLevel = states.LEVEL02;
                    configLevel02();
                }
                break;
            case LEVEL02:
                if(GameInfo.mainScore > 2000){
                    currentLevel = states.LEVEL03;
                    configLevel03();
                }
                break;
            case LEVEL03:
                break;
        }
    }

    private void configLevel01(){
        startVelCamera = GameInfo.velCamera;
        startCoinChance = GameInfo.coinChance;
        startEnemyChance = GameInfo.enemyChance;
        startCoinSmall = GameInfo.coinSmallChance;
        startCoinMedium = GameInfo.coinMediumChance;
        startCoinLarger = GameInfo.coinLargerChance;
        startEnemyOcti = GameInfo.enemyOctiChance;
        startEnemyPokeyBub = GameInfo.enemyPokeyBubChance;
        startEnemyRoboPumkin = GameInfo.enemyRoboPumpkinChance;
        startEnemySpikeyBub = GameInfo.enemySpikeyBubChance;
        startEnemyBlockyBub = GameInfo.enemyBlockyBubChance;
        startEnemyBub = GameInfo.enemyBubChance;

        startDownGroundMaxHeight = GameInfo.downGroundMaxHeight;
        startDownGroundMinHeight = GameInfo.downGroundMinHeight;
        startDownGroundMinWight = GameInfo.downGroundMinWight;
        startDownGroundMaxWight = GameInfo.downGroundMaxWight ;
        startDownGroundMinSpace = GameInfo.downGroundMinSpace;
        startDownGroundMaxSpace = GameInfo.downGroundMaxSpace ;
        startTopGroundMinPosition = GameInfo.topGroundMinPosition;
        startTopGroundMaxPosition = GameInfo.topGroundMaxPosition ;
        startTopGroundMinSpace = GameInfo.topGroundMinSpace;
        startTopGroundMaxSpace = GameInfo.topGroundMaxSpace;
        startTopGroundMinWight = GameInfo.topGroundMinWight ;
        startTopGroundMaxWight = GameInfo.topGroundMaxWight ;

    }

    private void configLevel02(){
        GameInfo.velCamera = 150f;
        GameInfo.coinChance = 60;
        GameInfo.enemyChance = 50;
        GameInfo.coinSmallChance = 2;
        GameInfo.coinMediumChance = 3;
        GameInfo.coinLargerChance = 2;
        GameInfo.enemyOctiChance = 5;
        GameInfo.enemyPokeyBubChance = 4;
        GameInfo.enemyRoboPumpkinChance= 4;
        GameInfo.enemySpikeyBubChance = 4;
        GameInfo.enemyBlockyBubChance = 4;
        GameInfo.enemyBubChance = 4;
    }

    private void configLevel03(){
        GameInfo.velCamera = 200f;
        GameInfo.coinChance = 80;
        GameInfo.enemyChance = 70;
        GameInfo.coinSmallChance = 1;
        GameInfo.coinMediumChance = 3;
        GameInfo.coinLargerChance = 5;
        GameInfo.enemyOctiChance = 5;
        GameInfo.enemyPokeyBubChance = 6;
        GameInfo.enemyRoboPumpkinChance= 6;
        GameInfo.enemySpikeyBubChance = 6;
        GameInfo.enemyBlockyBubChance = 6;
        GameInfo.enemyBubChance = 6;

        GameInfo.downGroundMaxHeight = 6;
        GameInfo.downGroundMinHeight = 4;
        GameInfo.downGroundMinWight = 3;
        GameInfo.downGroundMaxWight = 20;
        GameInfo.downGroundMinSpace = 6;
        GameInfo.downGroundMaxSpace = 10;
        GameInfo.topGroundMinPosition = 8;
        GameInfo.topGroundMaxPosition = 16;
        GameInfo.topGroundMinSpace = 6;
        GameInfo.topGroundMaxSpace = 6;
        GameInfo.topGroundMinWight = 15;
        GameInfo.topGroundMaxWight = 15;
    }
}
