package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AbstractHibernateDaoSupport extends HibernateDaoSupport {

	@Autowired
	public void setDefaultSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

}
