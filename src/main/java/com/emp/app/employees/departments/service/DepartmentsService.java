package com.emp.app.employees.departments.service;

import com.emp.app.employees.departments.model.Departments;

import java.util.List;

public interface DepartmentsService {

	public void addDepartments(Departments p);
	public void updateDepartments(Departments p);
	public List<Departments> listDepartments();
	public Departments getDepartmentsById(int id);
	public void removeDepartments(int id);
	
}
