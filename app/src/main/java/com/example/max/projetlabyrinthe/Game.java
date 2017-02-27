package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.TreeMap;

/**
 * Created by Max on 22/02/2017.
 */

public class Game {

    public void doRun(Main2Activity.GameView canvas,Level level){
        boolean res = false;
        while(!res) {
            Log.d("TEST", "doRun: AGAIN");
            res = level.doRun(canvas);
        }
        Log.d("TEST", "doRun: GAME END WIN");
    }


}
