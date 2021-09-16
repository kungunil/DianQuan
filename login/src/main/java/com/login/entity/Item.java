package com.login.entity;

import java.sql.Timestamp;

public class Item {
    private int item_id;
    private String title;
    private String introduction;

    private String username;
    private Timestamp date;
    private int user_id;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "tiaomu{" +
                "item_id=" + item_id +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", user_id=" + user_id +
                '}';
    }
}
