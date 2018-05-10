package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.User;
import cn.easybuy.utils.Pager;

public interface UserService {
	public int AddUser(User user);

	public int DeleteUser(User user);

	public int UpdateUser(User user);

	public List<User> findAll();

	public User login(String username, String password);

	public User findUserName(String username);

	public int count();//返回记录数量

	public List<User> queryUserList(User user, Pager pager);
}
