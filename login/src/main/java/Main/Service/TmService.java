package Main.Service;


import Main.Dao.TmApplyDao;
import Main.Dao.TmManagerDao;
import Main.bean.Item;
import Main.bean.ItemApply;
import Main.bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TmService {

    @Autowired
    private TmApplyDao tmApplyDao;
    @Autowired
    private TmManagerDao tmManagerDao;

    public int saveApply(ItemApply tm){
        return tmApplyDao.saveApply(tm);
    }

    public List<ItemApply> getAllApply(){
        return tmApplyDao.getAllApply();
    }

    public ItemApply applyGetById(Integer id){
        return tmApplyDao.getById(id);
    }

    public Item managerGetById(Integer id){
        return tmManagerDao.getById(id);
    }

    public void applyDelById(int id){ tmApplyDao.applyDelById(id);}

    public List<Item> ManagerAllTm() {
        return tmManagerDao.managerAllTm();
    }

    public void managerDelById(int id) {
        tmManagerDao.managerDelById(id);
    }

    public void savaTm(ItemApply tm) {
        tmManagerDao.saveTm(tm);
    }

    public int updateApply(ItemApply apply) {
        return tmApplyDao.updateApply(apply);
    }

    public int updateManager(Item item) {
        return tmManagerDao.updateManager(item);
    }

    public boolean existsTmname(String tmname) {
        return tmApplyDao.queryByTmname(tmname);
    }

    public Page<Item> pageManager(int pageNo, int pageSize) {

        Page<Item> page = new Page<Item>();

        page.setPageSize(pageSize);

        Integer pageTotalCount  = tmManagerDao.queryForPageTotalCount();

        Integer pageTotal = pageTotalCount / pageSize;

        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }

        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageTotalCount(pageTotalCount);

        int begin = (page.getPageNo() - 1 ) * pageSize;

        List<Item> items = tmManagerDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    public Page<ItemApply> pageApplys(int pageNo, int pageSize) {
        Page<ItemApply> page = new Page<ItemApply>();
        if(pageSize>8){
            page.setPageSize(8);
        }else{
            page.setPageSize(pageSize);
        }

        Integer pageTotalCount  = tmApplyDao.queryForPageTotalCount();
        Integer pageTotal = pageTotalCount / pageSize;

        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }

        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageTotalCount(pageTotalCount);

        int begin = (page.getPageNo() - 1 ) * pageSize;

        List<ItemApply> applys = tmApplyDao.queryForPageItems(begin,pageSize);
        page.setItems(applys);

        return page;
    }
}
