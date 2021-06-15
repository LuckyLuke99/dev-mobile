package com.devmobile.game.tiles.enemys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.devmobile.game.helpers.GameInfo;

import java.awt.Rectangle;

public class SideToSide {
    private Rectangle rectangle;
    private float maxRange;
    protected float acel, vel;

    public SideToSide(Rectangle rectangle, int range, float acel){
//        this.rectangle = rectangle;
//        this.acel = acel;
//        maxRange = rectangle.getX() + (range * GameInfo.sizeTexture);
    }

    private void movement (){
        float deltaTime = Gdx.graphics.getDeltaTime();
//        if(pos < maxRange){
//
//        }
        vel += acel * deltaTime;

    }
}
