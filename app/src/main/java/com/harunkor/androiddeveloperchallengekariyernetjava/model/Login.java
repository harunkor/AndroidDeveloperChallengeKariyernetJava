package com.harunkor.androiddeveloperchallengekariyernetjava.model;

import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("checked")
    @Expose
    private Boolean checked;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getChecked() {
        return checked;
    }


    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
