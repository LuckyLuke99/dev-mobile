package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class Player extends Sprite {
    private World world;
    private Body body;

    public Player(World world, String name, float x, float y){
        super(new Texture(name));
        this.world = world;
        setPosition(
                x - getWidth() / 2,
                y - getHeight() / 2 + 300
        );
        createBody();
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(
                getX() / GameInfo.PPM,
                getY() / GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (getWidth() / 2f) / GameInfo.PPM,
                (getHeight() / 2f) / GameInfo.PPM
        );

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Player");

        shape.dispose();
    }

    public void updatePlayer(){
        this.setPosition(
                body.getPosition().x * GameInfo.PPM,
                body.getPosition().y * GameInfo.PPM
        );
    }

    public Body getBody(){
        return body;
    }
}
