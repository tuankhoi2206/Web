package utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AbstractHibernateDAOSupport extends HibernateDaoSupport {

	@Autowired
	public void injectSessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
