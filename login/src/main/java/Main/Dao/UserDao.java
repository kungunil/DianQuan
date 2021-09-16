package Main.Dao;

import Main.bean.User;

import java.util.List;

public interface UserDao {
    public User getUserById(int id);
    public List<User> getAllUser();
    public int delUserById(int id);
    public int saveUser(User user);
    public int updateUser(User user);

    public Integer queryForPageTotalCount();

    public List<User> queryForPageItems(int begin, int pageSize);
}
