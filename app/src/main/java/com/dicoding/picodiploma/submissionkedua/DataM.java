package com.dicoding.picodiploma.submissionkedua;

import android.os.Parcel;
import android.os.Parcelable;

public class DataM implements Parcelable {

    private String judul;
    private String genre;
    private String ph;
    private String tahun;
    private String tanggal;
    private String overview;
    private String photo;
    private String rating;
    private String waktu;
    private String aktor;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getAktor() {
        return aktor;
    }

    public void setAktor(String aktor) {
        this.aktor = aktor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.genre);
        dest.writeString(this.ph);
        dest.writeString(this.tahun);
        dest.writeString(this.tanggal);
        dest.writeString(this.overview);
        dest.writeString(this.photo);
        dest.writeString(this.rating);
        dest.writeString(this.waktu);
        dest.writeString(this.aktor);
    }

    public DataM() {
    }

    protected DataM(Parcel in) {
        this.judul = in.readString();
        this.genre = in.readString();
        this.ph = in.readString();
        this.tahun = in.readString();
        this.tanggal = in.readString();
        this.overview = in.readString();
        this.photo = in.readString();
        this.rating = in.readString();
        this.waktu = in.readString();
        this.aktor = in.readString();
    }

    public static final Parcelable.Creator<DataM> CREATOR = new Parcelable.Creator<DataM>() {
        @Override
        public DataM createFromParcel(Parcel source) {
            return new DataM(source);
        }

        @Override
        public DataM[] newArray(int size) {
            return new DataM[size];
        }
    };
}
