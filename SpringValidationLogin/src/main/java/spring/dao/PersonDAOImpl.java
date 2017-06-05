package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPersion(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
	}

	public void updatePersion(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
	}

	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Person> personsList = session.createQuery("from Person").list();
		return personsList;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		/*
		 * load ko rút trích một đối tượng trả về khi session bị đóng
		 */
		Person person = (Person) session.load(Person.class, id);
		return person;

	}

	public void removePerson(int id) {
		// TODO Auto-generated method stub

	}

}
