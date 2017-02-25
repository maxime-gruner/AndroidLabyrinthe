package com.example.max.projetlabyrinthe;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mauff on 25/02/2017.
 */

public class Level1 {

    public Level createLvl1 (int screenWitdh, int screenHeigth){
        List<Block> blockList = new ArrayList<>();
        Log.d("test", "fail");
        blockList.add(new Block(1,200,700,10));
        Log.d("test", "fail");
        blockList.add(new Block(700,200,10,500));
        Log.d("test", "fail");
        blockList.add(new Block(600,200,10,400));
        Log.d("test", "fail");
        blockList.add(new Block(400,600,200,10));
        Log.d("test", "fail");
        blockList.add(new Block(100,200,10,400));
        Log.d("test", "fail");
        blockList.add(new Block(100,600,200,10));
        Log.d("test", "fail");

        Block arrival = new Block(340,440,10,10);

        Block start = new Block(700,0,10,10);

        Level level = new Level(screenWitdh,screenHeigth,arrival,start,blockList);
        return  level;
    }


}
