package com.devmobile.game.objects.enemys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class GenericEnemy extends Rectangle {
    protected String name;
    protected boolean isDead, isFlipped;
    protected TextureAtlas.AtlasRegion currentFrame;
    protected float elapsedTime;

    public GenericEnemy(String name, float width, float height, float x, float y){
        setWidth(width);
        setHeight(height);
        setPosition(x, y);

        this.name = name;
        isDead = false;
        isFlipped = false;
    }

    public void update(){
    }

    public void changeAnimation(){

    }

    public void draw(SpriteBatch batch){
        changeAnimation();
        if(currentFrame != null){
            batch.draw(currentFrame, (isFlipped ? getX() + getWidth() : getX()), getY(), (isFlipped ? -getWidth() : getWidth()), getHeight());
        }
    }

    public boolean checkCollision(Rectangle rectangle){
        if(this.overlaps(rectangle)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isDead() {
        return isDead;
    }
}
