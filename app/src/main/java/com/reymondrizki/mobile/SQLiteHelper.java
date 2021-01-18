package com.reymondrizki.mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android .database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NavigationRes;
import androidx.annotation.Nullable;

public class SQLiteHelper extends  SQLiteOpenHelper{
    private static final String NAMA_DATABASE = "androidUTS.db";
    private static final String NAMA_TABEL = "bioskop";

    private static final String Col_1  = "ID";
    private static final String Col_2  = "Nomor_Tiket";
    private static final String Col_3  = "Jenis_Tiket";
    private static final String Col_4  = "Jumlah_Tiket";
    private static final String Col_5  = "Harga_Tiket";
    public SQLiteHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAMA_TABEL + " (" +
                Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Col_2 + " INTEGER, " +
                Col_3 + " TEXT, " +
                Col_4 + " INTEGER, " +
                Col_5 + " INTEGER " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL);
    }
    public boolean insertData(String nomor, String jenis, String jumlah, String harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2, nomor );
        values.put(Col_3, jenis );
        values.put(Col_4, jumlah );
        values.put(Col_5, harga );
        long result = db.insert(NAMA_TABEL, null, values);
        return result != -1;

    }
        public Cursor getDataAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + NAMA_TABEL, null);
        }

        public boolean updateData(String id, String nomor, String jenis, String jumlah, String harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Col_1, id);
            values.put(Col_2, nomor);
            values.put(Col_3, jenis);
            values.put(Col_4, jumlah);
            values.put(Col_5, harga);


            db.update(NAMA_TABEL,values,Col_1+"= ? ",new String[]{id});
            return true;
        }

        public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(NAMA_TABEL, Col_1+ "= ? ", new String[]{id});
        }

}
