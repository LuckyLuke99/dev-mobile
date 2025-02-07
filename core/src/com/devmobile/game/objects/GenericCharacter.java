package com.devmobile.game.objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;

public class GenericCharacter extends Rectangle{
    private Animation attack, hurt, run, falling, jumping, projectile;
    private float animationSpeed, elapsedTime, damegeTime;
    private boolean isJumping, isRunning, isAttacking, isHurt, isFalling, canShoot, isDead, watingCamera;
    private String name;

    private Body body;
    private World world;

    int characterOffSetX;
    float MAX_VELOCITY;
    int health;

    public GenericCharacter (ObjectMap<String, Array<TextureAtlas.AtlasRegion>> animations, String name){
        this.name = name;
        world = GameInfo.world;

        MAX_VELOCITY = 600;

        setWidth(32);
        setHeight(32);

        setPosition(-GameInfo.WIDHT/2, GameInfo.HEIGHT/2);

        animationSpeed = 0.10f;
        elapsedTime = 0;
        damegeTime = 0;
        characterOffSetX = 15 * GameInfo.sizeTexture;

        health = 3;

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

        characterToCamera(camera);
        CheckStates(vel, pos, camera);

        if(pos.y < 0){
            isDead = true;
        }

        updatePostion();
    }

    public void drawAnimation (SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();
        //Muda a animação conforme o estado atual
        if(isHurt){
            batch.draw((TextureAtlas.AtlasRegion)hurt.getKeyFrame(elapsedTime), getX(), getY());
        }
        else if(isAttacking){
            batch.draw((TextureAtlas.AtlasRegion)attack.getKeyFrame(elapsedTime), getX(), getY());
        }
        else if(isJumping){
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

    private void CheckStates(Vector2 vel,Vector2 pos, Camera camera)
    {
        if(elapsedTime > 0.75 && isHurt && !(isAttacking)){
            isHurt = false;
            elapsedTime = 0;
        }

        //Verifica o tempo do attack
        if(elapsedTime > 0.7 && isAttacking && !(isHurt)){
            isAttacking = false;
            elapsedTime = 0;
        }

        //Personagem só segue a camera quando a posição dele for menor
        if(camera.position.x - characterOffSetX < pos.x * GameInfo.PPM){
            watingCamera = true;
        }
        else {
            watingCamera = false;
        }

        //Verifica se está pulando ou caindo
        if(vel.y < 0 && isJumping){
            isFalling = true;
        }
        else if(vel.y > 0.01f && !(isHurt)){
            isJumping = true;
        }
        else {
            isJumping = false;
            isFalling = false;
        }
    }

    public void ResetPosition(){
        body.setTransform(body.getPosition().x, (GameInfo.HEIGHT/2f) / GameInfo.PPM, 0f);
        isRunning = true;
        isJumping = false;
        isFalling = false;
        isAttacking = false;
        isHurt = false;
        isDead = false;
        animationSpeed = 0.10f;
        elapsedTime = 0;
    }

    public boolean isDead(){
        return isDead;
    }

    public boolean isAttacking (){
        return isAttacking;
    }

    public void Hurt(float damage){
        Vector2 pos = body.getPosition();
        if(!(isHurt)){
            health -= damage;
            if(health <= 0){
                isDead = true;
            }
            else {
                isHurt = true;
                elapsedTime = 0;
                body.applyLinearImpulse(0.2f, 0f, pos.x, pos.y, true);
            }
        }
    }

    public void Attack(){
        Vector2 pos = body.getPosition();
        if(!(isAttacking) && !(watingCamera)){
            body.applyLinearImpulse(0.3f, 0, pos.x, pos.y, true);
            elapsedTime = 0;
            isAttacking = true;
        }
    }

    public void Jump(){
        Vector2 pos = body.getPosition();
        if(isJumping){
            body.applyLinearImpulse(0f, -0.5f, pos.x, pos.y, true);
        }
        else {
            if(!(isFalling)){
                body.applyLinearImpulse(0f, 0.5f, pos.x, pos.y, true);
                isJumping = true;
            }
        }
    }

    private void characterToCamera(Camera camera){
        Vector2 pos = body.getPosition();
        //Centraliza o personagem baseado na câmera
        if(!(isHurt) && camera.position.x - characterOffSetX > getX() + 32){
            body.setTransform(pos.x + 0.06f, pos.y, 0f);
        }
        else if(!(watingCamera) && !(isAttacking) && !(isHurt)){
            body.setTransform(((camera.position.x - characterOffSetX) / GameInfo.PPM), pos.y, 0f);
        }
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
