package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class GenericTile extends Rectangle {
    TextureRegion texture;

    public GenericTile (TextureRegion texture){
        this.texture = texture;
        if(!(texture == null)){
            setWidth(texture.getRegionWidth());
            setHeight(texture.getRegionHeight());
        }
        else {
            setWidth(0);
            setHeight(0);
        }
    }

    public void draw (Batch batch){
        if(!(texture == null)){
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    public void setTexture (TextureRegion texture){
        this.texture = texture;
        if(!(texture == null)){
            setWidth(texture.getRegionWidth());
            setHeight(texture.getRegionHeight());
        }
        else {
            setWidth(0);
            setHeight(0);
        }
    }

    public boolean isNull(){
        if(texture == null){
            return true;
        }
        else {
            return false;
        }
    }
}
