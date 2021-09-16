package com.login.entity;

import java.util.Date;

public class Comment {
    private Integer id;
    private String title;
    private String writer;
    private Date date;
    private String text;

    public Comment(Integer id, String title, String writer, Date date, String text) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
