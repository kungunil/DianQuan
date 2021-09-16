package Main.bean;

import java.sql.Timestamp;

public class ItemApply {
    private Integer apply_id = 0;
    private Integer user_id = 0;
    private String title;
    private String introduction;
    private String username;
    private Timestamp date;

    @Override
    public String toString() {
        return "itemapply{" +
                "apply_id=" + apply_id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", statements='" + statements + '\'' +
                '}';
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
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

    public String getStatements() {
        return statements;
    }

    public void setStatements(String statements) {
        this.statements = statements;
    }

    private String statements;
}
