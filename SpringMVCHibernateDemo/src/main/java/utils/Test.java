package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entities.Batch;
import entities.Student;

@Transactional
public class Test extends HibernateDaoSupport {

	public boolean save() {
		try {
			getHibernateTemplate().save(
					new Student("S005", new Batch(2, "Batch 3"), "K Test"));
			getHibernateTemplate().save(new Batch(3, "Batch 3"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
