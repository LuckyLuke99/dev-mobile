package com.devmobile.game.tiles;

import com.devmobile.game.helpers.GameInfo;

public class Mountain {
    private int x, y, x2, y2;

    public Mountain(int x, int y, int wight, int height){
        this.x = x;
        this.y = y;
        this.x2 = x + (wight * GameInfo.sizeTexture);
        this.y2 = y + (height * GameInfo.sizeTexture);
        System.out.println(y2);
        System.out.println("Oiiii");
    }

    public void reset(int x, int y, int wight, int height){
        this.x = x;
        this.y = y;
        this.x2 = x + wight;
        this.y2 = y + height;
    }

    public boolean isBigger(int height){
        if(y2 > height)
            return true;
        else
            return false;
    }

    public boolean isHeightEqual(int height){
        if(y2 == height)
            return  true;
        else
            return false;
    }

    public int getY2(){
        return y2;
    }

    public int getX2(){
        return x2;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
