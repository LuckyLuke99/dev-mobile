package com.devmobile.game.objects.enemys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GenericEnemy extends Rectangle {
    protected String name;
    protected boolean isDead;

    public GenericEnemy(String name, float width, float height, float x, float y){
        setWidth(width);
        setHeight(height);
        setPosition(x, y);

        this.name = name;
        isDead = false;
    }

    public void update(){
    }

    public void drawAnimations(SpriteBatch batch){

    }

    public boolean isDead() {
        return isDead;
    }
}
