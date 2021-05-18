package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class GenericTile02 extends Rectangle {
    TextureAtlas.AtlasRegion texture;
    private World world;
    private Body body;

    public GenericTile02(TextureAtlas.AtlasRegion texture, World world){
        this.texture = texture;
        this.world = world;
        if(!(texture == null)){
            setWidth(texture.getRegionWidth());
            setHeight(texture.getRegionHeight());
        }
        else {
            setWidth(0);
            setHeight(0);
        }
        createBody();
    }

    public void draw (Batch batch){
        if(!(texture == null)){
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    public void setTexture (TextureAtlas.AtlasRegion texture){
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

    private void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(
                getX(),
                getY()
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth(),
                (getHeight() / 2)
        );

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Tile");

        shape.dispose();
    }
}
