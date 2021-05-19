package com.devmobile.game.helpers;

public class GameInfo {
    public final static int WIDHT = 800;
    public final static int HEIGHT = 480;
    public final static int sizeTexture = 16;
    public final static int maxY = GameInfo.HEIGHT / GameInfo.sizeTexture;
    public static float deltaTime = 0;
    public static float velCamera = 100f; // Velocidade da camera
    public static float PPM = 100;

    public static String currentBiome; //Bioma atual do mapa

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

    //variaveis do random do metodo highTerrainGenerator
    public static int highGroundMinPosition = 11; //minY
    public static int highGroundMaxPosition = 20; //maxY
    public static int highGroundMaxSpace = 6; // Tamanho máximo do espaco entre os tiles
    public static int highGroundMaxWight = 15;

    //variaveis do random do metodo terrainGenerator
    public static int groundMinPosition = 5; // minY
    public static int groundMaxPosition = 6; // maxY
    public static int groundMaxWidght = 30; // maxX
    public static int groundMaxSpace = 4; // Tamanho máximo do espaco entre os tiles
}