package com.andi.userapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Login {
    @SerializedName("result")
    List<ObjecLogin> objecLogins;
    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ObjecLogin> getObjeckLogins() {
        return objecLogins;
    }

    public void setObjeckLogins(List<ObjecLogin> objeckLogins) {
        this.objecLogins = objeckLogins;
    }
}
