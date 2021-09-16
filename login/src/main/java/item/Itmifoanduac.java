package item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import bean.Item;
import DB.DBTool;

public class Itmifoanduac {
    public static String getitemsjson(int itemid, int uid) {
        //uid为0代表游客, 用户返回json多uid及username
        Connection con = DBTool.getconnect();
        String r = null;
        try {
            String sql = "select username,a.user_id,cmttext,cmt_id,imgname from "+
            "user a, comment b where item1_id=? and a.user_id=b.user_id "+
            "and pblic=1 order by date desc LIMIT 3";
            Item item = new Item();
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<UAC> uac = new ArrayList<UAC>();

            pstm = con.prepareStatement("select item_id, title, "+
            "introduction from item where item_id=?");
            pstm.setInt(1, itemid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                item.setItemid(rs.getInt(1));
                item.setItemname(rs.getString(2));
                item.setIteminfo(rs.getString(3));
            }
            pstm.close();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, itemid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                UAC temp = new UAC(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
                uac.add(temp);
            }
            pstm.close();

            wrap1 mywrap = null;
            if (uid == 0) {
                mywrap = new wrap1(item, uac);
            }
            else {
                Statement st = con.createStatement();
                String username = null;
                ResultSet rstemp = st.executeQuery("select username from user where user_id="+uid);
                if (rstemp.next()) {
                    username = rstemp.getString(1);
                }
                st.close();

                mywrap = new wrap1(item, uac, uid, username);
            }
            r = JSON.toJSONString(mywrap);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
        return r;
    }
    //返回用户关注信息
    public static String getjsonuserlook(int itemid, int uid) {
        Connection con = DBTool.getconnect();
        String r = null;
        try {
            String sql = "select attention,collection,user_id,username from "+
            "user where user_id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = null;
            wrap2 mywrap = new wrap2();

            pstm.setInt(1, uid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                mywrap.setAttention(rs.getString(1));
                mywrap.setCollection(rs.getString(2));
                mywrap.setUid(rs.getInt(3));
                mywrap.setUsername(rs.getString(4));
            }
            pstm.close();
            r = JSON.toJSONString(mywrap);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
        return r;
    }
}

//对应getitemsjson
class wrap1 {
    private Item item;
    private ArrayList<UAC> uac;
    private Integer uid;
    private String username;

    public wrap1(Item item, ArrayList<UAC> uac, int uid, String username) {
        this.item = item;
        this.uac = uac;
        this.uid = uid;
        this.username = username;
    }

    public wrap1(Item item, ArrayList<UAC> uac) {
        this.item = item;
        this.uac = uac;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public wrap1() {
    }
    
    public Integer getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public ArrayList<UAC> getUac() {
        return uac;
    }
    public void setUac(ArrayList<UAC> uac) {
        this.uac = uac;
    }
}

//对应getjsonuserlook
class wrap2 {
    private String attention;
    private String collection;
    private int uid;
    private String username;

    
    public wrap2(String attention, String collection, int uid, String username) {
        this.attention = attention;
        this.collection = collection;
        this.uid = uid;
        this.username = username;
    }
    public wrap2() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAttention() {
        return attention;
    }
    public void setAttention(String attention) {
        this.attention = attention;
    }
    public String getCollection() {
        return collection;
    }
    public void setCollection(String collection) {
        this.collection = collection;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
}

class UAC {
    private String username;    //评论用户名
    private int uid;            //评论用户id
    private String comment;     //评论内容
    private int cmtid;          //评论id
    private String imgname;

    
    public UAC(String username, int uid, String comment, int cmtid, String imgname) {
        this.username = username;
        this.uid = uid;
        this.comment = comment;
        this.cmtid = cmtid;
        this.imgname = imgname;
    }
    public UAC() {
    }
    public String getImgname() {
        return imgname;
    }
    public void setImgname(String imgname) {
        this.imgname = imgname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getCmtid() {
        return cmtid;
    }
    public void setCmtid(int cmtid) {
        this.cmtid = cmtid;
    }
}