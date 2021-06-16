package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.items.CoinLarger;
import com.devmobile.game.objects.items.CoinMedium;
import com.devmobile.game.objects.items.CoinSmall;
import com.devmobile.game.objects.items.GenericItem;

public class ItemManager {
    private Array<GenericItem> items; //Guarda o nome dos items com a chance
    private ObjectMap<String, Integer> allNames;

    public ItemManager (){
        reset();
        config();
    }

    //Atualiza todos os items
    public void update(){
        checkItems();
    }

    //Retira dos os items do array
    public void reset(){
        items = new Array<>();
    }

    //Desenha todos os items no array e caso ele tiver sido usado retira ele do array
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

    //Adiciona um item no array de items
    public void add(GenericItem item){
        items.add(item);
    }

    //Verifica se o jogador está colidindo com um item
    private void checkItems(){
        for(GenericItem item : items){
            if(item.checkCollision(GameInfo.mainCharacter)){
                item.use();
            }
        }
    }

    //Criar novos item de acordo com a posição passada e o tamanho
    public void itemGeneration(int x, int y, int width){
        int num = MathUtils.random(0, 100);
        if(GameInfo.coinChance >= num){
            int _width = MathUtils.random(3, width);
            String itemType = getRandomName();
            int nextCoin = x;
            GenericItem coin = null;

            for(int i = 0; i < _width; i++){
                switch (itemType){
                    case "Coin_Small":
                        coin = new CoinSmall();
                        break;
                    case  "Coin_Medium":
                        coin = new CoinMedium();
                        break;
                    case "Coin_Larger":
                        coin = new CoinLarger();
                        nextCoin += _width/2;
                        i = _width;
                        break;
                }

                if (coin != null) {
                    coin.setPosition(nextCoin, y);
                    nextCoin += coin.width;
                    GameInfo.itemManager.add(coin);
                }
            }
        }
    }

    //Retorna um nome aleátorio baseado na chance no GameInfo
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

    //Adiciona os nomes dos items e suas chances
    private void config (){
        allNames = new ObjectMap<>();
        allNames.put("Coin_Small", GameInfo.coinSmallChance);
        allNames.put("Coin_Medium", GameInfo.coinMediumChance);
        allNames.put("Coin_Larger", GameInfo.coinLargerChance);
    }
}
