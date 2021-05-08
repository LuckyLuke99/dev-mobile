package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class GenericTile extends Rectangle {
    TextureAtlas.AtlasRegion texture;

    public GenericTile (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }

    public void draw (Batch batch){
        batch.draw(texture, (float) getX(), (float) getY());
    }
}
