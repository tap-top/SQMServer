package com.tww.service;
import java.util.List;
import com.tww.entity.User;
public interface UserService {
	public void save(User user);
	public List<User> findAll();
	public void delete(User user);
	public void update(User user);
	public User findById(Integer id);
	public User loginUser(User user);
}
