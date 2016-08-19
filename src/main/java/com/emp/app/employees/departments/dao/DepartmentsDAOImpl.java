package com.emp.app.employees.departments.dao;

import com.emp.app.employees.departments.model.Departments;
import com.emp.app.persons.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentsDAOImpl implements DepartmentsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentsDAO.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDepartment(Departments p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDepartment(Departments p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> listDepartment() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Departments> personsList = session.createQuery("from Departments").list();
		for(Departments p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Departments getDepartmentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Departments p = (Departments) session.load(Departments.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeDepartment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Departments p = (Departments) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
