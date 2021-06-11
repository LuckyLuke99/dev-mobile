package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.ItemManager;
import com.devmobile.game.managers.MapManager;
import com.devmobile.game.managers.TileManager;
import com.devmobile.game.tiles.GenericCharacter;

import java.util.ArrayList;


public class GameScreen implements Screen, ContactListener, InputProcessor {
    final DevMobile game;

    public enum states {
        START,
        WAITING,
        RUNNING,
        END
    }

    private states currentState;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    //Configuração do Box2D
    private OrthographicCamera box2DCamera, UICamera;
    private Box2DDebugRenderer debugRenderer;
    private World world;

    //Managers, controlam oque acontece no jogo
    final MapManager mapManager; //Parte ligada a geração do conteúdo no mapa
    final TileManager tileManager; //Parte ligada as texturas dos tiles
    final ItemManager itemManager; //Parte ligada a manipulação dos items

    //Personagem
    GenericCharacter character;
    ArrayList<String> randomCharacter; // Nomes dos personagens dispóniveis
    int randomNum; // Número aleátoria que irá escolher qual vai ser o personagem pelo randomCharacter

    //------------------------------------------------------
    //---------METODOS-EXECUTADOS-AO-INICIALIZAR------------
    //------------------------------------------------------

    //Chamado ao iniciar essa tela
    public GameScreen (final DevMobile game){
        this.game = game;
        config();

        //Inicializando os managers
        tileManager = new TileManager();
        GameInfo.tileManager = tileManager;
        itemManager = new ItemManager();
        GameInfo.itemManager = itemManager;
        mapManager = new MapManager(tileManager);

        //Configuração da camera e do viewport da tela
        configCharacter();

        GameInfo.mainScore = 0;
        currentState = states.START;
    }

    //Sorteando um personagem e inicializando o personagem principal
    void configCharacter(){
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
        GameInfo.mainCharacter = character; // Passando o personagem principal para o
    }

    //Inicializando a mainCamera, box2DCamera, debugRenderer, world, InputProcessor e UI
    void config(){
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

        //Configuração da camera UI
        UICamera = new OrthographicCamera(GameInfo.WIDHT, GameInfo.HEIGHT);
        UICamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);

        //Criando o mundo e colocando gravidade nele da terra
        world = new World(new Vector2(0, -10), true);
        GameInfo.world = world;

        Gdx.input.setInputProcessor(this);
    }

    void reset(){
        //Resetando as câmeras
        mainCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);
        box2DCamera.position.set(GameInfo.WIDHT/2f, GameInfo.HEIGHT/2f, 0f);

        //Resetando o personagem
        randomNum = MathUtils.random(0, randomCharacter.size()-1);
        character = new GenericCharacter(tileManager.getCharacters(), randomCharacter.get(randomNum));
        GameInfo.mainCharacter = character;

        //Resetando o GameInfo
        GameInfo.mainScore = 0;

        itemManager.reset();
        mapManager.reset();
        character.ResetPosition();
    }

    //------------------------------------------------------
    //-----------METODOS-EXECUTADOS-A-CADA-FRAME------------
    //------------------------------------------------------

    void update(float dt){
        mapManager.update(mainCamera, character);
        character.update(mainCamera);

        //O personagem está morto caso o y seja menor que 0
        if(character.isDead()){
            reset();
        }
        itemManager.update();
        moveCamera();
    }

    void draw(){
        mapManager.draw(game.batch, mainCamera);
        character.drawAnimation(game.batch);
        itemManager.draw(game.batch);
    }

    void moveCamera(){
        mainCamera.position.x += GameInfo.velCamera * Gdx.graphics.getDeltaTime();
        UICamera.position.x += GameInfo.velCamera * Gdx.graphics.getDeltaTime();
    }

    void updateBodies(){
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        switch (currentState){
            case START:
                reset();
                currentState = states.WAITING;
                break;
            case WAITING:
                if(Gdx.input.isTouched()){
                    currentState = states.RUNNING;
                }
                break;
            case RUNNING:
                update(delta); // Atualiza todas os objetos
                break;
            case END:
                break;
        }
        //Atualizando todas as classes

        game.batch.begin();
        draw(); // Desenha todos os objetos
        game.batch.end();

        //Debug câmera só funciona com a camera parada
        //debugRenderer.render(world, box2DCamera.combined);

        world.step(1/60f, 6, 2);

        game.batch.setProjectionMatrix(mainCamera.combined);
        game.batch.setProjectionMatrix(UICamera.combined);

        mainCamera.update();
        UICamera.update();
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
        //Caso seja o lado esquerdo pular
        if(screenX < screenWidth/2f){
            character.Jump();
        }
        //Caso seja o lado direito usar o ataque
        else if (screenX > screenWidth/2f){
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

    //------------------------------------------------------
    //------------METODOS-OVERRIDE-NUNCA-USADOS-------------
    //------------------------------------------------------

    @Override
    public void show() {

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
