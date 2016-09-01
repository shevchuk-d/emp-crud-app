package com.emp.app.objects.service;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import org.springframework.transaction.annotation.Transactional;

public interface DBObjectService {

	void addDBObject(DBObject p);
	void updateDBObject(DBObject p);
	List<DBObject> listDBObjects();
	DBObject getDBObjectById(long id);
	void removeDBObject(long id);

	List<Object[]> listExtendedDBObjects();

	@Transactional
	List<Object[]> listExtendedDBObjects(int limit);
}