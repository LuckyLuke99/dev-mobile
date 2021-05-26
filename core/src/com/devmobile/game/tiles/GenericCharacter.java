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
        isJumping = false;
        isFalling = false;
        isAttacking = false;
        isHurt = false;
        isDead = false;

        configAnimations(animations);
        createBody();
    }

    public void update (OrthographicCamera camera){
        body.setAwake(true);

        Vector2 pos, vel;
        vel = body.getLinearVelocity();
        pos = body.getPosition();

        body.setTransform((camera.position.x / GameInfo.PPM), pos.y, 0f);

        if(Gdx.input.isTouched()){
            if(!(isJumping) && !(isFalling)){
                body.applyLinearImpulse(0f, 0.3f, pos.x, pos.y, true);
                isJumping = true;
            }
        }

        //Controlando as variaveis de animação
        if(vel.y < 0 && isJumping){
            isFalling = true;
        }
        else if(vel.y > 0.01f){
            isJumping = true;
        }
        else {
            isJumping = false;
            isFalling = false;
        }

        if(pos.y < 0 || pos.y > GameInfo.HEIGHT * GameInfo.PPM){
            body.setTransform(body.getPosition().x, GameInfo.HEIGHT/ 2f /GameInfo.PPM, pos.y);
        }

        updatePostion();
    }

    public void drawAnimation (SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isJumping){
            if(isFalling){
                batch.draw((TextureAtlas.AtlasRegion)falling.getKeyFrame(elapsedTime), getX(), getY());
            }
            else {
                batch.draw((TextureAtlas.AtlasRegion)jumping.getKeyFrame(elapsedTime), getX(), getY());
            }
        }
        else {
            batch.draw((TextureAtlas.AtlasRegion)run.getKeyFrame(elapsedTime), getX(), getY());
        }
    }

    public boolean isJumping(){
        if(body.getAngularVelocity() > 1){
            return true;
        }
        return false;
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
