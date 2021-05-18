package com.devmobile.game.tiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.sun.tools.javac.util.Context;

import java.util.ArrayList;

public class GenericCharacter extends Rectangle {
    private Animation attack, hurt, run, falling, jumping, projectile;
    private float animationSpeed, elapsedTime, vel, deltaS, acel, rest;
    private int groundY;
    private boolean isJumping, isRunning, isAttacking, isHurt, isFalling, canShoot, isDead;
    private String name;

    public GenericCharacter (ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations, String name){
        this.name = name;
        setWidth(32);
        setHeight(32);

        animationSpeed = 0.10f;
        acel = 600;
        vel = 0;
        rest = 0.9f;
        elapsedTime = 0;
        isRunning = true;
        isFalling = false;

        configAnimations(animations);
    }

    public void checkTiles(GenericTile[][] tiles, int sizeX, int sizeY){
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if(!(tiles[x][y].isNull())){
                    if(this.overlaps(tiles[x][y])){
                        setY(tiles[x][y].getY() + tiles[x][y].getHeight());
                    }
                }
            }
        }
//        else{
//            isFalling = true;
//        }
    }

    public void update (OrthographicCamera camera){
        if(isRunning){
            setX(camera.position.x - 350);
        }
        if(Gdx.input.isTouched()){
            isJumping = true;
        }
        if (isFalling){
            acel = -10;
            vel += acel * Gdx.graphics.getDeltaTime();
            deltaS = vel * Gdx.graphics.getDeltaTime();
            setY(getY() + deltaS);
        }
        else if(isJumping){
            acel = 600;
            vel += acel * Gdx.graphics.getDeltaTime();
            deltaS = vel * Gdx.graphics.getDeltaTime();
            setY(getY() + deltaS);
            if(vel > 300){
                vel = 0;
                isJumping = false;
                isFalling = true;
            }
        }
    }

    public void checkColision(Rectangle rectangle){
        if(this.overlaps(rectangle)){
            if(isAttacking){
                //Mata o bicho
            }
            else {
                if(y > (rectangle.y + rectangle.height)){
                    //Caso tenha como matar pulando ele mata
                }
                else {
                    //Leva dano
                }
            }
        }
    }

    public void draw (SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isRunning){

        }
        else if(isJumping){

        }
        else if(isAttacking){
            if(canShoot){

            }
            else {

            }
        }
        else if(isHurt){

        }
        else if(isFalling){

        }
        batch.draw((TextureAtlas.AtlasRegion)run.getKeyFrame(elapsedTime), getX(), getY(), getWidth(), getHeight());
    }

    public boolean isJumping(){
        return isJumping;
    }
    //Configura as animações de acordo com o nome passado no começo
    private void configAnimations(ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations){
        for(String key : animations.keys()){
            if((name + "_attack").equals(key)){
                attack = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_hurt").equals(key)){
                hurt = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_run").equals(key)){
                run = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_falling").equals(key)){
                falling = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_jumping").equals(key)){
                jumping = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_projectile").equals(key)){
                projectile = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
        }
    }
}
