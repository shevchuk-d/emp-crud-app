package com.emp.app.objecttypes.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objecttypes.model.DBObjectType;

public interface DBObjectTypeDAO {

	public void addDBObjectType(DBObjectType p);
	public void updateDBObjectType(DBObjectType p);
	public List<DBObjectType> listDBObjectTypes();
	public DBObjectType getDBObjectTypeById(long id);
	public void removeDBObjectType(long id);
}
