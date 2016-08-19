package com.emp.app.employees.titles.dao;

import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface TitlesDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
}
