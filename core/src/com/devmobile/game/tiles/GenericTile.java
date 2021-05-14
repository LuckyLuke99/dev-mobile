package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.devmobile.game.helpers.GameInfo;

public class GenericTile extends Rectangle {
    TextureAtlas.AtlasRegion texture;

    public GenericTile (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
        setWidth(GameInfo.sizeTexture);
        setHeight(GameInfo.sizeTexture);
    }

    public void draw (Batch batch){
        if(!(texture == null)){
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    public void setTexture (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }
}
