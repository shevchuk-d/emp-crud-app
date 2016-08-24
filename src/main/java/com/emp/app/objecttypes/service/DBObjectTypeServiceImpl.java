package com.emp.app.objecttypes.service;

import java.util.List;

import com.emp.app.objecttypes.dao.DBObjectTypeDAO;
import com.emp.app.objecttypes.model.DBObjectType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DBObjectTypeServiceImpl implements DBObjectTypeService {

	private DBObjectTypeDAO dbObjectTypeDAO;

	public void setDbObjectTypeDAO(DBObjectTypeDAO dbObjectTypeDAO) {
		this.dbObjectTypeDAO = dbObjectTypeDAO;
	}

	@Override
	@Transactional
	public void addDBObjectType(DBObjectType p) {
		this.dbObjectTypeDAO.addDBObjectType(p);
	}

	@Override
	@Transactional
	public void updateDBObjectType(DBObjectType p) {
		this.dbObjectTypeDAO.updateDBObjectType(p);
	}

	@Override
	@Transactional
	public List<DBObjectType> listDBObjectTypes() {
		return this.dbObjectTypeDAO.listDBObjectTypes();
	}

	@Override
	@Transactional
	public DBObjectType getDBObjectTypeById(long id) {
		return this.dbObjectTypeDAO.getDBObjectTypeById(id);
	}

	@Override
	@Transactional
	public void removeDBObjectType(long id) {
		this.dbObjectTypeDAO.removeDBObjectType(id);
	}

}
