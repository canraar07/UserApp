package com.andi.userapp.data;

import com.google.gson.annotations.SerializedName;

public class ObjecLogin {
    @SerializedName("id")
    String id;
    @SerializedName("nama")
    String nama;

    public ObjecLogin(){}

    public ObjecLogin(String id,String nama){
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
