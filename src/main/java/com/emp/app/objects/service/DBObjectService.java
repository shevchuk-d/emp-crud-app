package com.emp.app.objects.service;

import java.util.List;

import com.emp.app.objects.model.DBObject;

public interface DBObjectService {

	void addDBObject(DBObject p);
	void updateDBObject(DBObject p);
	List<DBObject> listDBObjects();
	DBObject getDBObjectById(long id);
	void removeDBObject(long id);

	List<Object[]> listExtendedDBObjects();
}