package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.MapManager;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Terrains02;

public class GameScreen implements Screen, ContactListener {
    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    MapManager mapManager; //Parte que vai gerando o mapa do jogo

    //Configuração do Box2D
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;
    private World world;

    public GameScreen (final DevMobile game){
        this.game = game;

        //Configuração da camera e do viewport da tela]
        mainCamera = new OrthographicCamera( GameInfo.WIDHT, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        gameViewport = new StretchViewport(GameInfo.WIDHT, GameInfo.HEIGHT, mainCamera);

        //Configuração do Box2D
        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDHT / GameInfo.PPM, GameInfo.HEIGHT / GameInfo.PPM);
        box2DCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);

        //Debug camera para o box2D
        debugRenderer = new Box2DDebugRenderer();

        //Criando o mundo e colocando gravidade nele da terra
        world = new World(new Vector2(0, -10), true);
        GameInfo.world = world;

        mapManager = new MapManager();
    }

    @Override
    public void show() {

    }

    void update(float dt){
        moveCamera();
        mapManager.update(mainCamera);
    }

    void moveCamera(){
        mainCamera.position.x += GameInfo.velCamera * Gdx.graphics.getDeltaTime();
    }

    void updateBodies(){
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Atualizando todas as classes
        update(delta);

        game.batch.begin();
        mapManager.draw(game.batch, mainCamera);
        game.batch.end();

        //debugRenderer.render(world, box2DCamera.combined);
        world.step(1/60f, 6, 2);

        game.batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
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
