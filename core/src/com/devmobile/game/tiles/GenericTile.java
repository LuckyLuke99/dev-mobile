package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class GenericTile extends Rectangle {
    TextureAtlas.AtlasRegion texture;

    public GenericTile (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }

    public void draw (SpriteBatch batch){
        System.out.println(texture);
        batch.draw(texture, getX(), getY());
    }
}
