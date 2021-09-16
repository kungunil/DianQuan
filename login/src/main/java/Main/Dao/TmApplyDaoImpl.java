package Main.Dao;

import Main.bean.ItemApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TmApplyDaoImpl implements TmApplyDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveApply(ItemApply tm) {
        String sql = "insert into `itemapply` values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,tm.getApply_id(),tm.getTitle(),tm.getIntroduction(),tm.getUsername(),tm.getDate(),tm.getStatements(),tm.getUser_id());
    }

    @Override
    public List<ItemApply> getAllApply() {
        String sql = "select * from `itemapply`";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ItemApply>(ItemApply.class));
    }

    @Override
    public ItemApply getById(Integer id) {
        String sql= "select * from `itemapply` where apply_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<ItemApply>(ItemApply.class) );
    }

    @Override
    public void applyDelById(Integer id) {
        String sql = "delete from `itemapply` where apply_id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateApply(ItemApply apply) {
        String sql = "update `itemapply` set `title`=?,`introduction`=?,`date`=?,`statements`=?,`user_id`=? where `apply_id`=?";
        return jdbcTemplate.update(sql,apply.getTitle(),apply.getIntroduction(),apply.getDate(), apply.getStatements(),apply.getUser_id(), apply.getApply_id());
    }

    @Override
    public boolean queryByTmname(String tmname) {
        String sql = "select count(*) from `itemapply` where `title` = ?";
        return jdbcTemplate.queryForObject(sql,new Object[] { tmname },boolean.class);
    }
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from `itemapply`";
        return jdbcTemplate.queryForObject(sql,int.class);
    }

    @Override
    public List<ItemApply> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from `itemapply` limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ItemApply>(ItemApply.class),begin,pageSize);
    }
}
