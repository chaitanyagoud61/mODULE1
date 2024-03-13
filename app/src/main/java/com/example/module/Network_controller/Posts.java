package com.example.module.Network_controller;

import com.google.gson.annotations.SerializedName;

public class Posts {
    @SerializedName(value = "title")
    String title="";
    String body="";
    Integer id=null;
    Integer userId=null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
