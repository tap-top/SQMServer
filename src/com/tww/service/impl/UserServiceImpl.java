package com.tww.service.impl;
import java.util.List;
import com.tww.entity.User;
import com.tww.dao.UserDao;
import com.tww.service.UserService;
public class UserServiceImpl implements UserService {
	private UserDao UserDao;
	public UserDao getUserDao() {
		return UserDao;
	}
	public void setUserDao(UserDao UserDao) {
		this.UserDao = UserDao;
	}
	public void save(User user) {
		this.UserDao.saveUser(user);
	}
	public List<User> findAll() {
		return this.UserDao.findAllUsers();
	}
	public void delete(User user) {
		this.UserDao.removeUser(user);
	}
	public void update(User user) {
		this.UserDao.updateUser(user);
	}
	public User findById(Integer id) {
		return this.UserDao.findUserById(id);
	}
	public User loginUser(User user) {
		return this.UserDao.loginUser(user);
	}

}