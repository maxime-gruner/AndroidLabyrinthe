package com.example.max.projetlabyrinthe;

/**
 * Created by mauff on 25/02/2017.
 */

public class AdaptScreen {
    private int screenWidthratio;
    private int screenHeightratio;

    public AdaptScreen (int screenWidth, int screenHeight){
        this.screenHeightratio= screenHeight/1080;
        this.screenWidthratio = screenWidth/1920;
    }

    public int cw (int w){
        return (w*screenWidthratio);
    }

    public int ch (int h){
        return h*screenHeightratio;
    }
}
