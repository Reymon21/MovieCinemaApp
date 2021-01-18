package com.reymondrizki.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                openfilm();

             }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                belitiket();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                historypembelian();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                about();

            }
        });
    }
    public void openfilm(){
         Intent intent = new Intent(this, Film.class);
         startActivity(intent);
    }
    public void belitiket(){
        Intent intent = new Intent(this, tiket.class);
        startActivity(intent);
    }
    public void historypembelian(){
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }
    public void about(){
        Intent intent = new Intent(this, maps.class);
        startActivity(intent);
    }
}