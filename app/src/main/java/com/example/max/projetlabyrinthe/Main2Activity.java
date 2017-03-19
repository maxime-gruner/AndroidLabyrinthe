package com.example.max.projetlabyrinthe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity{

    private SensorManager sm;

    private GameView gameView; //la vue du jeu
    private Level level; //le jeu
    private Game game;
    private Sensor sensor;

    private Display mDisplay;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_main2);

        Intent intent=  getIntent();
        int levelNum = intent.getIntExtra("LEVEL",1);
        int screenWidth=intent.getIntExtra("WIDTH",0);
        int screenHeight=intent.getIntExtra("HEIGHT",0);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main2);

        sm = (SensorManager) getSystemService(this.SENSOR_SERVICE);

        mDisplay = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

        gameView = new GameView(this);
        layout.addView(gameView);
        game = new Game();

        level = CreateLevel.loadLevel(screenWidth,screenHeight,levelNum,gameView.getContext());


        new Thread(new Runnable() {
            @Override
            public void run() {
                game.doRun(gameView,level);
                finish();

            }
        }).start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(gameView,sensor,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(gameView);
    }


    class GameView extends View implements SensorEventListener {

        private float mAccelLast;
        private float mAccelCurrent;
        private float mAccel;


        public GameView(Context context) {
            super(context);


            sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            mAccel = 0;
            mAccelCurrent = SensorManager.GRAVITY_EARTH;
            mAccelLast = SensorManager.GRAVITY_EARTH;

            sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME); // definit la frequence d actualisation du valeur du capteur


        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setStrokeWidth(5);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.RED);

            level.draw(canvas,p);

        }

        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
                return;

            float val[] = new float[3];
            float x =0; ;
            float y =0;
            float z =0;

            switch(mDisplay.getRotation()){
                case Surface.ROTATION_0:
                    val[0] = event.values[0];
                    val[1] = event.values[1];
                    break;
                case Surface.ROTATION_90:
                    val[0] = -event.values[1];
                    val[1] = event.values[0];
                    break;
                case Surface.ROTATION_180:
                    val[0] = -event.values[0];
                    val[1] = -event.values[1];
                    break;
                case Surface.ROTATION_270:
                    val[0] = event.values[1];
                    val[1] = -event.values[0];
                    break;
            }
            val[2] = event.values[2];


            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (val[0]*val[0] + val[1]*val[1] + val[2]*val[2])); //detecte le shake
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;



            if(mAccel>10){
                level.shake();
                Log.d("test", "onSensorChanged: SHAKE");
            }else{
                level.changeAccel(val); //change la valeur de l acceleration

            }




        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
           float x = event.getX();
            float y= event.getY();

            if(level.hasInterrupteur() && level.clickOnbox((int)x,(int)y) ){
                level.open();

            }

            return super.onTouchEvent(event);
        }
    }


}
