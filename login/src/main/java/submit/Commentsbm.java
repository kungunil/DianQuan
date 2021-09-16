package submit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import DB.DBTool;
import bean.Comment;

public class Commentsbm {
    public static int storage(Comment usercmt) {
        Connection con = DBTool.getconnect();
        String sql = "insert into comment (user_id,cmttext,pblic,imgname,item1_id,date) values(?,?,?,?,?,?)";
        int pblic = 1;
        int r = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = formatter.format(new Date());

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, usercmt.getUid());
            pstm.setString(2, usercmt.getCmttext());
            if (!usercmt.isPblic()) {
                pblic = 0;
            }
            pstm.setInt(3, pblic);
            pstm.setString(4, usercmt.getImgname());
            pstm.setInt(5, usercmt.getItemid());
            pstm.setString(6, date);

            r = pstm.executeUpdate();
            pstm.close();

            //修改user表中mysay 可改为触发器方式修改
            Statement st = con.createStatement();
            String sql1 = ("select mysay_id from user where user_id="+usercmt.getUid());
            String sql2 = "select cmt_id from comment order by date desc limit 1";

            ResultSet mysayrs = st.executeQuery(sql1);
            String mysay = null;
            if (mysayrs.next()) {
                mysay = mysayrs.getString(1);
            }
            mysayrs.close();

            ResultSet cmtidrs = st.executeQuery(sql2);
            Integer cmtid = 0;
            if (cmtidrs.next()) {
                cmtid = cmtidrs.getInt(1);
            }
            cmtidrs.close();

            String mysaynew = mysay + "," + cmtid.toString();
            String sql3 = ("update user set mysay_id='"+mysaynew+
            "' where user_id="+usercmt.getUid());
            st.executeUpdate(sql3);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeconnect();
            con = null;
        }
        return r;
    }
}
