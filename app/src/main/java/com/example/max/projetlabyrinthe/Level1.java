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

    private int small = 10, medium = 50, big = 100;


    public Level createLvl1 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();
        Log.d("test", "fail");
        blockList.add(new Block(1,200,700,small));
        Log.d("test", "fail");
        blockList.add(new Block(700,200,small,500));
        Log.d("test", "fail");
        blockList.add(new Block(600,200,small,400));
        Log.d("test", "fail");
        blockList.add(new Block(400,600,200,small));
        Log.d("test", "fail");
        blockList.add(new Block(100,200,small,400));
        Log.d("test", "fail");
        blockList.add(new Block(100,600,200,small));
        Log.d("test", "fail");

        Block arrival = new Block(340,440,small,small);

        Block start = new Block(700,0,small,small);

        Level level = new Level(screenWidth,screenHeight,arrival,start,blockList);
        return  level;
    }

    public Level createLvl2 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();
        Log.d("test", "fail");
        blockList.add(new Block(1,200,700,small));
        Log.d("test", "fail");
        blockList.add(new Block(700,200,small,500));
        Log.d("test", "fail");
        blockList.add(new Block(300,600,200,small));
        Log.d("test", "fail");
        blockList.add(new Block(100,200,small,400));
        Log.d("test", "fail");
        blockList.add(new Block(100,600,200,small));
        Log.d("test", "fail");

        Block arrival = new Block(340,440,small,small);

        Block start = new Block(700,0,small,small);

        Level level = new Level(screenWidth,screenHeight,arrival,start,blockList);
        return  level;
    }

}
