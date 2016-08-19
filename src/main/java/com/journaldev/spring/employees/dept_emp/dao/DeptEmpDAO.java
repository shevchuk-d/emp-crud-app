package com.journaldev.spring.employees.dept_emp.dao;

import com.journaldev.spring.employees.dept_emp.model.DeptEmp;
import com.journaldev.spring.persons.model.Person;

import java.util.List;

public interface DeptEmpDAO {
	public void addDeptEmp(DeptEmp deptEmp);
	public void updateDeptEmp(DeptEmp deptEmp);
	public List<DeptEmp> listDeptEmps();
	public DeptEmp getDeptEmpById(int id);
	public void removeDeptEmp(int id);
}
