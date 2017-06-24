package edu.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.dao.ILogDao;
import edu.po.TLog;

public class LogDaoImpl extends HibernateDaoSupport implements ILogDao {

	@Override
	public void save(TLog log) throws Exception {
		this.getHibernateTemplate().save(log);
	}

}
