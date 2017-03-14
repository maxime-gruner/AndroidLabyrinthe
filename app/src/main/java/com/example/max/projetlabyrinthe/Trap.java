package com.example.max.projetlabyrinthe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Max on 27/02/2017.
 */

public class Trap extends Block {

    public Trap( int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Trap(Bitmap sprite, int x, int y, int width, int height) {
        super(sprite,x, y, width, height);
    }

    @Override
    public synchronized boolean actionOnCollide(Bille bille) {
        if(!bille.isJumping()){
            bille.setAlive(false);
        }

       return false;
    }

    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawBitmap(sprite,null,hitbox,p);
        //canvas.drawRect(hitbox, p);
        p.setStyle(Paint.Style.STROKE);
    }
}
