package common;
import bean.*;


import java.sql.*;
import java.util.ArrayList;

public class DataDB {
    private Connection con = null;

    public ArrayList<ContextInfo> GetAllattention() {
        ArrayList<ContextInfo> myattentions = new ArrayList<>();
        Statement stmt = null;
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from comment");
            while (rs.next()) {
                ContextInfo attention = new ContextInfo();
                attention.setId(MyTools.strToint(rs.getString("cmt_id")));
                attention.setUid(rs.getInt("user_id"));
                attention.setDate(rs.getString("date"));
                attention.setContex(rs.getString("cmttext"));
                myattentions.add(attention);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        return myattentions;
    }

    public ArrayList<UserInfo> GetAlluser() {
        ArrayList<UserInfo> users = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user ");
            while (rs.next()) {
                UserInfo user = new UserInfo();
                user.setId(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setIntroduce(rs.getString("introduce"));
                user.setNickname(rs.getString("nickname"));
                user.setAttention(rs.getString("attention"));
                user.setCollection(rs.getString("collection"));
                user.setMysay(rs.getString("mysay_id"));
                user.setEmail(rs.getString("email"));
                user.setTelephone(rs.getString("telephone"));
                users.add(user);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return users;
    }

    public UserInfo GetUserInfo(int id) {
        System.out.println("id是：" + id);
        UserInfo user = new UserInfo();
        try {
            con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from user where user_id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setIntroduce(rs.getString("introduce"));
                user.setNickname(rs.getString("nickname"));
                user.setAttention(rs.getString("attention"));
                user.setCollection(rs.getString("collection"));
                user.setMysay(rs.getString("mysay_id"));
                user.setEmail(rs.getString("email"));
                user.setTelephone(rs.getString("telephone"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return user;
    }

    public int ModifyUserPassword(int id, String password) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("update user set password=? where user_id=?");
            pstmt.setString(1, password);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int ModifyUserInfo(int id, String sex, int age, String introduce, String nickname,String telephone,String email) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("update user set sex=?,age=?,introduce=?,nickname=? ,telephone=?,email=? where user_id=?");
            pstmt.setString(1, sex);
            pstmt.setInt(2, age);
            pstmt.setString(3, introduce);
            pstmt.setString(4, nickname);
            pstmt.setString(5,telephone);
            pstmt.setString(6,email);
            pstmt.setInt(7, id);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int InsertAttention(int uid, int id) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String attention = user.getAttention();
            attention += "," + id + "";
            PreparedStatement pstmt = con.prepareStatement("update user set attention=? where user_i=?");
            pstmt.setString(1, attention);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int InsertCollect(int uid, int id) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String collection = user.getCollection();
            collection += "," + id + "";
            PreparedStatement pstmt = con.prepareStatement("update user set collection=? where user_id=?");
            pstmt.setString(1, collection);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int InsertMysay(int uid, int id) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String mysay = user.getMysay();
            mysay += "," + id + "";
            PreparedStatement pstmt = con.prepareStatement("update user set mysay=? where mysay_id=?");
            pstmt.setString(1, mysay);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }
    public int DeleteComment(int id){
        int cout;
        try {
            con=DBConnection.getConnection();
            DataDB dataDB=new DataDB();
            Statement stmt=con.createStatement();
            cout = stmt.executeUpdate("delete from comment where cmt_id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return cout=0;


    }
    public int DeleteAttention(int uid, int id) {
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String attention = user.getAttention();
            String[] result = attention.split(",");
            System.out.println("result:");
            for (String r : result) {
                System.out.println(r);
            }
            ArrayList<String> attentionlist = new ArrayList<>();
            for (String r : result) {
                attentionlist.add(r);
            }
            System.out.println("删除前的attentionlist:");
            for (String r : attentionlist) {
                System.out.println(r);
            }
            for (int i = 0; i < attentionlist.size(); i++) {
                System.out.println("删除时的attentionlist：" + attentionlist.get(i));
                System.out.println("此时的id:" + id);
                if (MyTools.strToint(attentionlist.get(i)) == id) {
                    attentionlist.remove(i);
                    System.out.println("成功");
                }
                System.out.println("再次成功！");
            }
            System.out.println("删除后的attentionsize:" + attentionlist.size());
            if (attentionlist.size() == 0) {
                attention = "";
            } else {
                String n = "";
                for (String a : attentionlist) {
                    n += "" + a + ",";
                }
                n = n.substring(0, n.length() - 1);
                attention = n;
            }
            System.out.println("attention:" + attention);
            PreparedStatement pstmt = con.prepareStatement("update user set attention=? where user_id=?");
            pstmt.setString(1, attention);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int DeleteCollection(int uid, int id) {
        System.out.println("启动成功");
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String collection = user.getCollection();
            String[] result = collection.split(",");
            System.out.println("result:");
            for (String r : result) {
                System.out.println(r);
            }
            ArrayList<String> collectionlist = new ArrayList<>();
            for (String r : result) {
                collectionlist.add(r);
            }
            System.out.println("删除前的collectionlist:");
            for (String r : collectionlist) {
                System.out.println(r);
            }
            for (int i = 0; i < collectionlist.size(); i++) {
                System.out.println("删除时的collectionlist：" + collectionlist.get(i));
                System.out.println("此时的id:" + id);
                if (MyTools.strToint(collectionlist.get(i)) == id) {
                    collectionlist.remove(i);
                    System.out.println("成功");
                }
                System.out.println("再次成功！");
            }
            System.out.println("删除后的collectionlist:" + collectionlist.size());
            if (collectionlist.size() == 0) {
                collection = "" +
                        "";
            } else {
                String n = "";
                for (String a : collectionlist) {
                    n += "" + a + ",";
                }
                n = n.substring(0, n.length() - 1);
                collection = n;
            }
            System.out.println("attention:" + collection);
            PreparedStatement pstmt = con.prepareStatement("update user set collection=? where user_id=?");
            pstmt.setString(1, collection);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public int DeleteMysay(int uid, int id) {
        DeleteCollection(uid,id);
        System.out.println("启动成功");
        DeleteComment(id);
        int count = 0;
        try {
            con = DBConnection.getConnection();
            DataDB dataDB = new DataDB();
            UserInfo user = new UserInfo();
            user = dataDB.GetUserInfo(uid);
            String mysay = user.getMysay();
            String[] result = mysay.split(",");
            System.out.println("result:");
            for (String r : result) {
                System.out.println(r);
            }
            ArrayList<String> mysaylist = new ArrayList<>();
            for (String r : result) {
                mysaylist.add(r);
            }
            System.out.println("删除前的mysaylist:");
            for (String r : mysaylist) {
                System.out.println(r);
            }
            for (int i = 0; i < mysaylist.size(); i++) {
                System.out.println("删除时的mysaylist：" + mysaylist.get(i));
                System.out.println("此时的id:" + id);
                if (MyTools.strToint(mysaylist.get(i)) == id) {
                    mysaylist.remove(i);
                    System.out.println("成功");
                }
                System.out.println("再次成功！");
            }
            System.out.println("删除后的collectionlist:" + mysaylist.size());
            if (mysaylist.size() == 0) {
                mysay = "";
            } else {
                String n = "";
                for (String a : mysaylist) {
                    n += "" + a + ",";
                }
                n = n.substring(0, n.length() - 1);
                mysay = n;
            }
            System.out.println("attention:" + mysay);
            PreparedStatement pstmt = con.prepareStatement("update user set mysay_id=? where user_id=?");
            pstmt.setString(1, mysay);
            pstmt.setInt(2, uid);
            count = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
        return count;
    }
}
