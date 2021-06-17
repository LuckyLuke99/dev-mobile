package com.devmobile.game.objects.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class GenericItem extends Rectangle {
    protected float elapsedTime;
    protected float animationSpeed;
    protected Animation animation;
    protected boolean isPlaying;
    protected boolean isDead;
    protected TextureAtlas.AtlasRegion currentFrame;

    public GenericItem (Array<TextureAtlas.AtlasRegion> animation, Boolean isLooping, int width, int height){
        animationSpeed = 0.10f;
        if(!(isLooping)){
            this.animation = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animation, Animation.PlayMode.NORMAL);
        }
        else {
            this.animation = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animation, Animation.PlayMode.LOOP);
        }
        isPlaying = true;
        setWidth(width);
        setHeight(height);
    }

    public GenericItem (Array<TextureAtlas.AtlasRegion> animation, float animationSpeed){
        this.animationSpeed = animationSpeed;
        this.animation = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animation, Animation.PlayMode.LOOP);
        setWidth(width);
        setHeight(height);
    }

    public void changeAnimation(SpriteBatch batch){
        if(!(isDead)){
            if(isPlaying){
                elapsedTime += Gdx.graphics.getDeltaTime();
                currentFrame = (TextureAtlas.AtlasRegion)animation.getKeyFrame(elapsedTime);
            }
            else {
                elapsedTime = 0;
                currentFrame =(TextureAtlas.AtlasRegion)animation.getKeyFrame(elapsedTime);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        changeAnimation(batch);
        if(currentFrame != null || !(isDead)){
            batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
        }
    }

    public void setPlaying(boolean b){
        isPlaying = b;
    }

    public boolean getDead(){
        return isDead;
    }

    public void setDead(Boolean b){
        isDead = b;
    }

    public void use(){

    }

    public boolean checkCollision(Rectangle rectangle){
        if(this.overlaps(rectangle)){
            return true;
        }
        else {
            return false;
        }
    }
}
