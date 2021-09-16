package Main.bean;

import java.sql.Timestamp;

public class Item {
    private Integer item_id = 0;
    private Integer user_id = 0;
    private String title;
    private String introduction;
    private String username;

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    private Timestamp date;



}
