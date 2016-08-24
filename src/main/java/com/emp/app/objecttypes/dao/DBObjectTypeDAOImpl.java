package com.emp.app.objecttypes.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objecttypes.model.DBObjectType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class DBObjectTypeDAOImpl implements DBObjectTypeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DBObjectTypeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDBObjectType(DBObjectType p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDBObjectType(DBObjectType p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DBObjectType> listDBObjectTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DBObjectType> objectsList = session.createQuery("from Object_types").setMaxResults(10).list();
		for(DBObjectType p : objectsList){
			logger.info("Person List::"+p);
		}
		return objectsList;
	}

	@Override
	public DBObjectType getDBObjectTypeById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		DBObjectType p = (DBObjectType) session.load(DBObject.class, id);
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeDBObjectType(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		DBObjectType p = (DBObjectType) session.load(DBObjectType.class, id);
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
