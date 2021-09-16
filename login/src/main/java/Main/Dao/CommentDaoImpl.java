package Main.Dao;

import Main.bean.Comment;
import Main.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Comment getCmtById(int id) {
        String sql= "select * from `comment` where cmt_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Comment>(Comment.class) );
    }

    @Override
    public List<Comment> getAllComments() {
        String sql = "select * from `comment`";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Comment>(Comment.class));
    }

    @Override
    public int delCmtById(int id) {

        String sql1 = ("select user_id from comment where cmt_id ="+id);
        int uid = jdbcTemplate.queryForObject(sql1,int.class);
        String sql2 = ("select mysay_id from user where user_id="+uid);
        String oldmysay = jdbcTemplate.queryForObject(sql2,String.class);

        System.out.println("oldmysay="+oldmysay);
        String[] temp = oldmysay.split(",");
        ArrayList<String> att = new ArrayList<String>(Arrays.asList(temp));
        att.remove(""+id);
        String newmysay = String.join(",", att);
        System.out.println("newmysay="+newmysay);

        String sql3 = ("update user set mysay_id = '"+newmysay+"' where user_id = "+uid);
        jdbcTemplate.update(sql3);

        String sql = "delete from `comment` where cmt_id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int saveComment(Comment comment) {
        String sql = "insert into `comment` values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,comment.getCmt_id(),comment.getUser_id(),comment.getCmttext(),comment.getPblic(),comment.getImgname(),
                comment.getItem1_id(),comment.getDate());
    }

    @Override
    public int updateCmt(Comment cmt) {
        String sql = "update `comment` set `cmttext`=?,`pblic`=?,`imgname`=?,`item1_id`=?,`date`=? where `cmt_id`=?";
        return jdbcTemplate.update(sql,cmt.getCmttext(),cmt.getPblic(),cmt.getImgname(),cmt.getItem1_id(),cmt.getDate(),cmt.getCmt_id());

    }
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from `comment`";
        return jdbcTemplate.queryForObject(sql,int.class);
    }

    @Override
    public List<Comment> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from `comment` limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Comment>(Comment.class),begin,pageSize);
    }

}
