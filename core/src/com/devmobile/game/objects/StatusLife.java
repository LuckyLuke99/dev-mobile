package com.devmobile.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.devmobile.game.helpers.GameInfo;

public class StatusLife extends Actor {
    protected float elapsedTime;
    private Animation animation;
    private TextureAtlas.AtlasRegion HeathFull;
    float size;
    int heathQtd;

    public StatusLife (){
        size = Gdx.graphics.getWidth() * 0.05f;
        animation = new Animation(0, GameInfo.tileManager.getItems("Hearth"), Animation.PlayMode.NORMAL);
        setSize(size, size);
        setPosition(Gdx.graphics.getWidth() * 0.10f, Gdx.graphics.getHeight() * 0.80f);
        HeathFull = (TextureAtlas.AtlasRegion) animation.getKeyFrame(elapsedTime);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(GameInfo.mainCharacter != null){
            heathQtd = GameInfo.mainCharacter.health;
            for (int i = 0; i < heathQtd; i++) {
                float nextX = i * getWidth();
                batch.draw(HeathFull, getX() + nextX, getY(), getWidth(), getHeight());
            }
        }
    }
}
