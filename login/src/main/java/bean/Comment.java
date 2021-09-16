package bean;

public class Comment {
    // 数据库中commentid自增
    private int cmtid;
    private int uid;
    private String cmttext;
    private boolean pblic;
    private String imgname;
    private int itemid;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public Comment() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCmttext() {
        return cmttext;
    }

    public void setCmttext(String cmttext) {
        this.cmttext = cmttext;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public boolean isPblic() {
        return pblic;
    }

    public void setPblic(boolean pblic) {
        this.pblic = pblic;
    }

    public int getCmtid() {
        return cmtid;
    }

    public void setCmtid(int cmtid) {
        this.cmtid = cmtid;
    }
}
