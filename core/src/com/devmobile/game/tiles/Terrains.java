package com.devmobile.game.tiles;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class Terrains {
    private float x, y, x2, y2;
    private Body body;
    private World world;


    public Terrains(int x, int y, int wight, int height){
        this.world = GameInfo.world;
        this.x = x;
        this.y = y;
        this.x2 = x + (wight * GameInfo.sizeTexture);
        this.y2 = y + (height * GameInfo.sizeTexture);

        createBody();
    }

    public boolean isOnBounds(int currentX, int currentY){
        if(currentX >= x && currentX <= x2 && currentY >= y && currentY <= y2){
            return true;
        }
        return false;
    }

    public void setY2 (float y2){
        this.y2 = y2;
    }

    public void setY (float y){
        this.y = y;
    }

    public void setX2 (float x2){
        this.x2 = x2;
    }

    public void setX (float x){
        this.x = x;
    }

    public float getY2(){
        return y2;
    }

    public float getX2(){
        return x2;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(
                x / GameInfo.PPM,
                y / GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (x2 + 16) / GameInfo.PPM,
                (y2 + 16) / GameInfo.PPM);

        body.createFixture(shape, 0f);

//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//        fixtureDef.density = 1f;
//        Fixture fixture = body.createFixture(fixtureDef);
//        fixture.setUserData("Terrain");

        shape.dispose();
    }
}
