package Main.Dao;

import Main.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(int id) {
        String sql= "select * from `user` where `user_id` = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id },  new BeanPropertyRowMapper<User>(User.class) );
    }

    @Override
    public List<User> getAllUser() {
        String sql = "select * from `user`";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public int delUserById(int id) {
        String sql = "delete from `user` where `user_id` = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update `user` set `username`=?,`password`=?,`telephone`=?,`email`=?,`question`=?,`answer`=?,`type`=?,`nickname`=?,`attention`=?,`collection`=?,`mysay_id`=?,`age`=?,`sex`=?,`introduce`=? where `user_id`=?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getTelephone(),user.getEmail(), user.getQuestion(), user.getAnswer(),
                user.getType(), user.getNickname(), user.getAttention(), user.getCollection(), user.getMysay_id(),user.getAge(), user.getSex(),
                user.getIntroduce(), user.getUser_id());
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from `user`";
        return jdbcTemplate.queryForObject(sql,int.class);
    }

    @Override
    public List<User> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from `user` limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),begin,pageSize);
    }


}
