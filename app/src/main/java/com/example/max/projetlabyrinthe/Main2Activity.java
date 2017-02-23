package com.example.max.projetlabyrinthe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity{

    private SensorManager sm;

    private GameView gameView; //la vue du jeu
    private Game game; //le jeu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main2);

        sm = (SensorManager) getSystemService(this.SENSOR_SERVICE);

        gameView = new GameView(this);
        layout.addView(gameView);
        game = new Game(900,900);

        new Thread(new Runnable() {
            @Override
            public void run() {
                game.doRun(gameView);

            }
        }).start();


    }


    class GameView extends View implements SensorEventListener {

        private Sensor sensor;

        public GameView(Context context) {
            super(context);

            sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME); // definit la frequence d actualisation du valeur du capteur


        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setStrokeWidth(5);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.RED);

            game.draw(canvas,p);

        }



        @Override
        public void onSensorChanged(SensorEvent event) {
            game.changeAccel(event.values); //change la valeur de l acceleration
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }


}
