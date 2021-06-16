package com.devmobile.game.objects.enemys.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.enemys.GenericEnemy;

public class RunAndAttack extends GenericEnemy {
    protected Animation hurt, run, attack;
    protected boolean isHurt, isAttacking;
    private float animationSpeed;

    public RunAndAttack(String name, float width, float height, float x, float y) {
        super(name, width, height, x, y);
        animationSpeed = 0.10f;
        configAnimations(GameInfo.tileManager.getEnemys());
    }

    @Override
    public void changeAnimation() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isHurt){
            currentFrame = (TextureAtlas.AtlasRegion) hurt.getKeyFrame(elapsedTime);
        }
        else if(isAttacking){
            currentFrame = (TextureAtlas.AtlasRegion) attack.getKeyFrame(elapsedTime);
        }
        else {
            currentFrame = (TextureAtlas.AtlasRegion) run.getKeyFrame(elapsedTime);
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
            else if ((name + "_attack").equals(key)){
                attack = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.NORMAL);
            }
        }
    }
}
