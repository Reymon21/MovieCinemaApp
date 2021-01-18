package com.reymondrizki.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InputActivity extends AppCompatActivity {

    private EditText et_nomor,
            et_jenis,
            et_jumlah,
            et_harga;
    private FloatingActionButton fab_done;
    private SQLiteHelper helper;
    private String pilih;
    private String id, nomor, jenis, jumlah, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_nomor = findViewById(R.id.et_nomor);
                et_jenis = findViewById(R.id.et_jenis);
                et_jumlah = findViewById(R.id.et_jumlah);
                et_harga = findViewById(R.id.et_harga);
                fab_done = findViewById(R.id.fab_done);

                helper = new SQLiteHelper(this);

                Bundle bundle = getIntent().getExtras();
                if(bundle!= null){
                    getSupportActionBar().setTitle("Ubah Data");
                    id = bundle.getString("ID");//
                    nomor = bundle.getString("Nomor_Tiket");
                    jenis = bundle.getString("Jenis_Tiket");
                    jumlah = bundle.getString("Jumlah_Tiket");
                    harga = bundle.getString("Harga_Tiket");

                    et_nomor.setText(nomor);
                    et_jenis.setText(jenis);
                    et_jumlah.setText(jumlah);
                    et_harga.setText(harga);
                    pilih = "Edit";
                }else {
                    getSupportActionBar().setTitle("Tambah Data");
                    pilih = "Tambah";
                }

                fab_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nomor = et_nomor.getText().toString();
                        String jenis = et_jenis.getText().toString();
                        String jumlah = et_jumlah.getText().toString();
                        String harga = et_harga.getText().toString();

                        if (TextUtils.isEmpty(nomor)) {
                            et_nomor.setError("Data Tidak Boleh Kosong");
                            et_nomor.requestFocus();
                        } else if (TextUtils.isEmpty(jenis)) {
                            et_jenis.setError("Data Tidak Boleh Kosong");
                            et_jenis.requestFocus();
                        } else if (TextUtils.isEmpty(jumlah)) {
                            et_jumlah.setError("Data Tidak Boleh Kosong");
                            et_jumlah.requestFocus();
                        } else if (TextUtils.isEmpty(harga)) {
                            et_harga.setError("Data Tidak Boleh Kosong");
                            et_harga.requestFocus();
                        } else {
                            if (pilih.equals("Tambah")) {
                                boolean isInsert = helper.insertData(nomor,
                                        jenis,
                                        jumlah,
                                        harga);

                                if (isInsert) {
                                    Toast.makeText(InputActivity.this, "Data berhasil disimpan ", Toast.LENGTH_SHORT).show();
                                    kosong();
                                    startActivity(new Intent(InputActivity.this, tiket.class));
                                    finish();
                                } else {
                                    Toast.makeText(InputActivity.this, "Data gagal disimpan ", Toast.LENGTH_SHORT).show();
                                    kosong();
                                    startActivity(new Intent(InputActivity.this, tiket.class));
                                    finish();
                                }
                            } else {
                                boolean isUpdate = helper.updateData(
                                        id,
                                        nomor,
                                        jenis,
                                        jumlah,
                                        harga
                                );
                                if (isUpdate) {
                                    Toast.makeText(InputActivity.this, "Data berhasil diubah ", Toast.LENGTH_SHORT).show();
                                    kosong();
                                    startActivity(new Intent(InputActivity.this, tiket.class));
                                    finish();
                                } else {
                                    Toast.makeText(InputActivity.this, "Data gagal diubah ", Toast.LENGTH_SHORT).show();
                                    kosong();
                                    startActivity(new Intent(InputActivity.this, tiket.class));
                                    finish();
                                }
                            }

                        }
                    }
                });
    }
    private void kosong(){
        et_nomor.setText(null);
        et_jenis.setText(null);
        et_jumlah.setText(null);
        et_harga.setText(null);
    }
}