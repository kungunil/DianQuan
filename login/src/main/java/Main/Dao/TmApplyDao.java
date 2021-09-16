package Main.Dao;

import Main.bean.ItemApply;

import java.util.List;

public interface TmApplyDao {
    //储存申请条目信息到数据库
    public int saveApply(ItemApply tm);

    public List<ItemApply> getAllApply();

    public ItemApply getById(Integer id);

    public void applyDelById(Integer id);

    public int updateApply(ItemApply apply);

    public boolean queryByTmname(String tmname);

    public List<ItemApply> queryForPageItems(int begin, int pageSize);
    public Integer queryForPageTotalCount();


}
