package com.example.max.projetlabyrinthe;

import java.util.ArrayList;
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
        }else if(i == 3){
            return createLvl3(screenWidth,screnHeight);
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

        int widthS = screenWidth/11;
        int heightS = screenHeight/17;

        blockList.add(new Block(widthS,0,widthS,9*heightS));
        blockList.add(new Block(widthS,10*heightS,2*widthS,heightS));
        blockList.add(new Block(0,12*heightS,5*widthS,heightS));
        blockList.add(new Block(5*widthS,2*heightS,3*widthS,heightS));
        blockList.add(new Block(7*widthS,3*heightS,widthS,15*heightS));


        blockList.add(new Trap(0,11*heightS,widthS,heightS));
        blockList.add(new Trap(2*widthS,5*heightS,widthS,heightS));
        blockList.add(new Trap(2*widthS,7*heightS,widthS,heightS));
        blockList.add(new Trap(6*widthS,4*heightS,widthS,heightS));
        blockList.add(new Trap(6*widthS,6*heightS,widthS,heightS));

        blockList.add(new BounceBlock(6*widthS,8*heightS,widthS,heightS));
        blockList.add(new BounceBlock(6*widthS,9*heightS,widthS,heightS));
        blockList.add(new BounceBlock(6*widthS,10*heightS,widthS,heightS));

        blockList.add(new MovingBlock(3*widthS,2*heightS,widthS,heightS,widthS*2,widthS*5));
        blockList.add(new MovingBlock(9*widthS,7*heightS,widthS,heightS,widthS*8,widthS*11));


        blockList.add(new ArrivalBlock(widthS*9,heightS*16,widthS,heightS));

        Block start = new Block(widthS,heightS,widthS,heightS);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }


    private static Level createLvl3 (int screenWidth, int screenHeight){
        List<Block> blockList = new ArrayList<>();

        int widthS = screenWidth/11;
        int heightS = screenHeight/17;

        blockList.add(new Block(widthS,0,widthS,9*heightS));
        blockList.add(new Block(widthS,10*heightS,2*widthS,heightS));
        blockList.add(new Block(0,12*heightS,5*widthS,heightS));
        blockList.add(new Block(5*widthS,2*heightS,3*widthS,heightS));
        blockList.add(new Block(7*widthS,3*heightS,widthS,15*heightS));

        DoorBlock door = new DoorBlock(2*widthS,2*heightS,3*widthS,heightS);
        blockList.add(door);

        blockList.add(new ArrivalBlock(widthS*9,heightS*16,widthS,heightS));

        Block start = new Block(widthS,heightS,widthS,heightS);

        Level level = new Level(screenWidth,screenHeight,start,blockList,door);
        return  level;
    }



}
