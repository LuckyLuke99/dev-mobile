package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.items.GenericItem;

public class ItemManager {
    private Array<GenericItem> items; //Guarda o nome dos items com a chance
    private ObjectMap<String, Integer> allNames;

    public ItemManager (){
        reset();
        config();
    }

    public void update(){
        checkItems();
    }

    public void reset(){
        items = new Array<>();
    }

    public void  draw(SpriteBatch batch){
        for(int i = 0; i < items.size; i++){
            GenericItem item = items.get(i);
            if(item.getDead()){
                items.removeIndex(i);
            }
            else {
                item.drawAnimation(batch);
            }
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

    public String getRandomName(){
        float num = 0f;
        String name = "";
        for (String key : allNames.keys()){
            float randomNum = MathUtils.random(0f, 1f);
            randomNum *= allNames.get(key);
            if(randomNum > num){
                num = randomNum;
                name = key;
            }
        }
        return name;
    }

    private void config (){
        allNames = new ObjectMap<>();
        allNames.put("Coin_Small", GameInfo.coinSmallChance);
        allNames.put("Coin_Medium", GameInfo.coinMediumChance);
        allNames.put("Coin_Larger", GameInfo.coinLargerChance);
    }
}
