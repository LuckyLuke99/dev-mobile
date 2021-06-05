package com.devmobile.game.tiles.items;
import com.devmobile.game.helpers.GameInfo;

public class CoinLarger extends GenericCoin{
    public CoinLarger() {
        super(GameInfo.tileManager.getItems("Coin_Larger"), 16, 16, 100);
        setPlaying(false);
    }
}
