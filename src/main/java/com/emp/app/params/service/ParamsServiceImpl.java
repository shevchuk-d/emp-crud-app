package com.emp.app.params.service;

import java.util.List;

import com.emp.app.objects.dao.DBObjectDAO;
import com.emp.app.objects.model.DBObject;
import com.emp.app.params.dao.ParamsDAO;
import com.emp.app.params.model.Params;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ParamsServiceImpl implements ParamsService {

	private ParamsDAO dbobjectDAO;

	public void setDbObjectDAO(ParamsDAO dbObjectDAO) {
		this.dbobjectDAO = dbObjectDAO;
	}

	@Override
	@Transactional
	public void addDBObject(Params p) {
		this.dbobjectDAO.addDBObject(p);
	}

	@Override
	@Transactional
	public void updateDBObject(Params p) {
		this.dbobjectDAO.updateDBObject(p);
	}

	@Override
	@Transactional
	public List<Params> listDBObjects() {
		return this.dbobjectDAO.listDBObjects();
	}

	@Override
	@Transactional
	public Params getDBObjectById(long id) {
		return this.dbobjectDAO.getDBObjectById(id);
	}

	@Override
	@Transactional
	public void removeDBObject(long id) {
		this.dbobjectDAO.removeDBObject(id);
	}

	@Override
	@Transactional
	public List<Object[]> listExtendedDBObjects() {
		return this.dbobjectDAO.listExtendedDBObjects();
	}
}
