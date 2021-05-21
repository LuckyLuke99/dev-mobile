package com.devmobile.game.tiles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.sun.tools.javac.util.Context;

import java.util.ArrayList;

public class GenericCharacter extends  Rectangle{
    private Animation attack, hurt, run, falling, jumping, projectile;
    private float animationSpeed, elapsedTime;
    private int groundY;
    private boolean isJumping, isRunning, isAttacking, isHurt, isFalling, canShoot, isDead;
    private String name;

    private Body body;
    private World world;

    float MAX_VELOCITY;

    public GenericCharacter (ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations, String name){
        this.name = name;
        world = GameInfo.world;

        MAX_VELOCITY = 600;

        setWidth(32);
        setHeight(32);

        setPosition(GameInfo.WIDHT/2, GameInfo.HEIGHT/2);

        animationSpeed = 0.10f;
        elapsedTime = 0;
        isRunning = true;
        isFalling = false;

        configAnimations(animations);
        createBody();
    }

    public void update (OrthographicCamera camera){
        Vector2 pos, vel;
        vel = body.getLinearVelocity();
        pos = body.getPosition();
        setX(camera.position.x);
        if(isRunning){
            //body.setTransform((camera.position.x / GameInfo.PPM), pos.y, body.getAngle());
        }

        if(Gdx.input.isTouched()){
            body.applyLinearImpulse(0.08f, 0.08f, pos.x, pos.y, true);
        }

//        if (isFalling){
//            acel = -10;
//            vel += acel * Gdx.graphics.getDeltaTime();
//            deltaS = vel * Gdx.graphics.getDeltaTime();
//            setY(getY() + deltaS);
//        }
//        else if(isJumping){
//            acel = 600;
//            vel += acel * Gdx.graphics.getDeltaTime();
//            deltaS = vel * Gdx.graphics.getDeltaTime();
//            setY(getY() + deltaS);
//            if(vel > 300){
//                vel = 0;
//                isJumping = false;
//                isFalling = true;
//            }
//        }
        updatePostion();
        camera.position.x = getX();
    }

    public void drawAnimation (SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isRunning){

        }
        else if(isJumping){

        }
        else if(isAttacking){
            if(canShoot){

            }
            else {

            }
        }
        else if(isHurt){

        }
        else if(isFalling){

        }
        batch.draw((TextureAtlas.AtlasRegion)run.getKeyFrame(elapsedTime), getX(), getY());
    }

    public boolean isJumping(){
        return isJumping;
    }

    //Configura as animações de acordo com o nome passado no começo
    private void configAnimations(ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations){
        for(String key : animations.keys()){
            if((name + "_attack").equals(key)){
                attack = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_hurt").equals(key)){
                hurt = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_run").equals(key)){
                run = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_falling").equals(key)){
                falling = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_jumping").equals(key)){
                jumping = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
            else if((name + "_projectile").equals(key)){
                projectile = new Animation<TextureAtlas.AtlasRegion>(animationSpeed, animations.get(key), Animation.PlayMode.LOOP);
            }
        }
    }

    private void updatePostion(){
        //É preciso multiplicar a posição pelo PPM
        setX((body.getPosition().x * GameInfo.PPM) - getWidth() / 2f);
        setY((body.getPosition().y * GameInfo.PPM) - getHeight() / 2f);
    }

    private void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(
                (getX() + (getWidth()/2)) / GameInfo.PPM,
                (getY() + (getHeight()/2)) / GameInfo.PPM
        );

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(
                (getWidth()/2) / GameInfo.PPM,
                (getHeight()/2) / GameInfo.PPM
        );

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Player");

        shape.dispose();
    }
}
