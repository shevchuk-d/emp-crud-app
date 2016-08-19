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
		List<DBObject> objectsList = session.createQuery("from Objects").list();
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

}
