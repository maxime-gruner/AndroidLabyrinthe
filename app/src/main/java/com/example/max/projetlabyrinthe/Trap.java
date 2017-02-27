package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Max on 27/02/2017.
 */

public class Trap extends Block {

    public Trap(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public synchronized boolean actionOnCollide(Bille bille) {
        bille.setAlive(false);
        Log.d(TAG, "actionOnCollide: DIE");
        return false;
    }

    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawRect(hitbox, p);
        p.setStyle(Paint.Style.STROKE);
    }
}
