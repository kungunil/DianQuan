package Main.Dao;

import Main.bean.Item;
import Main.bean.ItemApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TmManagerDaoImpl implements TmManagerDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void managerDelById(int id) {
        String sql = "delete from `item` where item_id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void saveTm(ItemApply tm) {
        String sql = "insert into `item` values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,tm.getApply_id(),tm.getTitle(),tm.getIntroduction(),tm.getUsername(),tm.getDate(),tm.getUser_id());
    }

    @Override
    public List<Item> managerAllTm() {
        String sql = "select * from `item`";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Item>(Item.class));
    }

    @Override
    public Item getById(Integer id) {
        String sql= "select * from `item` where item_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Item>(Item.class) );
    }

    @Override
    public int updateManager(Item item) {
        String sql = "update `item` set `title`=?,`introduction`=?,`date`=? where `item_id`=?";
        return jdbcTemplate.update(sql,item.getTitle(),item.getIntroduction(),item.getDate(),item.getItem_id());
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from `item`";
        return jdbcTemplate.queryForObject(sql,int.class);
    }

    @Override
    public List<Item> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from `item` limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Item>(Item.class),begin,pageSize);
    }
}
