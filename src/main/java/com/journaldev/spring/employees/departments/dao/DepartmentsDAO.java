package com.journaldev.spring.employees.departments.dao;

import com.journaldev.spring.employees.departments.model.Departments;
import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface DepartmentsDAO {

	public void addDepartment(Departments p);
	public void updateDepartment(Departments p);
	public List<Departments> listDepartment();
	public Departments getDepartmentById(int id);
	public void removeDepartment(int id);
}
