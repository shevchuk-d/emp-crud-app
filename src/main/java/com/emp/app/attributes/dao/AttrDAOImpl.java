package com.emp.app.attributes.dao;

import java.util.List;

import com.emp.app.attributes.model.Attr;
import com.emp.app.objects.model.DBObject;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class AttrDAOImpl implements AttrDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AttrDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDBObject(Attr p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDBObject(Attr p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> listDBObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "select o from Objects as o join o.dbObjectType where o.name like 'A%'";
		List<Attr> objectsList = session.createQuery(q).setMaxResults(10).list();
		for(Attr p : objectsList){
			logger.info("Person List::"+p);
		}
		return objectsList;
	}

	@Override
	public Attr getDBObjectById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Attr p = (Attr) session.load(DBObject.class, new Long(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeDBObject(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Attr p = (Attr) session.load(DBObject.class, new Long(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listExtendedDBObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		String q2 = "select o, o.dbObjectType from Objects as o join o.dbObjectType where o.name like 'A%' ";
		return (List<Object[]>) session.createQuery(q2).setMaxResults(25).list();
	}

}
