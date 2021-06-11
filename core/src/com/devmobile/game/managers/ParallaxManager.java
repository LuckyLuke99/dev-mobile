package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.devmobile.game.helpers.GameInfo;

public class ParallaxManager {
    final TileManager tileManager;
    BGManager bg01, bg02, bg03, bg04;
    public ParallaxManager (final TileManager tileManager){
        this.tileManager = tileManager;
        start();
    }

    public void reset(){
        bg04.reset(tileManager.getTexture(GameInfo.currentBiome + "_BG_04"));
        bg03.reset(tileManager.getTexture(GameInfo.currentBiome + "_BG_03"));
        bg02.reset(tileManager.getTexture(GameInfo.currentBiome + "_BG_02"));
        bg01.reset(tileManager.getTexture(GameInfo.currentBiome + "_BG_01"));
    }

    public void update(OrthographicCamera camera){
        bg04.update(camera);
        bg03.update(camera);
        bg02.update(camera);
        bg01.update(camera);
    }

    public void draw(SpriteBatch batch){
        bg04.draw(batch);
        bg03.draw(batch);
        bg02.draw(batch);
        bg01.draw(batch);
    }

    public void start(){
        bg04 = new BGManager(tileManager.getTexture(GameInfo.currentBiome + "_BG_04"),GameInfo.parallaxBG04);
        bg03 = new BGManager(tileManager.getTexture(GameInfo.currentBiome + "_BG_03"),GameInfo.parallaxBG03);
        bg02 = new BGManager(tileManager.getTexture(GameInfo.currentBiome + "_BG_02"),GameInfo.parallaxBG02);
        bg01 = new BGManager(tileManager.getTexture(GameInfo.currentBiome + "_BG_01"), GameInfo.parallaxBG01);
    }
}
