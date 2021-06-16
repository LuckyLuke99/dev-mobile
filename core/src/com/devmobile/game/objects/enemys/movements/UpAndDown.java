package com.devmobile.game.objects.enemys.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.devmobile.game.helpers.GameInfo;

public class UpAndDown {
    private Rectangle rectangle;
    private float maxRange, minRange;
    private float acel, vel;

    public UpAndDown (Rectangle rectangle, float range, float acel){
        this.rectangle = rectangle;
        this.acel = acel;
        setRandomX(range);

        minRange = rectangle.getY();
        float groundMinPosition = GameInfo.topGroundMinPosition * GameInfo.sizeTexture;
        if(minRange < groundMinPosition){
            maxRange = groundMinPosition;
        }
        else {
            maxRange = GameInfo.HEIGHT - GameInfo.sizeTexture;
        }
    }

    public void update(){
        vel = acel * Gdx.graphics.getDeltaTime();
        if(rectangle.getY() <= maxRange && rectangle.getY() >= minRange){
            rectangle.setY(rectangle.getY() + vel);
        }
        Bounds();
    }

    private void setRandomX(float range){
        float min = rectangle.getX();
        float max = min + ((range - 1) * GameInfo.sizeTexture);
        float randomNum = MathUtils.random(min, max);
        rectangle.setX(randomNum);
    }

    public float getMinRange (){
        return minRange;
    }

    public float getMaxRange (){
        return maxRange;
    }

    //Mantem o objeto dentro do limite
    private void Bounds(){
        if (rectangle.getY() > maxRange){
            acel = acel * -1;
            rectangle.setY(maxRange);
        }
        if (rectangle.getY() < minRange){
            acel = acel * -1;
            rectangle.setY(minRange);
        }
    }
}
