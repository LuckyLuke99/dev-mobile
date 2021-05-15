package com.devmobile.game.helpers;

public class GameInfo {
    public final static float WIDHT = 670;
    public final static float HEIGHT = 375;
    public final static int sizeTexture = 16;
    public final static int maxY = Math.round(GameInfo.HEIGHT / GameInfo.sizeTexture);
    public static float deltaTime = 0;
    public static float velCamera = 100f; // Velocidade da camera


    //Parallax, os valores vão de 0 a 100, sendo 100 parado e 0 sem efeito
    public static int parallaxBG01 = 20;
    public static int parallaxBG02 = 40;
    public static int parallaxBG03 = 60;
    //O valor do back vai define quando tempo irá durar o bioma atual
    public static int parallaxBG04 = 80;

    //Nome dos backgrounds do atlas
    public final static String grasslandBG = "Grassland_BG_";
    public final static String autumnForestBG = "AutumnForest_BG_";
    public final static String tropicsBG = "Tropics_BG_";
    public final static String winterWorldBG = "WinterWorld_BG_";

    //Nomes dos terrenos dentro do atlas vai de 01 até 11
    public final static String grasslandTerrain = "Grassland_Terrain_";
    public final static String autumnForestTerrain = "AutumnForest_Terrain_";
    public final static String tropicsTerrain = "Tropics_Terrain_";
    public final static String winterWorldTerrain = "WinterWorld_Terrain_";

    public static String currentBiome = GameInfo.grasslandTerrain; //Bioma atual do mapa

    //variaveis do random do metodo highTerrainGenerator
    public static int highGroundMinPosition = 7; //minY
    public static int highGroundMaxPosition = 17; //maxY
    public static int highGroundMaxSpace = 6; // Tamanho máximo do espaco entre os tiles
    public static int highGroundMaxWight = 15;

    //variaveis do random do metodo terrainGenerator
    public static int groundMinPosition = 1; // minY
    public static int groundMaxPosition = 4; // maxY
    public static int groundMaxWidght = 30; // maxX
    public static int groundMaxSpace = 6; // Tamanho máximo do espaco entre os tiles
}