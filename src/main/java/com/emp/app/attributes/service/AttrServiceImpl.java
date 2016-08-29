package com.emp.app.attributes.service;

import java.util.List;


import com.emp.app.attributes.dao.AttrDAO;
import com.emp.app.attributes.model.Attr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AttrServiceImpl implements AttrService {

	private AttrDAO dbobjectDAO;

	public void setDbObjectDAO(AttrDAO dbObjectDAO) {
		this.dbobjectDAO = dbObjectDAO;
	}

	@Override
	@Transactional
	public void addDBObject(Attr p) {
		this.dbobjectDAO.addDBObject(p);
	}

	@Override
	@Transactional
	public void updateDBObject(Attr p) {
		this.dbobjectDAO.updateDBObject(p);
	}

	@Override
	@Transactional
	public List<Attr> listDBObjects() {
		return this.dbobjectDAO.listDBObjects();
	}

	@Override
	@Transactional
	public Attr getDBObjectById(long id) {
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
