package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn=null;
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection("jdbc:mysql://106.53.134.222:3306/db_dianquan?useUnicode=true&characterEncoding=utf8&useSSL=false","myuser","mypassword");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException var1) {
                var1.printStackTrace();
                System.out.println("关闭con对象失败！");
            }
        }

    }
}
