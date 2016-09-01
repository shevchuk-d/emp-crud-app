package com.emp.app.objects.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;

public interface DBObjectDAO {

	void addDBObject(DBObject p);
	void updateDBObject(DBObject p);
	List<DBObject> listDBObjects();

	DBObject getDBObjectById(long id);
	void removeDBObject(long id);

	List<Object[]> listExtendedDBObjects();

	@SuppressWarnings("unchecked")
	List<Object[]> listExtendedDBObjects(int limit);
}
