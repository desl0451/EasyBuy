package cn.easybuy.dao.user;

import cn.easybuy.entity.User;
import cn.easybuy.utils.Pager;

import java.util.List;

public interface UserDao {
    public int AddUser(User user);

    public int DeleteUser(User user);

    public int UpdateUser(User user);

    public List<User> findAll();

    public User login(String username, String password);

    public User findUserName(String username);

    public int count();//返回记录数量

    public List<User> queryUserList(User user, Pager pager);
}
