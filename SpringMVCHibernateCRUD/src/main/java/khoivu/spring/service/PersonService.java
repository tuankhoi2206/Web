package khoivu.spring.service;

import java.util.List;

import khoivu.spring.model.Person;

public interface PersonService {

	List<Person> listPersons();

	void addPerson(Person person);

	void removePerson(Integer id);

	void updatePerson(Person person);

	Person findById(Integer id);

	void saveOrUpdate(Person person);
}
