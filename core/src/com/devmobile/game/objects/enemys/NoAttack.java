package com.devmobile.game.objects.enemys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;

public class NoAttack extends GenericEnemy{
    protected Animation hurt, run;
    protected boolean isHurt;
    private float animationSpeed, elapsedTime;
    public NoAttack(String name, float width, float height, float x, float y) {
        super(name, width, height, x, y);
        animationSpeed = 0.10f;
        configAnimations(GameInfo.tileManager.getEnemys());
    }

    @Override
    public void drawAnimations(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isHurt){
            batch.draw((TextureAtlas.AtlasRegion)hurt.getKeyFrame(elapsedTime), getX(), getY());
        }
        else {
            batch.draw((TextureAtlas.AtlasRegion)run.getKeyFrame(elapsedTime), getX(), getY());
        }
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
