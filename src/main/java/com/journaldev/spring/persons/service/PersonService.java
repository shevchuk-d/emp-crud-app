package com.journaldev.spring.persons.service;

import java.util.List;

import com.journaldev.spring.persons.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
