package com.journaldev.spring.employees.employees.dao;

import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface EmployeesDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
}
