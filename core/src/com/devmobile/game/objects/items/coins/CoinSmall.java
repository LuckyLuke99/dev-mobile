package com.devmobile.game.objects.items.coins;
import com.devmobile.game.helpers.GameInfo;

public class CoinSmall extends GenericCoin{
    public CoinSmall() {
        super(GameInfo.tileManager.getItems("Coin_Small"),true,16, 16, 1);
    }
}
