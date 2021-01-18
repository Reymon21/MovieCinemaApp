package com.reymondrizki.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class tiket extends AppCompatActivity {
    private FloatingActionButton fab_add;
    private ListView list_view;
    private ListViewAdapter adapter;
    ArrayList<dataTiket> listTiket = new ArrayList<>();
    private SQLiteHelper helper;
    private SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket);

        fab_add = findViewById(R.id.fab_add);
        list_view = findViewById(R.id.list_view);
        refresh = findViewById(R.id.refresh);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            menampilkanData();
            }
        });

        helper = new SQLiteHelper(this);

        fab_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(tiket.this, InputActivity.class));
            }
        });
            menampilkanData();
            }
            private void menampilkanData(){
                listTiket.clear();
                Cursor res = helper.getDataAll();
                refresh.setRefreshing(true);
                while (res.moveToNext()){
                    String id = res.getString(0);
                    String nomor = res.getString(1);
                    String jenis = res.getString(2);
                    String jumlah = res.getString(3);
                    String harga = res.getString(4);

                    listTiket.add(new dataTiket(id,
                            nomor,
                            jenis,
                            jumlah,
                            harga));


                }
                adapter = new ListViewAdapter(listTiket, tiket.this);
                refresh.setRefreshing(false);
                list_view.setAdapter(adapter);
            }

}