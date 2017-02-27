package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import java.util.Collection;
import java.util.List;

/**
 * Created by Max on 20/02/2017.
 */

public class Bille {
    private float x; //position
    private float y;

    private int size = 50; ///Taille de la bille
    private int mass = 50;

    private float xVelo = 0; //vitesse actuelle de chaque axe
    private float yVelo = 0;

    private Rect hitbox; //servira pour les collision

    private final float velocityLimit = 50; //vitesse limite

    static String TAG ="TEST";

    public Bille(int spawnX,int spawnY){

        x = spawnX;
        y = spawnY;
        hitbox = new Rect((int)x,(int)y,(int)x+size,(int)y+size);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public synchronized boolean update(float time, List<Block> blockList, Block arrival, int  screenWidth, int screenHeight){ //appliquera le mouvemement selon la vitesse, et les collisions, devra prendre une liste de block

        float xS = 0;
        float yS = 0;

        for(Block block : blockList) {
            if (block.collide(hitbox)) {
                if (block.actionOnCollide(this)){
                    return true;
                }
            }else{
                xS = (xVelo/2)*time;
                yS = (yVelo/2)*time;
            }

        }



        x -= xS;
        y -= yS;
        hitbox.offsetTo( (int)x, (int)y ); //deplace la hitbox

        if (x > screenWidth) { //limite du jeu (jusrte pour tester)
            x = screenWidth;
            xVelo = 0;
        } else if (x < 0) {
            xVelo = 0;
            x = 0;
        }
        if (y > screenHeight) { //limite du jeu (jusrte pour tester)
            y = screenHeight;
            yVelo = 0;
        } else if (y < 0) {
            yVelo = 0;
            y = 0;
        }
        return false;
    }

    public synchronized void changeVelocity(float[] values, float time){ 
        xVelo += (1*(values[0]*mass)*time) /2;
        yVelo += (-1*(values[1]*mass)*time)/2;

        if(xVelo > velocityLimit) //test des limite
            xVelo = velocityLimit;
        if(xVelo < (-velocityLimit)) xVelo=-velocityLimit;
        if(yVelo > velocityLimit )
            yVelo = velocityLimit;
        if(yVelo < (-velocityLimit)) yVelo=-velocityLimit;
    }



    public void draw(Canvas canvas,Paint p){
        p.setStrokeWidth(5);
        p.setColor(Color.BLUE);
        canvas.drawRect(hitbox,p);

        p.setColor(Color.RED);
        canvas.drawRect(getLeft(),p);
        canvas.drawRect(getRight(),p);
        canvas.drawRect(getBottom(),p);
        canvas.drawRect(getTop(),p);

    }

    public int getSize() {
        return size;
    }

    public float getxVelo() {
        return xVelo;
    }

    public void setxVelo(float xVelo) {
        this.xVelo = xVelo;
    }

    public float getyVelo() {
        return yVelo;
    }

    public void setyVelo(float yVelo) {
        this.yVelo = yVelo;
    }



    public Rect getTop(){
        int rX = (int)x+10;
        int rY = (int) y;
        return new Rect(rX,rY,rX+size-20,rY+ 5);
    }

    public Rect getBottom(){
        int rX = (int)x+10;
        int rY = (int)y+size-5;
        return new Rect(rX,rY,rX+size-20,rY+5);
    }
    public Rect getLeft() {
        int rX = (int)x;
        int rY = (int)y+10;
        return new Rect(rX,rY,rX+5,rY + size -20);
    }
    public Rect getRight(){
        int rX = (int)x+size-5;
        int rY = (int)y+10;
        return new Rect(rX,rY,rX+5,rY+size-20) ;
    }
}
