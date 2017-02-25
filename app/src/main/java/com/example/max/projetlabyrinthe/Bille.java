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

    private float xVelo = 0; //vitesse actuelle de chaque axe
    private float yVelo = 0;

    private Rect hitbox; //servira pour les collision

    private final float velocityLimit = 40; //vitesse limite


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

    public void update(float time, List<Block> blockList,int  screenWidth, int screenHeight){ //appliquera le mouvemement selon la vitesse, et les collisions, devra prendre une liste de block

        float xS = 0;
        float yS = 0;
        for(Block block : blockList) {
            if (block.collide(hitbox)) {
                if (x + size >= block.getLeft() && xVelo < 0) { //gauche du bloc
                    xVelo = 0;
                } else if (x <= block.getRight() && xVelo > 0) { //droite du bloc
                    xVelo = 0;
                }
                if (y <= block.getTop() && yVelo < 0) { //haut du bloc
                    yVelo = 0;
                } else if (y - size >= block.getBottom() && yVelo > 0) { //bas du bloc
                    yVelo = 0;
                }
            }
        }
        xS = (xVelo/2)*time;
        yS = (yVelo/2)*time;

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

    }

    public void changeVelocity(float[] values, float time){ //change les valeur x velo par rapport a l accelrometre
        xVelo += (1*(values[0]*5)*time) /2; //ici 5 serait plus ou moins le poids de la bille, peut etre a changer les deplacement seront plus facile
        yVelo += (-1*(values[1]*5)*time)/2;

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


    }

}
