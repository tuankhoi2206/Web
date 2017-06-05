package khoivu.spring.service;

import java.util.List;

import khoivu.spring.dao.PersonDAO;
import khoivu.spring.model.Person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public List<Person> listPersons() {
		return personDAO.listPersons();
	}

	@Override
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	@Override
	@Transactional
	public void removePerson(Integer id) {
		personDAO.removePerson(id);
	}

	@Override
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}

	@Override
	public Person findById(Integer id) {
		return personDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Person person) {
		personDAO.saveOrUpdate(person);
	}

}
