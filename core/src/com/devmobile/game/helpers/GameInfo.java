package com.devmobile.game.helpers;

import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.managers.ItemManager;
import com.devmobile.game.managers.TileManager;
import com.devmobile.game.tiles.GenericCharacter;

public class GameInfo {
    //------------------------------------------------------
    //---------------CONFIGURAÇÔES-PRINCIPAIS---------------
    //------------------------------------------------------
    public final static int WIDHT = 800;
    public final static int HEIGHT = 480;
    public final static int sizeTexture = 16; //Tamanho dos tiles 16x16
    public static float PPM = 100; // Pixel per Meters

    //------------------------------------------------------
    //-----------------VARIAVEIS-GLOBIAS--------------------
    //------------------------------------------------------

    public static World world;
    public static float mainScore;
    public static GenericCharacter mainCharacter;
    public static float velCamera = 120f; // Velocidade da camera
    public static int coinChance = 100; // Vai de 0 a 100;

    //------------------------------------------------------
    //-----------------------MANAGERS-----------------------
    //------------------------------------------------------
    //Referência dos managers
    public static TileManager tileManager;
    public static ItemManager itemManager;

    //------------------------------------------------------
    //-----------------------PARALLAX-----------------------
    //------------------------------------------------------
    //Parallax, os valores vão de 0 a 100, sendo 100 parado e 0 sem efeito
    public static int parallaxBG01 = 50;
    public static int parallaxBG02 = 60;
    public static int parallaxBG03 = 70;
    //O valor do back vai define quando tempo irá durar o bioma atual
    public static int parallaxBG04 = 80;

    //------------------------------------------------------
    //-----------------------BIOMAS-------------------------
    //------------------------------------------------------
    //Configuração referência dos biomas
    public final static String grasslandBG = "Grassland_BG_";
    public final static String autumnForestBG = "AutumnForest_BG_";
    public final static String tropicsBG = "Tropics_BG_";
    public final static String winterWorldBG = "WinterWorld_BG_";
    public static String currentBiome; //Bioma atual do mapa

    //------------------------------------------------------
    //-----------------------TERRENOS-----------------------
    //------------------------------------------------------
    //Configuração da geração do terreno de baixo
    public static int downGroundMaxHeight = 8;
    public static int downGroundMinHeight = 2;
    public static int downGroundMaxWight = 30;
    public static int downGroundMaxSpace = 8;
    public static int downGroundMinSpace = 4;

    //Configuração da geração do terreno de cima
    public static int topGroundMinPosition = 11; //minY
    public static int topGroundMaxPosition = 20; //maxY
    public static int topGroundMaxSpace = 6; // Tamanho máximo do espaco entre os tiles
    public static int topGroundMaxWight = 15;
}