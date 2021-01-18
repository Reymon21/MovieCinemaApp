package com.reymondrizki.mobile;

public class dataTiket {
    private String ID;
    private String Nomor;
    private String Jenis;
    private String Jumlah;
    private String Harga;

    public dataTiket(){

    }

    public dataTiket(String ID, String nomor, String jenis, String jumlah, String harga) {
        this.ID = ID;
        Nomor = nomor;
        Jenis = jenis;
        Jumlah = jumlah;
        Harga = harga;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNomor() {
        return Nomor;
    }

    public void setNomor(String nomor) {
        Nomor = nomor;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}
