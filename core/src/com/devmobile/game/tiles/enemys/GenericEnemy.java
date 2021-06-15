package com.devmobile.game.tiles.enemys;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.items.GenericItem;

public class GenericEnemy extends Rectangle {
    protected String name;
    protected boolean isDead;

    public GenericEnemy(String name, float width, float height, float x, float y){
        setWidth(width);
        setHeight(height);
        setPosition(x, y);

        this.name = name;
        isDead = false;
    }

    public void update(){
    }

    public void drawAnimations(SpriteBatch batch){

    }

    public boolean isDead() {
        return isDead;
    }
}
