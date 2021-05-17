package com.devmobile.game.tiles;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.devmobile.game.helpers.GameInfo;

public class BG extends GenericTile{

    public BG(TextureAtlas.AtlasRegion texture) {
        super(texture);
        setWidth(GameInfo.WIDHT);
        setHeight(GameInfo.HEIGHT);
    }

    //Verifica se o tile está fora dos limites
    public boolean isOutBounds (OrthographicCamera camera){
        if(getX() + getWidth() + getWidth()/2 < camera.position.x)
            return true;
        return false;
    }
    public TextureAtlas.AtlasRegion getTexture (){
        return this.texture;
    }
}
