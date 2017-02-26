package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Collection;
import java.util.List;

/**
 * Created by mauff on 25/02/2017.
 */

public class Level {

    Bille bille;
    Block arrival,start;
    List<Block> wallList;

    private boolean terminated = false;
    int height;
    int width;

    float time = 0.20f;

    float aX;
    float aY;

    public Level(int w,int h, Block a, Block start, List<Block> bList){
        this.height = h;
        this.width = w;
        this.wallList=bList;
        bille = new Bille(start.getX(), start.getY());
        this.arrival=a;
    }


    public void changeAccel(float values[]){
        bille.changeVelocity(values, time);

    }

    public void addBlock (Block block){
        wallList.add(block);
    }

    public void draw(Canvas canvas, Paint p){
        for(Block block : wallList) {
            bille.draw(canvas, p);
            block.draw(canvas, p);
        }
        arrival.draw(canvas,p);
    }

    public void doRun(Main2Activity.GameView gameView) {

        while(!terminated) {
            terminated = bille.update(time,wallList,arrival,width,height); //applique les mouvement


            gameView.postInvalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}