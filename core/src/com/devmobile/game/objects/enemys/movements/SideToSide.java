package com.devmobile.game.objects.enemys.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.devmobile.game.helpers.GameInfo;

public class SideToSide {
    private Rectangle rectangle;
    private float maxRange, minRange;
    private float acel, vel;

    public SideToSide (Rectangle rectangle, float range, float acel){
        this.rectangle = rectangle;
        minRange = rectangle.getX();
        maxRange = minRange + ((range - 1) * GameInfo.sizeTexture);
        this.acel = acel;
    }

    public void update(){
        vel = acel * Gdx.graphics.getDeltaTime();
        if(rectangle.getX() <= maxRange && rectangle.getX() >= minRange){
            rectangle.setX(rectangle.getX() + vel);
        }
        Bounds();
    }

    //Mantem o objeto dentro do limite
    private void Bounds(){
        if (rectangle.getX() > maxRange){
            acel = acel * -1;
            rectangle.setX(maxRange);
        }
        if (rectangle.getX() < minRange){
            acel = acel * -1;
            rectangle.setX(minRange);
        }
    }

    public boolean isMovingRight(){
        if(acel > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
