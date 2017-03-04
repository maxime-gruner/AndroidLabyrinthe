package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Max on 04/03/2017.
 */

public class BounceBlock extends Block {

    public BounceBlock(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    @Override
    public void draw(Canvas canvas, Paint p) {
        p.setColor(Color.GRAY);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(hitbox,p);
        p.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean actionOnCollide(Bille bille) {
        bille.setxVelo(-bille.getxVelo());
        bille.setyVelo(-bille.getyVelo());
        return false;
    }
}

