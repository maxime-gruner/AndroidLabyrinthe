package com.example.max.projetlabyrinthe;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauff on 25/02/2017.
 */

public class CreateLevel {

    private static int small = 10, medium = 50, big = 100;


    public static Level loadLevel(int screenWidth, int screnHeight ,int i,Context context){

        if(i == 1){
            return createLvl1(screenWidth,screnHeight,context);
        }else if(i == 2){
            return createLvl2(screenWidth,screnHeight,context);
        }else if(i == 3){
            return createLvl3(screenWidth,screnHeight,context);
        }else if(i == 4){
            return createLvl4(screenWidth,screnHeight,context);
        }else{
            return null;
        }
    }

    private static Level createLvl1 (int screenWidth, int screenHeight,Context context){
        List<Block> blockList = new ArrayList<>();
        int widthS = screenWidth/11;
        int heightS = screenHeight/17;

        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),0,heightS,8*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),7*widthS,heightS,widthS,5*heightS));
        blockList.add(new Trap(11*widthS,heightS,widthS,heightS));
        blockList.add(new Trap(6*widthS,3*heightS,widthS,heightS));


        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),4*widthS,4*heightS,widthS,3*heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),4*widthS,7*heightS,7*widthS,heightS));

        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),widthS,6*heightS,widthS,5*heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),widthS,11*heightS,7*widthS,heightS));
        blockList.add(new Trap(2*widthS,7*heightS,widthS,heightS));

        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),8*widthS,11*heightS,widthS,8*heightS));
        blockList.add(new Trap(9*widthS,6*heightS,widthS,heightS));


        blockList.add( new ArrivalBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.exit),9*widthS,16*heightS,widthS,heightS));



        Block start = new Block(3,3,small,small);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }

    private static Level createLvl2 (int screenWidth, int screenHeight,Context context){
        List<Block> blockList = new ArrayList<>();

        int widthS = screenWidth/11;
        int heightS = screenHeight/17;

        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),widthS,0,widthS,9*heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),widthS,10*heightS,2*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),0,12*heightS,5*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),5*widthS,2*heightS,3*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),7*widthS,3*heightS,widthS,15*heightS));


        blockList.add(new Trap(0,11*heightS,widthS,heightS));
        blockList.add(new Trap(2*widthS,5*heightS,widthS,heightS));
        blockList.add(new Trap(2*widthS,7*heightS,widthS,heightS));
        blockList.add(new Trap(6*widthS,4*heightS,widthS,heightS));
        blockList.add(new Trap(6*widthS,6*heightS,widthS,heightS));

        blockList.add(new BounceBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.bumper),6*widthS,8*heightS,widthS,heightS));
        blockList.add(new BounceBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.bumper),6*widthS,9*heightS,widthS,heightS));
        blockList.add(new BounceBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.bumper),6*widthS,10*heightS,widthS,heightS));

        blockList.add(new MovingBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),3*widthS,2*heightS,widthS,heightS,widthS*2,widthS*5));
        blockList.add(new MovingBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),9*widthS,7*heightS,widthS,heightS,widthS*8,widthS*11));


        blockList.add(new ArrivalBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.exit),widthS*9,heightS*16,widthS,heightS));

        Block start = new Block(widthS,heightS,widthS,heightS);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }


    private static Level createLvl3 (int screenWidth, int screenHeight,Context context){
        List<Block> blockList = new ArrayList<>();

        int widthS = screenWidth/11;
        int heightS = screenHeight/17;

        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),widthS,3*heightS,10*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),widthS,3*heightS,widthS,13*heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),3*widthS,6*heightS,4*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),6*widthS,6*heightS,widthS,5*heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),2*widthS,10*heightS,5*widthS,heightS));
        blockList.add(new Block(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallv),9*widthS,5*heightS,widthS,12*heightS));

        DoorBlock door = new DoorBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),7*widthS,9*heightS,2*widthS,heightS);
        blockList.add(door);

        blockList.add(new ArrivalBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.exit),widthS,heightS*16,widthS,heightS));
        Block start = new Block(5*widthS,7*heightS,widthS,heightS);

        blockList.add(new MovingBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),7*widthS,7*heightS,widthS,heightS,7*widthS,9*widthS));
        blockList.add(new MovingBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),3*widthS,12*heightS,widthS,heightS,3*widthS,8*widthS));
        blockList.add(new MovingBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.wallh),7*widthS,14*heightS,widthS,heightS,3*widthS,8*widthS));

        blockList.add(new Trap(2*widthS,heightS*12,widthS,heightS));
        blockList.add(new Trap(2*widthS,heightS*14,widthS,heightS));
        blockList.add(new Trap(8*widthS,heightS*12,widthS,heightS));
        blockList.add(new Trap(8*widthS,heightS*14,widthS,heightS));

        Level level = new Level(screenWidth,screenHeight,start,blockList,door);
        return  level;
    }

    private static Level createLvl4 (int screenWidth, int screenHeight,Context context){
        List<Block> blockList = new ArrayList<>();

        int widthS = screenWidth/11;
        int heightS = screenHeight/17;


        blockList.add(new Trap(0,9*heightS,17*widthS,heightS));


        blockList.add(new ArrivalBlock(BitmapFactory.decodeResource(context.getResources(),R.drawable.exit),widthS*9,heightS*16,widthS,heightS));

        Block start = new Block(widthS,heightS,widthS,heightS);

        Level level = new Level(screenWidth,screenHeight,start,blockList);
        return  level;
    }



}
