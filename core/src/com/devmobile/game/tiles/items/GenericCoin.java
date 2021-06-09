package com.devmobile.game.tiles.items;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.helpers.GameInfo;

public class GenericCoin extends GenericItem{
    float value;
    boolean isUsable;

    public GenericCoin(Array<TextureAtlas.AtlasRegion> animation, int width, int height, float value) {
        super(animation, width, height);
        this.value = value;
    }

    public GenericCoin(Array<TextureAtlas.AtlasRegion> animation, float animSpeed, int width, int height, float value) {
        super(animation, width, height);
        this.animationSpeed = animSpeed;
        this.value = value;
    }

    @Override
    public void use() {
        if(isUsable){
            GameInfo.mainScore += value;
        }
    }

    public boolean isUsable(){
        return isUsable;
    }
}
