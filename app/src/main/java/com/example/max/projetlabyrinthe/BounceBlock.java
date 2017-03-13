package com.example.max.projetlabyrinthe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Max on 04/03/2017.
 */

public class BounceBlock extends Block {

    public BounceBlock(Bitmap sprite, int x, int y, int width, int height) {
        super(sprite,x, y, width, height);
    }


    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setColor(Color.GRAY);
        p.setStyle(Paint.Style.FILL);
        //canvas.drawRect(hitbox,p);
        canvas.drawBitmap(sprite,null,hitbox,p);
        p.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean actionOnCollide(Bille bille) {
        bille.setxVelo(-bille.getxVelo());
        bille.setyVelo(-bille.getyVelo());

        return false;
    }
}

