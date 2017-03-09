package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.Collection;
import java.util.List;

/**
 * Created by mauff on 25/02/2017.
 */

public class Level {

    Bille bille;
    Block start;
    List<Block> wallList;
    DoorBlock door;
    boolean hasInterrupteur = false;



    private boolean terminated = false;
    int height;
    int width;

    float time = 0.20f;

    float aX;
    float aY;

    public Level(int w,int h, Block start, List<Block> bList){
        this.height = h;
        this.width = w;
        this.wallList=bList;
        this.start= start;

    }
    public Level(int w,int h, Block start, List<Block> bList,DoorBlock door){
        this(w,h,start,bList);
        hasInterrupteur = true;
        this.door = door;

    }


    public void changeAccel(float values[]){
        bille.changeVelocity(values, time);

    }

    public void addBlock (Block block){
        wallList.add(block);
    }

    public void draw(Canvas canvas, Paint p){
        bille.draw(canvas, p);
        for(Block block : wallList) {

            block.draw(canvas, p);
        }

    }

    public boolean doRun(Main2Activity.GameView gameView) {
        bille = new Bille(start.getX(), start.getY());
            while(bille.isAlive()){
                terminated = bille.update(time, wallList, width, height); //applique les mouvement
                if(terminated) return true;
                gameView.postInvalidate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        return false;
    }

    public boolean clickOnbox(int x, int y) {
        return door.click(x,y);
    }

    public void open(){
        door.open();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("test", "run: lock");
                door.close();
            }
        }).start();
    }

    public boolean hasInterrupteur() {
        return hasInterrupteur;
    }
}
