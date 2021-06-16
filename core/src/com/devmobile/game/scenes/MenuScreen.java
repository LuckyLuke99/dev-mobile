package com.devmobile.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.devmobile.game.DevMobile;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.ButtonsManager;
import com.devmobile.game.tiles.buttons.Exit;
import com.devmobile.game.tiles.buttons.Play;

public class MenuScreen implements Screen {
    DevMobile game;

    //Configuração da câmera
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    private TextureAtlas atlasMenu;
    private Skin skin, skinFundo;
    private Stage stage;
    private Table mainTable;
    private BitmapFont fonte;

    private Play buttonPlay;
    private Exit buttonExit;
    private ButtonsManager manager;

    public MenuScreen (final DevMobile game){
        this.game = game;

        manager = new ButtonsManager(game);
        stage = new Stage();

        mainTable = new Table(GameInfo.menuSkin);
        mainTable.setBounds(0, 0, Gdx.graphics.getWidth()*1.50f, Gdx.graphics.getHeight());

        fonte = GameInfo.criarFonte("FreePixel.ttf", 20);

        //Button Play
        buttonPlay = new Play(game, fonte, 6);
//
//        //Button Exit
        buttonExit = new Exit(game, fonte, 6);

        //Só adicionando
        mainTable.add(buttonPlay.getButton());
        mainTable.row();
        mainTable.add(buttonExit.getButton());
        mainTable.debug();
        stage.addActor(mainTable);
    }

    private BitmapFont criarFonte(String nomeFonte, int tamanho){
        FreeTypeFontGenerator.setMaxTextureSize(FreeTypeFontGenerator.NO_MAXIMUM);
        FreeTypeFontGenerator gerador = new FreeTypeFontGenerator(Gdx.files.internal("Font/" + nomeFonte));
        FreeTypeFontGenerator.FreeTypeFontParameter parametros = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parametros.size = tamanho;

        BitmapFont fonte = gerador.generateFont(parametros);
        gerador.dispose();

        return(fonte);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manager.configCamera();
        game.batch.begin();
        manager.draw();
        game.batch.end();
    }

    @Override
    public void dispose() {
        stage.dispose();
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
}
