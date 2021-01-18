package com.reymondrizki.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Film extends AppCompatActivity {

    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);


        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                pesan1();

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                pesan2();

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                pesan3();

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                pesan4();

            }
        });
    }
    public void pesan1(){
        Intent intent = new Intent(this, tiket.class);
        startActivity(intent);
    }
    public void pesan2(){
        Intent intent = new Intent(this, tiket.class);
        startActivity(intent);
    }
    public void pesan3(){
        Intent intent = new Intent(this, tiket.class);
        startActivity(intent);
    }
    public void pesan4(){
        Intent intent = new Intent(this, tiket.class);
        startActivity(intent);
    }
}
