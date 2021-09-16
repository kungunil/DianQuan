package home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import DB.DBTool;
import bean.Item;
import bean.User;

public class Inforfs {
    public static String refreshitem(int uid) {
        Connection con = null;
        String r = null;

        try {
            con = DBTool.getconnect();
            String sql = "select item_id,title,introduction from "+
            "t_rcmitem a, item b where a.itemid=b.item_id order by irank desc limit 6";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Item> items = new ArrayList<Item>();
            MyWrap tmp = new MyWrap();

            while(rs.next()) {
                Item temp = new Item();
                temp.setItemid(rs.getInt(1));
                temp.setItemname(rs.getString(2));
                temp.setIteminfo(rs.getString(3));
                items.add(temp);
            }
            rs.close();
            st.close();
            tmp.setItems(items);

            if (uid != 0) {
                String sql1 = "select user_id,username,type from user where user_id=?";
                User user = new User();
                PreparedStatement pstm = con.prepareStatement(sql1);
                pstm.setInt(1, uid);
                ResultSet rs1 = pstm.executeQuery();
                if (rs1.next()) {
                    user.setUid(rs1.getInt(1));
                    user.setUsername(rs1.getString(2));
                    user.setType(rs1.getInt(3));
                }
                rs1.close();
                pstm.close();
                tmp.setUser(user);
            }

            r = JSON.toJSONString(tmp);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con =  null;
        }
        return r;
    }
}

class MyWrap {
    private ArrayList<Item> items;
    private User user;

    public MyWrap(ArrayList<Item> items, User user) {
        this.items = items;
        this.user = user;
    }
    public MyWrap() {
    }
    public MyWrap(ArrayList<Item> items) {
        this.items = items;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}