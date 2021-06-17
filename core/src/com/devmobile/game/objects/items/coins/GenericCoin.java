package com.devmobile.game.objects.items.coins;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.items.GenericItem;
import com.devmobile.game.objects.musics.GenericSom;

public class GenericCoin extends GenericItem {
    float value;
    boolean isUsable;

    public GenericCoin(Array<TextureAtlas.AtlasRegion> animation,Boolean isLooping, int width, int height, float value) {
        super(animation, isLooping,  width, height);
        this.value = value;
        isUsable = true;
    }

    public GenericCoin(Array<TextureAtlas.AtlasRegion> animation, float animSpeed, Boolean isLooping, int width, int height, float value) {
        super(animation, isLooping, width, height);
        this.animationSpeed = animSpeed;
        this.value = value;
    }

    @Override
    public void use() {
        if(isUsable){
            GameInfo.mainScore += value;
            System.out.println(GameInfo.mainScore);
            setUsable(false);
            setDead(true);
        }
    }

    public boolean isUsable(){
        return isUsable;
    }

    public void setUsable(Boolean b){
        isUsable = b;
    }
}
