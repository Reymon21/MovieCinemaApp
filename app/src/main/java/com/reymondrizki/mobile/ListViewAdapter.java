package com.reymondrizki.mobile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends  BaseAdapter{
    private List<dataTiket> listTiket;
    private Context context;
    private SQLiteHelper helper;

    private TextView tv_nomor,
                tv_jenis,
                tv_jumlah,
                tv_harga;

    private LinearLayout linear;
    private ImageView hapus;
    public ListViewAdapter(List<dataTiket> listTiket, Context context) {
        this.listTiket = listTiket;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listTiket.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_tiket, null);

        tv_nomor = v.findViewById(R.id.tv_nomor);
        tv_jenis = v.findViewById(R.id.tv_jenis);
        tv_jumlah = v.findViewById(R.id.tv_jumlah);
        tv_harga = v.findViewById(R.id.tv_harga);
        linear = v.findViewById(R.id.linear);
        hapus = v.findViewById(R.id.hapus);


        helper = new SQLiteHelper(context);

        tv_nomor.setText("Nomor_Tiket: " + listTiket.get(position).getNomor());
        tv_jenis.setText("Jenis_Tiket : "+listTiket.get(position).getJenis());
        tv_jumlah.setText("Jumlah_Tiket: "+ listTiket.get(position).getJumlah());
        tv_harga.setText("Harga_Tiket : " + listTiket.get(position).getHarga());

        linear.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Intent intent = new Intent(context, InputActivity.class);
                intent.putExtra("ID", listTiket.get(position).getID());
                intent.putExtra("Nomor_Tiket", listTiket.get(position).getNomor());
                intent.putExtra("Jenis_Tiket", listTiket.get(position).getJenis());
                intent.putExtra("Jumlah_Tiket", listTiket.get(position).getID());
                intent.putExtra("Harga_Tiket", listTiket.get(position).getHarga());
                intent.putExtra("TANDA", "Ubah");

                context.startActivity(intent);
                return true;
            }
        });
        hapus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                alertDialog.setMessage("Apakah anda yakin ingin menghapus Data ini ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Integer isDelete = helper.deleteData(listTiket.get(position).getID());
                                if(isDelete> 0){
                                    Toast.makeText(context, "Data Berhasil di Hapus", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Data Gagal di Hapus", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("Tidak ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        return v;
    }
}
