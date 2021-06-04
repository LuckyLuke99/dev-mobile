package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
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
import com.devmobile.game.managers.TileManager;
import com.devmobile.game.tiles.GenericCharacter;
import com.devmobile.game.tiles.GenericTile;
import com.devmobile.game.tiles.Terrains02;

import java.util.ArrayList;

public class GameScreen implements Screen, ContactListener, InputProcessor {
    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    final MapManager mapManager; //Parte que vai gerando o mapa do jogo
    final TileManager tileManager;

    GenericCharacter character;
    ArrayList<String> randomCharacter;

    //Configuração do Box2D
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;
    private World world;

    int randomNum;

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

        tileManager = new TileManager();
        mapManager = new MapManager(tileManager);

        randomCharacter = new ArrayList();
        randomCharacter.add("Holly");
        randomCharacter.add("Lil");
        randomCharacter.add("MrMan");
        //randomCharacter.add("MrMochi"); //Tá faltando o ataque
        //randomCharacter.add("Tommy"); //Tá faltando o ataque
        //randomCharacter.add("Twiggy"); //Tá faltando o ataque
        //Sorteando um número aleátorio para pegar o nome de um personagem
        randomNum = MathUtils.random(0, randomCharacter.size()-1);

        character = new GenericCharacter(tileManager.getCharacters(), randomCharacter.get(randomNum));
    }

    @Override
    public void show() {

    }

    void update(float dt){
        mapManager.update(mainCamera, character);
        character.update(mainCamera);
        moveCamera();
    }

    void draw(){
        mapManager.draw(game.batch, mainCamera);
        character.drawAnimation(game.batch);
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
        draw();
        game.batch.end();

        //debugRenderer.render(world, box2DCamera.combined);
        world.step(1/60f, 6, 2);

        game.batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();

        Gdx.input.setInputProcessor(this);
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float screenWidth = Gdx.graphics.getWidth();
        if(screenX < screenWidth/2f){
            System.out.println(screenX);
            character.Jump();
        }
        else if (screenX > screenWidth/2f){
            System.out.println(screenX);
            character.Attack();
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
