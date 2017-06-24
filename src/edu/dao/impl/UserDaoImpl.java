package edu.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.dao.UserDao;
import edu.po.Users;

public class UserDaoImpl extends HibernateDaoSupport  implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return (List<Users>)this.getHibernateTemplate().find("from Users");
	}

	@Override
	public Users findById(Integer id) {
		// TODO Auto-generated method stub
		return (Users)this.getHibernateTemplate().get(Users.class, id);
	}

	@Override
	public void save(Users user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(Users user) {
		this.getHibernateTemplate().update(user);

	}

	@Override
	public void delete(Users user) {
		this.getHibernateTemplate().delete(user);

	}

	@Override
	public Users findByUserName(String userName) {
		List<Users> userList = (List<Users>) this.getHibernateTemplate().find(" from Users where username ="+userName);
		if(userList == null || userList.isEmpty()){
			return null;
		}else{
			return userList.get(0);
		}
	}

}
