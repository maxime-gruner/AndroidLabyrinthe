package com.example.max.projetlabyrinthe;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int LVL = 4; //nb de niveau, et de bouton, qu il y a
    private int i = 0;

    private LinearLayout layout;

    private Button[] startLevels;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.linear);
        startLevels= new Button[LVL];

        TextView width = (TextView) findViewById(R.id.screenwitdh);
        TextView heigt = (TextView) findViewById(R.id.screenheigt);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width.setText(Integer.toString(size.x));
        heigt.setText(Integer.toString(size.y));


        intent = new Intent(this,Main2Activity.class);

        intent.putExtra("WIDTH", size.x);
        intent.putExtra("HEIGHT", (size.y));



        for(Button button : startLevels){
            button = new Button(this);
            startLevels[i] = button;
            button.setText("Start lvl " + (i+1));
            layout.addView(button);
            final int n = i+1;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("LEVEL",n);
                    startActivityForResult(intent,1);
                }
            });
            i++;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         if(resultCode == 1){

            int num = intent.getIntExtra("LEVEL",1);
            startLevels[num-1].setText("LEVEL " + (num) + " CLEAR");
        }
    }
}
