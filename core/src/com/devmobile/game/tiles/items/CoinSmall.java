package com.devmobile.game.tiles.items;
import com.devmobile.game.helpers.GameInfo;

public class CoinSmall extends GenericCoin{
    public CoinSmall() {
        super(GameInfo.tileManager.getItems("Coin_Small"), 16, 16, 1);
    }
}
