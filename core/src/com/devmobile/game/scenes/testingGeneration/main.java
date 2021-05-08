package com.devmobile.game.scenes.testingGeneration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;

public class main implements Screen, InputProcessor {
    final DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;

    //Configuração do sprite sheet
    TextureAtlas textureAtlas;
    Sprite player;

    gameMap gameMap;

    class tile extends Rectangle {
        int walkable;
        int transparent;
        float alpha;
        String name;

        public tile (int walkable, int transparent, float alpha){
            this.walkable = walkable;
            this.transparent = transparent;
            this.alpha = alpha;
        }

        public tile (String string){
            if(string.equals("wall")){
                this.walkable = 0;
                this.transparent = 0;
                this.alpha = 1;
                name = string;
            }
            else if (string.equals("floor")){
                this.walkable = 1;
                this.transparent = 1;
                this.alpha = 0.2f;
                name = string;
            }
        }
    }

    class RectangularRoom{
        int x1,y1,x2,y2;
        public RectangularRoom(int x, int y, int widht, int height){
            this.x1 = x;
            this.y1 = y;
            this.x2 = x + widht;
            this.y2 = x + height;
        }

        public int[] getCenter(){
            int[] center = new int[2];
            center[0] = (x1 + x2)/2;
            center[1] = (y1 + y2)/2;

            return center;
        }

        public int[] getInner(){
            int[] innerXY = new int[4];
            innerXY[0] = x1 + 1;
            innerXY[1] = y1 + 1;
            innerXY[2] = x2 - 1;
            innerXY[3] = y2 - 1;

            return innerXY;
        }
    }

    class gameMap {
        tile[][] tiles;
        TextureAtlas.AtlasRegion wall, floor;

        Array level;

        public  gameMap (){
            tiles = new tile[GameInfo.WIDHT/10] [GameInfo.HEIGHT/10+1];
            wall = textureAtlas.findRegion("tile014");
            floor = textureAtlas.findRegion("tile003");

            startMap();

            RectangularRoom room_1 = new RectangularRoom(1, 1, 5, 10);
            RectangularRoom room_2 = new RectangularRoom(7, 3, 7, 12);

            changeRoom(room_1, "floor");
            changeRoom(room_2, "floor");
        }

        public void changeRoom(RectangularRoom room, String string){
            for (int x = room.x1 + 1; x < room.x2; x++) {
                for (int y = room.y1 + 1; y < room.y2; y++) {
                    tiles[x][y] = new tile(string);
                    tiles[x][y].setPosition(x * 10, y * 10);
                }
            }
        }

        public boolean in_bounds(int x, int y, int width, int height){
            return 0 <= x && x < width && 0 <= y && y < height;
        }

        public void startMap(){
            for (int i = 0; i < GameInfo.WIDHT/10; i++) {
                for (int x = 0; x < GameInfo.HEIGHT/10+1; x++) {
                    tiles[i][x] = new tile("wall");
                    tiles[i][x].setPosition(i * 10, x *10);
                }
            }
        }

        public void draw (Batch batch){
            for (int i = 0; i < GameInfo.WIDHT/10; i++) {
                for (int x = 0; x < GameInfo.HEIGHT/10 +1; x++) {
                    if(tiles[i][x].getY() < (mainCamera.position.y - GameInfo.HEIGHT/2f)){
                        for (int y = 0; y < GameInfo.WIDHT/10; y++) {
                            tiles[y][x].setY(tiles[y][x].getY() + GameInfo.HEIGHT);
                        }
                    }
                    if (tiles[i][x].getY() > (mainCamera.position.y + GameInfo.HEIGHT)){
                        tiles[i][x] = new tile("wall");
                    }
                    else if(tiles[i][x].name.equals("wall"))
                        batch.draw(wall, tiles[i][x].getX(), tiles[i][x].getY());
                    else if(tiles[i][x].name.equals("floor"))
                        batch.draw(floor, tiles[i][x].getX(), tiles[i][x].getY());
                }
            }
        }
    }

    public main (final DevMobile game){
        this.game = game;

        //Configuração da câmera
        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, GameInfo.WIDHT, GameInfo.HEIGHT);

        //Testando spite sheet
        textureAtlas = new TextureAtlas("sprites.txt");
        player = new Sprite(textureAtlas.createSprite("tile032")); //sprite do @
        player.setPosition(GameInfo.WIDHT/2f - player.getWidth(), GameInfo.HEIGHT/2f - player.getHeight());

        //Tiles
        gameMap = new gameMap();

        //Configuração do Input
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        //Configuração da câmera

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainCamera.position.y += 1;

        game.batch.begin();
        gameMap.draw(game.batch);
        player.draw(game.batch);
        game.batch.end();

        mainCamera.update();
        game.batch.setProjectionMatrix(mainCamera.combined);

    }

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
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.UP)
            player.setPosition(player.getX(), player.getY() + 10);
        else if(keycode == Input.Keys.DOWN)
            player.setPosition(player.getX(), player.getY() - 10);
        else if(keycode == Input.Keys.LEFT)
            player.setPosition(player.getX() - 10, player.getY());
        else if(keycode == Input.Keys.RIGHT)
            player.setPosition(player.getX() + 10, player.getY());

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
