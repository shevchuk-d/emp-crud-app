package com.emp.app.employees.departments.dao;

import com.emp.app.employees.departments.model.Departments;

import java.util.List;

public interface DepartmentsDAO {

	public void addDepartment(Departments p);
	public void updateDepartment(Departments p);
	public List<Departments> listDepartment();
	public Departments getDepartmentById(int id);
	public void removeDepartment(int id);
}
