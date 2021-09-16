package Main.bean;

import java.sql.Timestamp;

public class Comment {
    private Integer cmt_id;
    private Integer user_id;
    private String cmttext;
    private Integer pblic;
    private String imgname;
    private Integer item1_id;
    private Timestamp date;

    @Override
    public String toString() {
        return "Comment{" +
                "cmt_id=" + cmt_id +
                ", user_id=" + user_id +
                ", cmttext='" + cmttext + '\'' +
                ", pblic=" + pblic +
                ", imgname='" + imgname + '\'' +
                ", item1_id=" + item1_id +
                ", date=" + date +
                '}';
    }

    public Integer getCmt_id() {
        return cmt_id;
    }

    public void setCmt_id(Integer cmt_id) {
        this.cmt_id = cmt_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCmttext() {
        return cmttext;
    }

    public void setCmttext(String cmttext) {
        this.cmttext = cmttext;
    }

    public Integer getPblic() {
        return pblic;
    }

    public void setPblic(Integer pblic) {
        this.pblic = pblic;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public Integer getItem1_id() {
        return item1_id;
    }

    public void setItem1_id(Integer item1_id) {
        this.item1_id = item1_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
