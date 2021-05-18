//package com.devmobile.game.tiles;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//
//public class AddButton {
//    private Stage stage;
//    private TextureAtlas atlasMenu;
//    private Skin skin;
//    private Table mainTable;
//    private TextButton buttonPlay, buttonOptions;
//    private BitmapFont fonte;
//
//    public AddButton(Stage stage, TextureAtlas atlasMenu, Skin skin, Table mainTable, TextButton buttonPlay, TextButton buttonOptions, BitmapFont fonte) {
//        this.stage = stage;
//        this.atlasMenu = atlasMenu;
//        this.skin = skin;
//        this.mainTable = mainTable;
//        this.buttonPlay = buttonPlay;
//        this.buttonOptions = buttonOptions;
//        this.fonte = fonte;
//
//    }
//
//    stage = new Stage();
//
//        Gdx.input.setInputProcessor(stage);
//
//    atlasMenu = new TextureAtlas("UI_buttons.txt");
//    skin = new Skin(atlasMenu);
//
//    mainTable = new Table(skin);
//        mainTable.setBounds(0, 0,Gdx.graphics.getWidth()*1.50f, Gdx.graphics.getHeight());
//
//    fonte = criarFonte("FreePixel.ttf", 100);
//        fonte.getData().setScale(1f);]
//
//
//    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
//    TextButton.TextButtonStyle textButtonStyle2 = new TextButton.TextButtonStyle();
//    textButtonStyle.up = skin.getDrawable("play");
//    textButtonStyle.down = skin.getDrawable("play_pressed");
//    textButtonStyle.pressedOffsetX = 1;
//    textButtonStyle.pressedOffsetY = -1;
//    textButtonStyle.font = fonte;
//    textButtonStyle2.up = skin.getDrawable("options");
//    textButtonStyle2.down = skin.getDrawable("options_pressed");
//    textButtonStyle2.pressedOffsetX = 1;
//    textButtonStyle2.pressedOffsetY = -1;
//    textButtonStyle2.font = fonte;
//
//    buttonPlay = new TextButton("       ", textButtonStyle);
//    buttonOptions = new TextButton("       ", textButtonStyle2);
//
//        buttonOptions.addListener(new ClickListener(){
//        @Override
//        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//            Gdx.app.exit();
//            return super.touchDown(event, x, y, pointer, button);
//        }
//    };
//
//        mainTable.add(buttonPlay);
//        mainTable.row();
//        mainTable.add(buttonOptions);
//        mainTable.debug();
//        stage.addActor(mainTable);
//
//}
//
//
//    private BitmapFont criarFonte(String nomeFonte, int tamanho){
//        FreeTypeFontGenerator.setMaxTextureSize(FreeTypeFontGenerator.NO_MAXIMUM);
//        FreeTypeFontGenerator gerador = new FreeTypeFontGenerator(Gdx.files.internal("Font/" + nomeFonte));
//        FreeTypeFontGenerator.FreeTypeFontParameter parametros = new FreeTypeFontGenerator.FreeTypeFontParameter();
//        parametros.size = tamanho;
//
//        BitmapFont fonte = gerador.generateFont(parametros);
//        gerador.dispose();
//
//        return(fonte);
//    }
//}
