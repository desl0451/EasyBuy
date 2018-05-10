package cn.easybuy.service.user;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.entity.User;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.SecurityUtils;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        SecurityUtils security = new SecurityUtils();
        password = security.md5Hex(password);
        return userDao.login(username, password);
    }

    @Override
    public User findUserName(String username) {
        return userDao.findUserName(username);
    }

    @Override
    public List<User> queryUserList(User user, Pager pager) {
        return userDao.queryUserList(user, pager);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public int AddUser(User user) {
        // TODO Auto-generated method stub
        return userDao.AddUser(user);
    }

    @Override
    public int DeleteUser(User user) {
        // TODO Auto-generated method stub
        return userDao.DeleteUser(user);
    }

    @Override
    public int UpdateUser(User user) {
        // TODO Auto-generated method stub
        return userDao.UpdateUser(user);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userDao.findAll();
    }

}
