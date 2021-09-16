package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTool {
    private static Connection con = null;

    public static Connection getconnect() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                con = DriverManager.getConnection(
                        "jdbc:mysql://106.53.134.222:3306/db_dianquan?"+
                        "useUnicode=true&characterEncoding=UTF-8", "myuser",
                        "mypassword");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void closeconnect() {
        if (con != null)
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static boolean isexistitem(String itemname) {
        con = getconnect();
        boolean r = false;
        try {
            PreparedStatement pstm = con.prepareStatement("select "+
            "* from item where title=?");
            pstm.setString(1, itemname);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                r = true;
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeconnect();
        }
        return r;
    }

    public static int getitmidbyname(String itemname) {
        con = getconnect();
        int r = -1;
        try {
            PreparedStatement pstm = con.prepareStatement("select "+
            "item_id from item where title=?");
            pstm.setString(1, itemname);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                r = rs.getInt(1);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeconnect();
        }
        return r;
    }
}
