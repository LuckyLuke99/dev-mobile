package com.devmobile.game.tiles;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.devmobile.game.helpers.GameInfo;

public class Terrains02 {
    Body body;
    World world;
    private int x, y, x2, y2;

    public Terrains02(int x, int y, int wight, int height){
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

    public void setY2 (int y2){
        this.y2 = y2;
    }

    public void setY (int y){
        this.y = y;
    }

    public void setX2 (int x2){
        this.x2 = x2;
    }

    public void setX (int x){
        this.x = x;
    }

    public int getY2(){
        return y2;
    }

    public int getX2(){
        return x2;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(
                x / GameInfo.PPM,
                (y + 200) / GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (x2 / 2f) / GameInfo.PPM,
                (y2 / 2f) / GameInfo.PPM
        );
        body.createFixture(shape, 0f);

//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//        fixtureDef.density = 1f;
//        Fixture fixture = body.createFixture(fixtureDef);
//        fixture.setUserData("Terrain");

        shape.dispose();
    }
}
