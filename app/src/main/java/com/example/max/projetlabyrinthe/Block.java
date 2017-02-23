package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.util.Log;


/**
 * Created by Max on 23/02/2017.
 */

public class Block {
    private int x;
    private int y;

    private int height = 70;
    private int width = 150;

    private Rect hitbox ;

    public Block(int x,int y){
        this.x = x;
        this.y = y;

        hitbox = new Rect(x,y,x+width,y+height);
    }

    public void draw(Canvas canvas, Paint p){
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(hitbox,p);
        p.setStyle(Paint.Style.STROKE);
    }

    public boolean collide(Rect r){
        Rect tmp = new Rect(hitbox);
        return  tmp.intersect(r);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLeft() {
        return x;
    }
    public int getRight(){
        return x + width;
    }
    public int getTop(){
        return y;
    }

    public int getBottom(){
        return y - height;
    }
}
