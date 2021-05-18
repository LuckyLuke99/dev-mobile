package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.MapManager;
import com.devmobile.game.tiles.Cloud;
import com.devmobile.game.tiles.Player;

public class GameScreen implements Screen, ContactListener {
    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    private World world;
    private Box2DDebugRenderer debugRenderer;

    private Player player;

    MapManager mapManager; //Parte que vai gerando o mapa do jogo

    public GameScreen (final DevMobile game){
        this.game = game;

        //Configuração da camera e do viewport da tela
        mainCamera = new OrthographicCamera();
       // mainCamera.setToOrtho(false, GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.setToOrtho(
                false,
                GameInfo.WIDHT / GameInfo.PPM,
                GameInfo.HEIGHT / GameInfo.PPM
        );
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        //gameViewport = new FitViewport(GameInfo.WIDHT, GameInfo.HEIGHT, mainCamera);

        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(
                0,
                -9.8f
        ), true);
        world.setContactListener(this);

        mapManager = new MapManager(world);

        player = new Player(
                world,
                "Player 1.png",
                GameInfo.WIDHT / 2f,
                GameInfo.HEIGHT / 2f
        );
        Cloud cloud = new Cloud(world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.getBody().applyLinearImpulse(
                    new Vector2(0.1f,0),
                    player.getBody().getWorldCenter(),
                    true
            );
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.getBody().applyLinearImpulse(
                    new Vector2(-0.1f, 0),
                    player.getBody().getWorldCenter(),
                    true
            );
        }
        //mainCamera.update();
        //game.batch.setProjectionMatrix(mainCamera.combined);
       //mainCamera.position.x += GameInfo.velCamera * GameInfo.deltaTime;

        GameInfo.deltaTime = Gdx.graphics.getDeltaTime();
        //Atualizando todas as classes
        mapManager.update(mainCamera);

        game.batch.begin();
        mapManager.draw(game.batch, mainCamera);
        game.batch.draw(player, player.getX(), player.getY() - player.getHeight() / 2f);
        game.batch.end();

        debugRenderer.render(world, mainCamera.combined);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
