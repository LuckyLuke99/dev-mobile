package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.BG;

public class BGManager {
    private BG[] bgs;
    private float nextPositionX;
    private int countBG = 0;
    private float offSetX;

    //Caso só seja passado uma textura
    public  BGManager(TextureAtlas.AtlasRegion texture, float offSetX){
        bgs = new BG[3];

        //Adicionando os bgs a primeira vez
        for (int i = 0; i < bgs.length; i++){
            bgs[i] = new BG(texture);
            bgs[i].setX(bgs[i].getWidth() * i);
            addNextPostionX(bgs[i]);
        }

        //Checando se o valor está fora do padrão e reajustando para o limite
        if(offSetX < 0){
            offSetX = 0;
        }
        if(offSetX > 100){
            offSetX = 100;
        }
        this.offSetX = offSetX;
    }

    public void update(OrthographicCamera camera){
        float delta = offSetX * GameInfo.deltaTime;
        nextPositionX += delta;
        for (BG bg:bgs) {
            bg.setX(bg.getX() + delta);
        }
        if(bgs[countBG].isOutBounds(camera)){
            bgs[countBG].setX(nextPositionX);
            addNextPostionX(bgs[countBG]);
            addCountSprite();
        }
    }

    public void draw (SpriteBatch batch){
        for (BG bg : bgs) {
            bg.draw(batch);
        }
    }

    private void addNextPostionX (BG bg){
        nextPositionX = bg.getX() + bg.getWidth() ;
    }

    private void addCountSprite(){
        countBG += 1;
        if (countBG == bgs.length) {
            countBG = 0;
        }
    }
}
