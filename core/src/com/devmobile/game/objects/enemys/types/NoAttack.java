package com.devmobile.game.objects.enemys.types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.enemys.types.GenericEnemy;

public class NoAttack extends GenericEnemy {
    protected Animation hurt, run;
    protected boolean isHurt, isFlipped;
    private float animationSpeed, elapsedTime;
    TextureAtlas.AtlasRegion currentFrame;

    public NoAttack(String name, float width, float height, float x, float y) {
        super(name, width, height, x, y);
        animationSpeed = 0.10f;
        isFlipped = false;
        configAnimations(GameInfo.tileManager.getEnemys());
    }

    @Override
    public void drawAnimation(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isHurt){
            currentFrame = (TextureAtlas.AtlasRegion) hurt.getKeyFrame(elapsedTime);
        }
        else {
            currentFrame = (TextureAtlas.AtlasRegion) run.getKeyFrame(elapsedTime);
        }
        //batch.draw(currentFrame, getX(), getY());
        batch.draw(currentFrame, getX(), getY(), (isFlipped ? -1 : 1) * getWidth(), getHeight());
    }

    //Configura as animações de acordo com o nome passado no começo
    private void configAnimations(ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations){
        for(String key : animations.keys()){
            if((name + "_run").equals(key)){
                run = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if ((name + "_hurt").equals(key)){
                hurt = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.NORMAL);
            }
        }
    }
}
