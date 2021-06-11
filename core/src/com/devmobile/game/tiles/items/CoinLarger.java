package com.devmobile.game.tiles.items;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.devmobile.game.helpers.GameInfo;

public class CoinLarger extends GenericCoin{
    float animMaxTime;
    public CoinLarger() {
        super(GameInfo.tileManager.getItems("Coin_Larger"),false, 16, 16, 100);
        setPlaying(false);
        animMaxTime = 0.7f; // 3 (quantidade de frames) * 0.15f (velocidade padrão da animação) = 0.45f
    }

    @Override
    //Mudando o drawAnimation para verificar o tempo da animação é caso seja maior mudar o isDead para true
    public void drawAnimation(SpriteBatch batch) {
        if(!(isDead)){
            if(isPlaying){
                elapsedTime += Gdx.graphics.getDeltaTime();
                batch.draw((TextureAtlas.AtlasRegion)animation.getKeyFrame(elapsedTime), getX(), getY());
                if(animMaxTime <= elapsedTime) setDead(true);
            }
            else {
                elapsedTime = 0;
                batch.draw((TextureAtlas.AtlasRegion)animation.getKeyFrame(elapsedTime), getX(), getY());
            }
        }
    }

    @Override
    //Mudando o use para não alterar o isDead mas sim o isPlaying
    public void use() {
        if(isUsable){
            GameInfo.mainScore += value;
            System.out.println(GameInfo.mainScore);
            setUsable(false);
            setPlaying(true);
        }
    }
}
