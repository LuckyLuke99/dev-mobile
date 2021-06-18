package com.devmobile.game.objects.buttons;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class GenericButton {
    protected TextButton button, buttonPause;
    TextButton.TextButtonStyle style;
    String tamanho = "";

    public GenericButton (Drawable skinUp, Drawable skinDown, BitmapFont fonte, int tamanho){
        style = new TextButton.TextButtonStyle();
        style.up = skinUp;
        style.down = skinDown;
        style.font = fonte;
        for (int i = 0; i < tamanho; i++) {
            this.tamanho += " ";
        }
        button = new TextButton(this.tamanho, style);
    }

    public GenericButton (Drawable skinUp, BitmapFont fonte, int tamanho){
        style = new TextButton.TextButtonStyle();
        style.up = skinUp;
        style.font = fonte;
        for (int i = 0; i < tamanho; i++) {
            this.tamanho += " ";
        }
        button = new TextButton(this.tamanho, style);
    }

    public GenericButton (String texto, BitmapFont fonte){
        style = new TextButton.TextButtonStyle();
        style.font = fonte;
        button = new TextButton(texto, style);
    }

    public TextButton getButton(){
        return button;
    }
}
