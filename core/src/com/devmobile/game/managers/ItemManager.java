package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.tiles.items.GenericItem;

public class ItemManager {
    private Array<GenericItem> items;

    public ItemManager (){
        items = new Array<>();
    }

    public void update(){
        checkItems();
    }

    public void  draw(SpriteBatch batch){
        for(GenericItem item : items){
            item.drawAnimation(batch);
        }
    }

    public void add(GenericItem item){
        items.add(item);
    }

    private void checkItems(){
        for(GenericItem item : items){
            if(item.checkCollision(GameInfo.mainCharacter)){
                item.use();
            }
        }
    }
}
