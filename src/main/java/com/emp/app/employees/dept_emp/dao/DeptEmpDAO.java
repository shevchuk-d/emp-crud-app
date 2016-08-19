package com.emp.app.employees.dept_emp.dao;

import com.emp.app.employees.dept_emp.model.DeptEmp;

import java.util.List;

public interface DeptEmpDAO {
	public void addDeptEmp(DeptEmp deptEmp);
	public void updateDeptEmp(DeptEmp deptEmp);
	public List<DeptEmp> listDeptEmps();
	public DeptEmp getDeptEmpById(int id);
	public void removeDeptEmp(int id);
}
