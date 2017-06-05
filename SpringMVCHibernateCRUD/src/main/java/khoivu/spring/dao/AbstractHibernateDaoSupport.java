package khoivu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AbstractHibernateDaoSupport extends HibernateDaoSupport {

	/*
	 * Khai báo như vầy ko có method gán làm sao sử dụng biến??? mặc định khi sử
	 * dụng hibernateDao phải set sessionfactory theo constructor hoặc method
	 */
	/*
	 * @Autowired private SessionFactory sessionFactory; public
	 * AbstractHibernateDaoSupport() { super();
	 * setSessionFactory(sessionFactory); }
	 */

	@Autowired
	public void injectSessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
