package com.devmobile.game.objects.buttons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.devmobile.game.helpers.GameInfo;

public class Timer {
    private GenericButton timer;
    private int timeMin, timeSeg;
    private String time;

    public Timer(String string, BitmapFont font){
        timer = new GenericButton(string, font);
    }

    public Timer(BitmapFont font){
        time = "00:00";
        timer = new GenericButton(time, font);
    }

    public void update(){
        timeSeg = ((int) GameInfo.runningTime)%60;
        timeMin = ((int) GameInfo.runningTime)/60;
        time = convertTime();
        timer.getButton().setText(time);
    }

    public Button getButton(){
        return timer.getButton();
    }

    private String convertTime(){
        return String.format("%02d:%02d", timeMin, timeSeg);
    }
}
