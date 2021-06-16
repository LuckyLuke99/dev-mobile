package com.devmobile.game.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class Terrains02 extends Rectangle {
    private Body body;
    private World world;
    float x1,y1,x2,y2;

    public Terrains02(int x, int y, int wight, int height){
        this.world = GameInfo.world;
        setX(x);
        setY(y);
        setWidth(wight * GameInfo.sizeTexture);
        setHeight(height * GameInfo.sizeTexture);
        createBody();
        configBounds();
    }

    public boolean isCornerRight(int currentX, int currentY){
        return isSameHight(currentY) && currentX == x1;
    }
    public boolean isCornerLeft(int currentX, int currentY){
        return isSameHight(currentY) && currentX == x2;
    }

    private boolean isSameHight(int currentY){
        return currentY > y1 && currentY < y2;
    }

    void configBounds(){
        x1 = x;
        y1 = y;
        x2 = x1 + (getWidth() - GameInfo.sizeTexture);
        y2 = y1 + (getHeight() - GameInfo.sizeTexture);
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(
                (getX() + (getWidth()/2f))/ GameInfo.PPM,
                (getY() + (getHeight()/2f))/ GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (getWidth()/2f) / GameInfo.PPM,
                (getHeight()/2f) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Terrain");

        shape.dispose();
    }
}
