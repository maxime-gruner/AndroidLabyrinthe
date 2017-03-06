package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Max on 06/03/2017.
 */

public class MovingBlock extends Block{

    int speed = 3;
    int direction = 1;

    int maxOffsetX;
    int minOffsetX;

    public MovingBlock(int x, int y, int width, int height,int minX,int maxX) {
        super(x, y, width, height);
        maxOffsetX = maxX;
        minOffsetX = minX;

    }


    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setColor(Color.MAGENTA);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(hitbox,p);
        p.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean actionOnCollide(Bille bille) {
        super.actionOnCollide(bille);
        return false;
    }

    @Override
    public boolean collide(Rect r) {
        move();
        return super.collide(r);
    }

    private void move(){
        if(x+width>maxOffsetX && direction == 1){ //change vers la gauche
            direction = -1;
            Log.d(TAG, "move: g");
        }else if(x<minOffsetX && direction == -1){
            direction = 1;
            Log.d(TAG, "move: d");
        }

        hitbox.offsetTo(x+(speed*direction),y);
        x +=speed*direction;
    }
}
