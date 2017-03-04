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

    private static int space = Bille.SIZE*2;

    public static Level loadLevel(int screenWidth, int screnHeight ,int i){

        if(i == 1){
            return createLvl1(screenWidth,screnHeight);
        }else if(i == 2){
            return createLvl2(screenWidth,screnHeight);
        }else{
            return null;
        }
    }

    private static Level createLvl1 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();
        int widthS = screenWidth/10;
        int heightS = screenHeight/10;
        blockList.add(new Block(1,1,screenWidth,small));
        blockList.add(new Block(1,screenHeight,screenWidth,small));
        blockList.add(new Block(screenWidth,1,small,screenHeight));
        blockList.add(new Block(1,1,small,screenHeight));

        blockList.add(new Block(1,screenHeight/10,850,small));
        blockList.add(new Block(7*widthS,heightS,small,300));
        blockList.add(new Trap(9*widthS,heightS/3,medium,medium));
        blockList.add(new Trap(6*widthS,2*heightS,medium,medium));


        blockList.add(new Block(4*widthS,2*heightS,small,3*heightS));
        blockList.add(new Block(4*widthS,5*heightS,6*widthS,small));

        blockList.add(new Block(2*widthS,4*heightS,small,3*heightS));
        blockList.add(new Block(widthS,7*heightS,7*widthS,small));
        blockList.add(new Trap(2*widthS+small,7*heightS-big,medium,medium));

        blockList.add(new Block(8*widthS,6*heightS,small,4*heightS));
        blockList.add(new Trap(9*widthS,6*heightS,medium,medium));


        blockList.add( new ArrivalBlock(9*widthS,9*heightS,medium,medium));


        Block start = new Block(3,3,small,small);

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

        blockList.add(new BounceBlock(900,900,100,100));
        blockList.add(new ArrivalBlock(340,440,small,small));

        Block start = new Block(700,0,small,small);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }

}
