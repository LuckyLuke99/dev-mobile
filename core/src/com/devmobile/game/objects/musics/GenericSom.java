package com.devmobile.game.objects.musics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.devmobile.game.helpers.GameInfo;

public class GenericSom {
    private Sound sound;
    private float volume;
    private float currentVolume;
    private float maxWaitTime;
    private float elapsedTime;

    public GenericSom (String soundName, float volume, boolean isLooping){
        sound = Gdx.audio.newSound(Gdx.files.internal("Sons/" + soundName));
        this.volume = volume;
        maxWaitTime = 0.2f;
        elapsedTime = 0;
    }
    public void play (){
        if(GameInfo.runningTime - elapsedTime < maxWaitTime){
            elapsedTime = GameInfo.runningTime;
            if(currentVolume < 1f){
                currentVolume += volume;
            }
            else {
                currentVolume = 1f;
            }
        }
        else {
            currentVolume = volume;
            elapsedTime = GameInfo.runningTime;
        }
        sound.play(currentVolume);
    }
}
