package com.devmobile.game.helpers;

import com.badlogic.gdx.physics.box2d.World;

public class GameInfo {
    //Tamanho da tela
    public final static int WIDHT = 800;
    public final static int HEIGHT = 480;

    public static World world;
    public final static int sizeTexture = 16; //Tamanho dos tiles 16x16
    public static float velCamera = 120f; // Velocidade da camera
    public static String currentBiome; //Bioma atual do mapa

    // Como o Box2D usa metros para medir o mundo, aplicar força, etc
    // Isso vai ser usado para conversão na hora de criar os bodys dos objetos fazendo 1 pixel ser igual 1 metro
    public static float PPM = 100;

    //Parallax, os valores vão de 0 a 100, sendo 100 parado e 0 sem efeito
    public static int parallaxBG01 = 50;
    public static int parallaxBG02 = 60;
    public static int parallaxBG03 = 70;
    //O valor do back vai define quando tempo irá durar o bioma atual
    public static int parallaxBG04 = 80;

    //Nome dos backgrounds do atlas
    public final static String grasslandBG = "Grassland_BG_";
    public final static String autumnForestBG = "AutumnForest_BG_";
    public final static String tropicsBG = "Tropics_BG_";
    public final static String winterWorldBG = "WinterWorld_BG_";

    public static int downGroundMaxHeight = 10;
    public static int downGroundMinHeight = 2;
    public static int downGroundMaxWight = 30;
    public static int downGroundMaxSpace = 8;
    public static int downGroundMinSpace = 4;

    //variaveis do random do metodo highTerrainGenerator
    public static int topGroundMinPosition = 11; //minY
    public static int topGroundMaxPosition = 20; //maxY
    public static int topGroundMaxSpace = 6; // Tamanho máximo do espaco entre os tiles
    public static int topGroundMaxWight = 15;
}