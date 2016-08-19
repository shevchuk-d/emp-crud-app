package com.journaldev.spring.employees.departments.service;

import com.journaldev.spring.employees.departments.model.Departments;
import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface DepartmentsService {

	public void addDepartments(Departments p);
	public void updateDepartments(Departments p);
	public List<Departments> listDepartments();
	public Departments getDepartmentsById(int id);
	public void removeDepartments(int id);
	
}
