package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Max on 09/03/2017.
 */

public class DoorBlock extends Block {

    int lastX;
    Rect lastBox;

    public DoorBlock(int x, int y, int width, int height ) {
        super(x, y, width, height);

    }

    public void open(){
        lastX = x;
        lastBox = hitbox;
        x = 0;
        hitbox = new Rect(x,y,x,y);


    }

    public boolean click(int x,int y){
        return hitbox.contains(x,y);
    }

    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.YELLOW);
        canvas.drawRect(hitbox, p);
        p.setStyle(Paint.Style.STROKE);
    }

    public void close() {
        x = lastX;
        hitbox = lastBox;
    }
}
