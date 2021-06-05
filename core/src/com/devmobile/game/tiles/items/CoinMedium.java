package com.devmobile.game.tiles.items;
import com.devmobile.game.helpers.GameInfo;

public class CoinMedium extends GenericCoin{
    public CoinMedium(){
        super(GameInfo.tileManager.getItems("Coin_Medium"), 16, 16, 10);
    }
}
