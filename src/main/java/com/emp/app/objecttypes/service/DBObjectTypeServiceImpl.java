package com.emp.app.objecttypes.service;

import java.util.List;

import com.emp.app.objecttypes.dao.DBObjectTypeDAO;
import com.emp.app.objecttypes.model.DBObjectType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DBObjectTypeServiceImpl implements DBObjectTypeService {

	private DBObjectTypeDAO dbobjectTypeDAO;

	public void setDbobjectTypeDAO(DBObjectTypeDAO dbobjectTypeDAO) {
		this.dbobjectTypeDAO = dbobjectTypeDAO;
	}

	@Override
	@Transactional
	public void addDBObjectType(DBObjectType p) {
		this.dbobjectTypeDAO.addDBObjectType(p);
	}

	@Override
	@Transactional
	public void updateDBObjectType(DBObjectType p) {
		this.dbobjectTypeDAO.updateDBObjectType(p);
	}

	@Override
	@Transactional
	public List<DBObjectType> listDBObjectTypes() {
		return this.dbobjectTypeDAO.listDBObjectTypes();
	}

	@Override
	@Transactional
	public DBObjectType getDBObjectTypeById(long id) {
		return this.dbobjectTypeDAO.getDBObjectTypeById(id);
	}

	@Override
	@Transactional
	public void removeDBObjectType(long id) {
		this.dbobjectTypeDAO.removeDBObjectType(id);
	}

}
