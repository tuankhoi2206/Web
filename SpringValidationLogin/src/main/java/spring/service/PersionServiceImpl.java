package spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.PersonDAO;
import spring.model.Person;

@Service
public class PersionServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Transactional
	public void addPerson(Person p) {
		personDAO.addPersion(p);
	}

	@Transactional
	public void updatePerson(Person p) {

	}

	@Transactional
	public List<Person> listPersons() {
		return null;
	}

	@Transactional
	public Person getPersonById(int id) {
		return null;
	}

	@Transactional
	public void removePerson(int id) {

	}

}
