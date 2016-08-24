package com.emp.app.objecttypes.service;

import java.util.List;

import com.emp.app.objecttypes.dao.DBObjectTypeDAO;
import com.emp.app.objecttypes.model.DBObjectType;

public interface DBObjectTypeService {

	public void addDBObjectType(DBObjectType p);
	public void updateDBObjectType(DBObjectType p);
	public List<DBObjectType> listDBObjectTypes();
	public DBObjectType getDBObjectTypeById(long id);
	public void removeDBObjectType(long id);
	
}
