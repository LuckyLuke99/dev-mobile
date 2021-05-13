package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class GenericTile extends Rectangle {
    TextureAtlas.AtlasRegion texture;

    public GenericTile (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }

    public GenericTile (){
    }

    public void draw (Batch batch){
        if(!(texture == null)){
            batch.draw(texture, getX(), getY());
        }
    }

    public void setTexture (TextureAtlas.AtlasRegion texture){
        this.texture = texture;
    }
}
