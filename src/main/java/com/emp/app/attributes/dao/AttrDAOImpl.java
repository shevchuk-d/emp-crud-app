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
	public void addAttr(Attr p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateAttr(Attr p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> listAttrs() {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "select a from Attributes as a join a.dbObjectType";
		List<Attr> attrsList = session.createQuery(q).setMaxResults(10).list();
		for(Attr p : attrsList){
			logger.info("Person List::"+p);
		}
		return attrsList;
	}

	@Override
	public Attr getAttrById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Attr p = (Attr) session.load(DBObject.class, new Long(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeAttr(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Attr p = (Attr) session.load(DBObject.class, new Long(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
}
