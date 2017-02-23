package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Max on 22/02/2017.
 */

public class Game {

    Bille bille;
    Block block;

    int height;
    int width;

    float time = 0.20f;

    float aX;
    float aY;

    public Game(int w,int h){
        this.height = h;
        this.width = w;
        bille = new Bille(100,100);

        block= new Block(200,200); //a changer pour une liste de block
    }


    public void changeAccel(float values[]){
        bille.changeVelocity(values, time);

    }


    public void draw(Canvas canvas, Paint p){
            bille.draw(canvas,p);
            block.draw(canvas,p); // a changer: parcourir la liste de block pour les afficher
    }

    public void doRun(Main2Activity.GameView canvas) {

        while(true) {
            bille.update(time,block); //applique les mouvement


            canvas.postInvalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
