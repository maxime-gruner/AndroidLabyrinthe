package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Max on 26/02/2017.
 */

public class ArrivalBlock extends Block {

    public ArrivalBlock(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(hitbox,p);
        p.setStyle(Paint.Style.STROKE);
    }
}
