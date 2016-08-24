package com.emp.app.objects.service;

import java.util.List;

import com.emp.app.objects.dao.DBObjectDAO;
import com.emp.app.objects.model.DBObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DBObjectServiceImpl implements DBObjectService {

	private DBObjectDAO dbobjectDAO;

	public void setDbObjectDAO(DBObjectDAO dbObjectDAO) {
		this.dbobjectDAO = dbObjectDAO;
	}

	@Override
	@Transactional
	public void addDBObject(DBObject p) {
		this.dbobjectDAO.addDBObject(p);
	}

	@Override
	@Transactional
	public void updateDBObject(DBObject p) {
		this.dbobjectDAO.updateDBObject(p);
	}

	@Override
	@Transactional
	public List<DBObject> listDBObjects() {
		return this.dbobjectDAO.listDBObjects();
	}

	@Override
	@Transactional
	public DBObject getDBObjectById(long id) {
		return this.dbobjectDAO.getDBObjectById(id);
	}

	@Override
	@Transactional
	public void removeDBObject(long id) {
		this.dbobjectDAO.removeDBObject(id);
	}

}
