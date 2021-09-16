package Main.Dao;

import Main.bean.Item;
import Main.bean.ItemApply;

import java.util.List;

public interface TmManagerDao {
    public void managerDelById(int id);

    public void saveTm(ItemApply tm);

    public List<Item> managerAllTm();

    public Item getById(Integer id);

    public int updateManager(Item item);

    public List<Item> queryForPageItems(int begin, int pageSize);
    public Integer queryForPageTotalCount();
}
