package com.devmobile.game.tiles.enemys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.devmobile.game.helpers.GameInfo;

public class SideToSide {
    private Rectangle rectangle;
    private float maxRange, minRange, posNext;
    private boolean isMovingRight;
    protected float acel, vel;

    public SideToSide(com.badlogic.gdx.math.Rectangle rectangle, int range, float acel){
        this.rectangle = rectangle;
        this.acel = acel;
        minRange = rectangle.getX();
        maxRange = (range * GameInfo.sizeTexture) + minRange;
        isMovingRight = true;
    }

//    private void movement (float posEnd){
//        double raizQuadrada = Math.sqrt((posEnd - rectangle.getX()) * (posEnd - rectangle.getX()));
//        if(rectangle.getX() != posEnd){
//            float distance = posEnd - rectangle.getX();
//            vel = (acel * distance) / (float) raizQuadrada;
//            posNext = speed.x * Gdx.graphics.getDeltaTime();
//            if(Math.abs(posNext.x) > Math.abs(distance)){
//                this.setX(posEnd);
//            }
//            else {
//                translateX(posNext.x);
//            }
//        }
//    }
//
//    private void movement (float position){
//        float pos = rectangle.getX();
//        if(isMovingRight){
//            double raizQuadrada = Math.sqrt((position - pos) * (position - pos));
//            if(pos != position){
//                float distance = position - pos;
//                vel = (acel * distance) / (float) raizQuadrada;
//                posNext = vel * Gdx.graphics.getDeltaTime();
//                if(Math.abs(posNext) > Math.abs(distance)){
//                    rectangle.setX(position);
//                }
//                else {
//                    pos += posNext;
//                    rectangle.setX(pos);
//                }
//            }
//        }
//    }
}
