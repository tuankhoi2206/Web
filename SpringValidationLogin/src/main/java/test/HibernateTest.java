package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

import spring.model.Person;
import utils.HibernateUtils;

public class HibernateTest {
	public static void main(String[] args) {

		// PersonDAOImpl daoImpl = new PersonDAOImpl();
		// daoImpl.setSessionFactory(HibernateUtils.getSessionFactory());
		//
		// System.out.println(daoImpl.getPersonById(1).getName());

		Session session = HibernateUtils.getSessionFactory()
				.getCurrentSession();

		session.getTransaction().begin();

		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.eq("id", 1));

		System.out.println(((Person) criteria.uniqueResult()).getName());

		session.beginTransaction().commit();

	}
}
