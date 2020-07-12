package com.example.radyapp.Models;

import com.google.gson.annotations.SerializedName;

public class LoginCall {

    @SerializedName("msg")
    String msg;

    @SerializedName("success")
    Boolean success;

    @SerializedName("role")
    Boolean role;

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}