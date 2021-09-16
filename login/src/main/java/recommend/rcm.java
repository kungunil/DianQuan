package recommend;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBTool;

public class rcm {
    public static void cmtrcm(int cmtid) {
        Connection con = DBTool.getconnect();
        try {
            Statement st = con.createStatement();
            String sql = ("insert into t_rcmcmt(cmtid) values ("+cmtid+")");
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
    }

    public static void itemrcm(int itemid) {
        Connection con = DBTool.getconnect();
        try {
            Statement st = con.createStatement();
            String sql = ("insert into t_rcmitem(itemid) values ("+itemid+")");
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
    }
}
