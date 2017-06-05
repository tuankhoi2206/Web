package spring.dao;

import java.util.List;

import spring.model.Person;

public interface PersonDAO {
	public void addPersion(Person person);

	public void updatePersion(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
}