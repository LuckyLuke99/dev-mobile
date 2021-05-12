package com.devmobile.game.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class GenericTile extends Rectangle {
    TextureAtlas.AtlasRegion texture;

    float elapseTime;
    Animation animation;

    public GenericTile (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }

    public GenericTile (Animation animation){
        this.animation = animation;
    }

    public void draw (SpriteBatch batch){
        elapseTime += Gdx.graphics.getDeltaTime();
        batch.draw((TextureAtlas.AtlasRegion)animation.getKeyFrame(elapseTime, true), getX(), getY()); // Precisa usar o (TextureAtlas.AtlasRegion)
    }
}
