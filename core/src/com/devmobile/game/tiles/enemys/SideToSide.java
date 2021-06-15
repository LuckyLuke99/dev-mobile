package com.devmobile.game.tiles.enemys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.devmobile.game.helpers.GameInfo;

public class SideToSide {
    private int maxRange, pos;
    protected float acel, vel;

    public SideToSide(float acel, int range, float position){
        maxRange = range * GameInfo.sizeTexture;
        pos = position;
        this.acel = acel;
    }

    private void movement (){
        float deltaTime = Gdx.graphics.getDeltaTime();
        if(pos < maxRange){

        }
        vel += acel * deltaTime;

    }
}
