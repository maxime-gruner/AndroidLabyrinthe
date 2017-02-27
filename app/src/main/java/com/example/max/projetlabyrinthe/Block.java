package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Paint;
import android.util.Log;


/**
 * Created by Max on 23/02/2017.
 */

public class Block {
    protected int x;
    protected int y;

    protected int height;
    protected int width;

    protected Rect hitbox ;

    public String TAG = "test";

    public Block(int x,int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitbox = new Rect(x,y,x+width,y+height);
    }

    public void draw(Canvas canvas, Paint p) {
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLUE);
        canvas.drawRect(hitbox, p);
        p.setStyle(Paint.Style.STROKE);
    }

    public boolean collide(Rect r){
        Rect tmp = new Rect(hitbox);
        return  tmp.intersect(r);
    }

    public synchronized boolean actionOnCollide(Bille bille){
        Log.d(TAG, "actionOnCollide: ");
        if ( bille.getRight().intersect(hitbox)) { //gauche du bloc
            Log.d(TAG, "update: GAUCHE");
            bille.setX(getLeft() - bille.getSize());
            bille.setxVelo(0);

        } else if ( bille.getLeft().intersect(hitbox)) { //droite du bloc
            Log.d(TAG, "update: DROITE");
            bille.setX(getRight());
            bille.setxVelo(0);

        }
        if (bille.getBottom().intersect(hitbox)) { //haut du bloc
            Log.d(TAG, "update: HAUT");
            bille.setY(getTop() - bille.getSize());
            bille.setyVelo(0);

        } else if ( bille.getTop().intersect(hitbox)) { //bas du bloc
            Log.d(TAG, "update: BAS");
            bille.setY(getBottom());
            bille.setyVelo(0);

        }
        return false;
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
        return y + height;
    }
}
