package Main.Service;

import Main.Dao.UserDao;
import Main.bean.Page;
import Main.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘涛
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserById(int id){
        return userDao.getUserById(id);
    }
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
    public int delUserById(int id){
        return userDao.delUserById(id);
    }
    public int saveUser(User user){
        return userDao.saveUser(user);
    }
    public int updateUser(User user){
        return userDao.updateUser(user);
    }

    public Page<User> page(int pageNo, int pageSize) {
        Page<User> page = new Page<User>();
        if(pageSize>8){
            page.setPageSize(8);
        }else{
            page.setPageSize(pageSize);
        }

        Integer pageTotalCount  = userDao.queryForPageTotalCount();
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
        System.out.println(begin);

        List<User> users = userDao.queryForPageItems(begin,pageSize);
        page.setItems(users);

        return page;
    }

}
