package com.emp.app.objects.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class DBObjectDAOImpl implements DBObjectDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DBObjectDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDBObject(DBObject p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDBObject(DBObject p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DBObject> listDBObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "select o from Objects as o join o.dbObjectType where o.name like 'A%'";
		List<DBObject> objectsList = session.createQuery(q).setMaxResults(10).list();
		for(DBObject p : objectsList){
			logger.info("Person List::"+p);
		}
		return objectsList;
	}

	@Override
	public DBObject getDBObjectById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		DBObject p = (DBObject) session.load(DBObject.class, new Long(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeDBObject(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		DBObject p = (DBObject) session.load(DBObject.class, new Long(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listExtendedDBObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		String q2 =
				"select " +
						"o, " +
						"first_name.value, " +
						"last_name.value, " +
						"gender.value, " +
						"department.value, " +
						"hire_date.value, " +
						"is_manager.value " +
				"from Objects as o " +
						"join o.paramsList as gender " +
						"join o.paramsList as is_manager " +
						"join o.paramsList as first_name " +
						"join o.paramsList as last_name " +
						"join o.paramsList as hire_date " +
						"join o.paramsList as department " +
						"where is_manager.attr.name = 'Is Manager' " +
						"and gender.attr.name = 'Gender' " +
						"and first_name.attr.name = 'First Name' " +
						"and department.attr.name = 'Department' " +
						"and hire_date.attr.name = 'Hire Date' " +
						"and last_name.attr.name = 'Last Name' "
				;
		return (List<Object[]>) session.createQuery(q2).setMaxResults(10).list();
	}

}
