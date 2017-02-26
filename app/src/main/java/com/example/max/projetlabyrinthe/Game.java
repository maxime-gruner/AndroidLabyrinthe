package com.example.max.projetlabyrinthe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.TreeMap;

/**
 * Created by Max on 22/02/2017.
 */

public class Game {
    private Integer number;
    private static  final TreeMap<Integer , Level> levels= new TreeMap<>();

    public Game (){
        number=0;
    }

    public void addLevel (Level lvl){
        levels.put(number, lvl);
        number++;
    }

    public boolean hasLevel (Integer i){
        return levels.containsKey(i);
    }

    public Level loadLevel (Integer key){
        if(levels.containsKey(key)) Log.d("trouvé !", " trouvé ");
        return levels.get(key);
    }

    public void doRun(Main2Activity.GameView canvas){
        int current = 0;
        while(levels.containsKey(current)){
            levels.get(current).doRun(canvas);
            current++;
        }
    }


}
