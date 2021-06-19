package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.items.coins.CoinLarger;
import com.devmobile.game.objects.items.coins.CoinMedium;
import com.devmobile.game.objects.items.coins.CoinSmall;
import com.devmobile.game.objects.items.GenericItem;
import com.devmobile.game.objects.musics.GenericSom;

public class ItemManager {
    private Array<GenericItem> items; //Guarda todos os items gerados até aquele momento
    private ObjectMap<String, Integer> itemsTop; // Guarda o nome dos items que podem ser gerados na regiao de cima
    private ObjectMap<String, Integer> itemsDown; // Guarda o nome dos items que podem ser gerados na regiao de baixo

    //Sounds
    private GenericSom coinSound;

    public ItemManager (){
        coinSound = new GenericSom("coin.wav", 0.01f, false);
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
                item.draw(batch);
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
                coinSound.play();
            }
        }
    }

    //Criar novos item de acordo com a posição passada e o tamanho
    public void itemGeneration(int x, int y, int width){
        int num = MathUtils.random(0, 100);
        if(GameInfo.coinChance >= num){
            int _width = MathUtils.random(3, width);
            String itemType;
            if(y >= GameInfo.topGroundMinPosition * GameInfo.sizeTexture){
                itemType = getRandomName(itemsTop);
            }
            else {
                itemType = getRandomName(itemsDown);
            }
            int nextCoin = x;
            GenericItem coin = null;

            for(int i = 0; i < width; i++){
                switch (itemType){
                    case "Coin_Small":
                        coin = new CoinSmall();
                        break;
                    case  "Coin_Medium":
                        coin = new CoinMedium();
                        break;
                    case "Coin_Larger":
                        coin = new CoinLarger();
                        nextCoin += (((width - 1) * GameInfo.sizeTexture) / 2) - GameInfo.sizeTexture;
                        i = width;
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
    public String getRandomName(ObjectMap<String, Integer> items){
        float num = 0f;
        String name = "";
        for (String key : items.keys()){
            float randomNum = MathUtils.random(0f, 1f);
            randomNum *= items.get(key);
            if(randomNum > num){
                num = randomNum;
                name = key;
            }
        }
        return name;
    }

    //Adiciona os nomes dos items e suas chances
    private void config (){
        itemsTop = new ObjectMap<>();
        itemsTop.put("Coin_Medium", GameInfo.coinMediumChance);
        itemsTop.put("Coin_Larger", GameInfo.coinLargerChance);

        itemsDown = new ObjectMap<>();
        itemsDown.put("Coin_Small", GameInfo.coinSmallChance);
        itemsDown.put("Coin_Medium", GameInfo.coinMediumChance);
    }
}
