package com.emp.app.employees.dept_emp.service;

import com.emp.app.persons.model.Person;
import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface DeptEmpService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}