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

public class CreateLevel {

    private static int small = 10, medium = 50, big = 100;


    public static Level loadLevel(int screenWidth, int screnHeight ,int i){
        if(i == 1){
            return createLvl1(screenWidth,screnHeight);
        }else if(i == 2){
            return createLvl2(screenWidth,screnHeight);
        }else{
            Log.d("TEST", "loadLevel: ERROR");
            return null;
        }
    }

    private static Level createLvl1 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(1,200,700,small));
        blockList.add(new Block(700,200,small,500));
        blockList.add(new Block(600,200,small,400));
        blockList.add(new Block(400,600,200,small));
        blockList.add(new Block(100,200,small,400));
        blockList.add(new Block(100,600,200,small));

        blockList.add( new ArrivalBlock(340,440,small,small));

        Block start = new Block(700,0,small,small);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }

    private static Level createLvl2 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(1,200,700,small));
        blockList.add(new Block(700,200,small,500));
        blockList.add(new Block(300,600,200,small));
        blockList.add(new Block(100,200,small,400));
        blockList.add(new Block(100,600,200,small));

        blockList.add(new Trap(900,900,100,100));
        blockList.add(new ArrivalBlock(340,440,small,small));

        Block start = new Block(700,0,small,small);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }

}
