package com.journaldev.spring.employees.departments.service;

import com.journaldev.spring.employees.departments.dao.DepartmentsDAO;
import com.journaldev.spring.employees.departments.model.Departments;
import com.journaldev.spring.persons.dao.PersonDAO;
import com.journaldev.spring.persons.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
	
	private DepartmentsDAO departmentsDAO;

	public void setDepartmentsDAO(DepartmentsDAO departmentsDAO) {
		this.departmentsDAO = departmentsDAO;
	}

	@Override
	@Transactional
	public void addDepartments(Departments p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updateDepartments(Departments p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Departments> listDepartments() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Departments getDepartmentsById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removeDepartments(int id) {
		this.personDAO.removePerson(id);
	}

}
