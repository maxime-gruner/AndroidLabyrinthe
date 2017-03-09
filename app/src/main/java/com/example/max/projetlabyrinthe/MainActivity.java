package com.example.max.projetlabyrinthe;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startLvl1;
    private Button startLvl2;
    private Button startLvl3;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        startLvl1 = (Button) findViewById(R.id.level1);
        startLvl2 = (Button) findViewById(R.id.level2);
        startLvl3 = (Button) findViewById(R.id.level3);

        startLvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("LEVEL",1);
                startActivity(intent);
            }
        });

        startLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("LEVEL",2);
                startActivity(intent);
            }
        });
        startLvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("LEVEL",3);
                startActivity(intent);
            }
        });
    }
}
