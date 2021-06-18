package com.devmobile.game.objects.musics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class GenericMusic {
    Music music;

    public GenericMusic (String musicName){
        music = Gdx.audio.newMusic(Gdx.files.internal("Sons/" + musicName));
        music.setVolume(1);
        music.setLooping(true);
    }

    public void update(){
        if(music.isPlaying()){

        }
        else {
            music.play();
        }
    }

    public void stop(){
        music.stop();
    }
}
