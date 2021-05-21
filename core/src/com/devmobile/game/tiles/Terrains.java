package com.devmobile.game.tiles;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class Terrains extends Rectangle {
    private Body body;
    private World world;
    float x1,y1,x2,y2;

    public Terrains(int x, int y, int wight, int height){
        this.world = GameInfo.world;
        setX(x);
        setY(y);
        setWidth(wight * GameInfo.sizeTexture);
        setHeight(height * GameInfo.sizeTexture);
        createBody();
        configBounds();
    }

    public boolean isInsideX(int currentX){
        return currentX >= getX() && currentX <= (getX() + getWidth());
    }

    public boolean isCenter(int currentX, int currentY){
        return currentX >= (x1 + GameInfo.sizeTexture) &&
                currentX <= (x2 - GameInfo.sizeTexture) &&
                currentY >= y1 &&
                currentY <= y2 - GameInfo.sizeTexture;
    }

    public boolean isCornerRight(int currentX, int currentY){
        return currentX == x2 &&
                currentY == y2;
    }

    public boolean isCornerLeft(int currentX, int currentY){
        return currentX == x1 &&
                currentY == y2;
    }

    public boolean isUpColumn(int currentX, int currentY){
        return currentX >= (x1 + GameInfo.sizeTexture) &&
                currentX <= (x2 - GameInfo.sizeTexture) &&
                currentY == y2;
    }

    public boolean isFirstColumn(int currentX, int currentY){
        return currentX == x1 &&
                currentY <= y2 - GameInfo.sizeTexture;
    }

    public boolean isLastColumn(int currentX, int currentY){
        return currentX == x2 &&
                currentY <= y2 - GameInfo.sizeTexture;
    }

    void configBounds(){
        x1 = (body.getPosition().x * GameInfo.PPM) - getWidth()/2;
        x2 = (body.getPosition().y * GameInfo.PPM) - getHeight()/2;
        x2 = x1 + (getWidth() - GameInfo.sizeTexture);
        y2 = y1 + (getHeight() - GameInfo.sizeTexture);

//        x1 = getY();
//        y1 = getX();
//        x2 = x1 + (getWidth() - GameInfo.sizeTexture);
//        y2 = y1 + (getHeight() - GameInfo.sizeTexture);
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(
                (getX() + (getWidth()/2))/ GameInfo.PPM,
                (getY() + (getHeight()/2))/ GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (getWidth()/2) / GameInfo.PPM,
                (getHeight()/2) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Terrain");

        shape.dispose();
    }
}
