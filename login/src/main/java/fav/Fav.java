package fav;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import DB.DBTool;

public class Fav {
    // type 1为执行， 2为取消
    // 成功返回1，失败返回0

    public static void followuser(int type, int uid, int id) {
        Connection con = DBTool.getconnect();
        try {
            Statement st = con.createStatement();
            String sql1 = ("select attention from user where user_id="+uid);
            String oldattention = null;
            ResultSet rs1 = st.executeQuery(sql1);
            if (rs1.next()) {
                oldattention = rs1.getString(1);
            }
            rs1.close();
            String newattention = null;

            if (type == 1) {
                newattention = (oldattention+","+id);
            }
            else if (type == 2) {
                String[] temp = oldattention.split(",");
                ArrayList<String> att = new ArrayList<String>(Arrays.asList(temp));
                att.remove(""+id);
                newattention = String.join(",", att);
            }
            String sql2 = ("update user set attention='"+
            newattention+"' where user_id="+uid);
            st.executeUpdate(sql2);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
    }

    public static void collect(int type, int uid, int id) {
        Connection con = DBTool.getconnect();
        try {
            Statement st = con.createStatement();
            String sql1 = ("select collection from user where user_id="+uid);
            String oldcollection = null;
            ResultSet rs1 = st.executeQuery(sql1);
            if (rs1.next()) {
                oldcollection = rs1.getString(1);
            }
            rs1.close();
            String newcollection = null;

            if (type == 1) {
                newcollection = (oldcollection+","+id);
            }
            else if (type == 2) {
                String[] temp = oldcollection.split(",");
                ArrayList<String> coll = new ArrayList<String>(Arrays.asList(temp));
                coll.remove(""+id);
                newcollection = String.join(",", coll);
            }
            String sql2 = ("update user set collection='"+
            newcollection+"' where user_id="+uid);
            st.executeUpdate(sql2);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
    }
}
