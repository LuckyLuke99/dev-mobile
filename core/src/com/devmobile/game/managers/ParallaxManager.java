package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.devmobile.game.helpers.GameInfo;

public class ParallaxManager {
    final TileManager tileManager;
    BGManager bg01, bg02, bg03, bg04;
    String currentParallax;

    public ParallaxManager (final TileManager tileManager){
        this.tileManager = tileManager;

        currentParallax = GameInfo.grasslandBG;
        bg04 = new BGManager(tileManager.getTexture(currentParallax + "04"),GameInfo.parallaxBG04);
        bg03 = new BGManager(tileManager.getTexture(currentParallax + "03"),GameInfo.parallaxBG03);
        bg02 = new BGManager(tileManager.getTexture(currentParallax + "02"),GameInfo.parallaxBG02);
        bg01 = new BGManager(tileManager.getTexture(currentParallax + "01"), GameInfo.parallaxBG01);

    }

    public void update(OrthographicCamera camera){
        bg04.update(camera);
        bg03.update(camera);
        bg02.update(camera);
        bg01.update(camera);

//        if(!(bg01.isChanging())){
//            bg01.setTexture(tileManager.getTexture(GameInfo.grasslandBG + "01"));
//        }
//        if(!(bg02.isChanging())){
//            bg02.setTexture(tileManager.getTexture(GameInfo.grasslandBG + "02"));
//        }
//        if(!(bg03.isChanging())){
//            bg03.setTexture(tileManager.getTexture(GameInfo.grasslandBG + "03"));
//        }
//        if(!(bg04.isChanging())){
//            bg04.setTexture(tileManager.getTexture(GameInfo.grasslandBG + "04"));
//        }
    }

    public void draw(SpriteBatch batch){
        bg04.draw(batch);
        bg03.draw(batch);
        bg02.draw(batch);
        bg01.draw(batch);
    }
}
