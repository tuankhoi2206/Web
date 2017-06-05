package khoivu.spring.dao;

import java.util.List;

import khoivu.spring.model.Person;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * @Repository: dùng để đánh dấu các lớp DAO của Spring. Mọi truy cập dữ liệu
 *              logic tới cơ sở dữ liệu cần phải đặt trong các lớp DAO
 */

@Repository
public class PersonDAOImpl extends AbstractHibernateDaoSupport implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		List<Person> lst = (List<Person>) getHibernateTemplate().find("from Person");
		logger.info("Query list person successfully : " + lst.size());
		return lst;
	}

	@Override
	public void addPerson(Person person) {
		try {
			getHibernateTemplate().setCheckWriteOperations(false);
			getHibernateTemplate().save(person);
			logger.info("Person saved successfully, Person Details=" + person);
		} catch (DataAccessException e) {
			logger.info("Failed to add person '{}' and detail error '{}'", person, e);
		}
	}

	@Override
	public void removePerson(Integer id) {
		getHibernateTemplate().setCheckWriteOperations(false);
		Query query = getSessionFactory().openSession().createQuery("delete Person where id=:id");
		query.setInteger("id", id);
		query.executeUpdate();
		logger.info("Person remove successfully, Person Details=" + id);
	}

	@Override
	public void updatePerson(Person person) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().saveOrUpdate(person);
		logger.info("Person update successfully, Person Details=" + person);
	}

	@Override
	public Person findById(Integer id) {
		Session session = getSessionFactory().openSession();
		Person person = (Person) session.get(Person.class, id);
		session.close();
		return person;
	}

	@Override
	public void saveOrUpdate(Person person) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().saveOrUpdate(person);
		logger.info("Person saveOrUpdate successfully, Person Details=" + person);
	}

}
