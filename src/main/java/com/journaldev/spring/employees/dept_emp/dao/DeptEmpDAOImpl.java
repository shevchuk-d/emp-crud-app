package com.journaldev.spring.employees.dept_emp.dao;

import com.journaldev.spring.employees.dept_emp.model.DeptEmp;
import com.journaldev.spring.persons.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptEmpDAOImpl implements DeptEmpDAO {

	private static final Logger logger = LoggerFactory.getLogger(DeptEmpDAO.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDeptEmp(DeptEmp p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDeptEmp(DeptEmp p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeptEmp> listDeptEmps() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DeptEmp> personsList = session.createQuery("from dep_temp").list();
		for(DeptEmp p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public DeptEmp getDeptEmpById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DeptEmp p = (DeptEmp) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeDeptEmp(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DeptEmp p = (DeptEmp) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
