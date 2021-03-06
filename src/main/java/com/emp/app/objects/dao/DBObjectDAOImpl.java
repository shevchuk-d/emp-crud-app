package com.emp.app.objects.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;
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
		System.out.println(p.toString());
		System.out.println(p);
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateDBObject(DBObject p) {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "update Objects as o set o.objectId = :objectId, o.objectTypeId = :objectTypeId, o.name = :name where o.objectId = :objectId";
		session.createQuery(q).setLong("objectId", p.getObjectId())
				.setLong("objectTypeId", p.getObjectTypeId())
				.setParameter("name", p.getName())
				.executeUpdate();
//		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DBObject> listDBObjects() {
		Session session = this.sessionFactory.getCurrentSession();
		String q = "select o from Objects as o where o.name like 'A%'";
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
//						+ "order by o.objectId desc "
				;
		return (List<Object[]>) session.createQuery(q2).setMaxResults(10).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listExtendedDBObjects(int limit) {
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
//						+ "order by o.objectId desc "
				;
		return (List<Object[]>) session.createQuery(q2).setMaxResults(limit).list();
	}

}
