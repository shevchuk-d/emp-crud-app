package com.emp.app.params.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;
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
public class ParamsDAOImpl implements ParamsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addParams(Params p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateParams(Params p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Params> listParams(long objectId) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "select p from Params as p where p.objectId = :objectId ";
		List<Params> paramsList = session.createQuery(q).setParameter("objectId", objectId).list();
		for(Params p : paramsList){
			logger.info("Person List::"+p);
		}
		return paramsList;
	}

	@Override
	public Params getParamsById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Params p = (Params) session.load(Params.class, new Long(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeParams(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "delete from Params as p where p.paramsPK.objectId = :objectId ";

		session.createQuery(q).setParameter("objectId", new Long(id)).executeUpdate();
//		Params p = (Params) session.load(Params.class, new Long(id));
//		if(null != p){
//			session.delete(p);
//		}
//		logger.info("Person deleted successfully, person details="+p);
	}

}
