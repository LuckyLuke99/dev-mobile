package com.devmobile.game.objects.enemys.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.devmobile.game.helpers.GameInfo;

public class ToPlayer {
    private UpAndDown movement;
    private Rectangle rectangle;
    private float acel;

    private boolean isPlayerInRange, isLookingForPlayer;

    private float reachLook;
    private Vector2 posNext;
    private Vector2 posEnd;
    private Vector2 speed;

    public ToPlayer (Rectangle rectangle, float range, float acel, float reachLook){
        this.rectangle = rectangle;
        this.acel = acel * 5;
        this.reachLook = rectangle.getX() - (reachLook * GameInfo.sizeTexture);

        posNext = new Vector2();
        posEnd = new Vector2();
        speed = new Vector2();

        isLookingForPlayer = true;
        isPlayerInRange = false;

        movement = new UpAndDown(rectangle, range, acel);

    }

    public void update(){
        float playerX = GameInfo.mainCharacter.getX();
        float playerY = GameInfo.mainCharacter.getY();

        if(isLookingForPlayer){
            if(isPlayerInRange){
                posEnd.x = GameInfo.mainCharacter.getX();
                posEnd.y = GameInfo.mainCharacter.getY();
                isLookingForPlayer = false;
            }
            else if(playerX > reachLook && playerY > movement.getMinRange() && playerY < movement.getMaxRange()){
                isPlayerInRange = true;
            }
            else {
                movement.update();
            }
        }
        else {
            goTo();
        }
    }

    //Move até o posEnd
    private void goTo(){
        if(rectangle.getX() > GameInfo.mainCharacter.getX()){
            double raizQuadrada = Math.sqrt(((posEnd.x - rectangle.getX()) * (posEnd.x - rectangle.getX())));
            if(rectangle.getX() != posEnd.x){
                float distance = posEnd.x - rectangle.getX();
                speed.x = (acel * distance) / (float) raizQuadrada;
                posNext.x = speed.x * Gdx.graphics.getDeltaTime();
                if(Math.abs(posNext.x) > Math.abs(distance)){
                    this.rectangle.setX(posEnd.x);
                }
                else {
                    rectangle.setX(rectangle.getX() + posNext.x);
                }
            }
            if(rectangle.getY() != posEnd.y){
                float distance = posEnd.y - rectangle.getY();
                speed.y = acel * (distance) / (float) raizQuadrada;
                posNext.y = speed.y * Gdx.graphics.getDeltaTime();
                if(Math.abs(posNext.y) > Math.abs(distance)){
                    this.rectangle.setY(posEnd.y);
                }
                else {
                    rectangle.setY(rectangle.getY() + posNext.y);
                }
            }
        }
    }
}
