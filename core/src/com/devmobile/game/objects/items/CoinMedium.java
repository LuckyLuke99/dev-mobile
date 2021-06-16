package com.devmobile.game.objects.items;
import com.devmobile.game.helpers.GameInfo;

public class CoinMedium extends GenericCoin{
    public CoinMedium(){
        super(GameInfo.tileManager.getItems("Coin_Medium"),true, 16, 16, 10);
    }
}
