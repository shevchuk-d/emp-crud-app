package com.emp.app.objects.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;

public interface DBObjectDAO {

	public void addDBObject(DBObject p);
	public void updateDBObject(DBObject p);
	public List<DBObject> listDBObjects();

	public DBObject getDBObjectById(long id);
	public void removeDBObject(long id);

	public List<Object[]> listExtendedDBObjects();
}
