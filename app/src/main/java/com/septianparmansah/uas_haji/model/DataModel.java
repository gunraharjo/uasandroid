package com.septianparmansah.uas_haji.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
    public class DataModel {
    @SerializedName("nama")
    private String mNama;
    @SerializedName("nohp")
    private String mNohp;
    @SerializedName("alamat")
    private String mAlamat;
    @SerializedName("gender")
    private String mGender;

    public String getNama() {
        return mNama;
    }
    public void setNama(String nama) {
        mNama = nama;
    }
    public String getNohp() {
        return mNohp;
    }
    public void setmNohp(String nohp) {
        mNohp = nohp;
    }
    public String getAlamat() {
        return mAlamat;
    }
    public void setAlamat(String alamat) {
        mAlamat = alamat;
    }
    public String getGender() {
        return mGender;
    }
    public void setGender(String gender) {
        mGender = gender;
    }

}
