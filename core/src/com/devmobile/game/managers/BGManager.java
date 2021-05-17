package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.BG;



public class BGManager {
    private BG[] bgs;
    private float nextPositionX;
    private int countBG = 0;
    private int lastBG = 2;
    private int countChange = 1;
    private float offSetX;
    private boolean isChanging;

    //Caso só seja passado uma textura
    public  BGManager(TextureAtlas.AtlasRegion texture, int offSetX){
        bgs = new BG[3];
        nextPositionX = 0;

        //Adicionando os bgs a primeira vez
        for (int i = 0; i < bgs.length; i++){
            bgs[i] = new BG(texture);
            bgs[i].setX(nextPositionX);
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
        isChanging = false;
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
            change();
            addCountSprite();
        }
    }

    public void draw (SpriteBatch batch){
        for (BG bg : bgs) {
            bg.draw(batch);
        }
    }

    private void addNextPostionX (BG bg){
        nextPositionX = bg.getX() + bg.getWidth();
    }

    public void setTexture(TextureAtlas.AtlasRegion texture){
        bgs[lastBG].setTexture(texture);
    }

    public boolean isChanging (){
        return isChanging;
    }

    private void change (){
        if(isChanging){
            countChange +=1;
            if(countChange <= bgs.length){
                bgs[countBG].setTexture(bgs[lastBG].getTexture());
            }
            else {
                countChange = 1;
                isChanging = false;
            }
        }
    }

    private void addCountSprite(){
        countBG += 1;
        lastBG += 1;
        if (countBG == bgs.length) {
            countBG = 0;
        }
        if(lastBG == bgs.length){
            lastBG = 0;
        }
    }
}
