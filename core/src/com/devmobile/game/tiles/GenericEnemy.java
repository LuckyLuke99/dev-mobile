package com.devmobile.game.tiles;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Rectangle;

public class GenericEnemy extends Rectangle {
    Animation<TextureRegion> animation;
    public GenericEnemy (TextureAtlas.AtlasRegion atlasRegion){
        for (String name : atlasRegion.names){
            System.out.println(name);
        }
    }
}
