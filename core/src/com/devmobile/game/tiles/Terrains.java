package com.devmobile.game.tiles;

import com.devmobile.game.helpers.GameInfo;

public class Terrains {
    private int x, y, x2, y2, type;

    public Terrains(int x, int y, int wight, int height, int type){
        this.type = type;
        this.x = x;
        this.y = y;
        this.x2 = x + (wight * GameInfo.sizeTexture);
        this.y2 = y + (height * GameInfo.sizeTexture);
    }

    public boolean isOnBounds(int currentX, int currentY){
        if(currentX >= x && currentX <= x2 && currentY >= y && currentY <= y2){
            return true;
        }
        return false;
    }

    public void setY2 (int y2){
        this.y2 = y2;
    }

    public void setY (int y){
        this.y = y;
    }

    public void setX2 (int x2){
        this.x2 = x2;
    }

    public void setX (int x){
        this.x = x;
    }

    public int getType(){
        return type;
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
