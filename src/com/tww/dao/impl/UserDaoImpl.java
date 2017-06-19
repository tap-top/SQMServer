package com.tww.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.tww.entity.User;
import com.tww.dao.UserDao;
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}
	public List<User> findAllUsers() {
		String hql = "from User user order by user.userid desc";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}
	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}
	public User findUserById(Integer id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);

		return user;
	}
	public User loginUser(User user) {
		String hql = "from User user where user.username='"
				+ user.getUsername() + "' and user.userpassword='"
				+ user.getUserpassword() + "'";
		List<User> users = (List<User>) this.getHibernateTemplate().find(hql);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
