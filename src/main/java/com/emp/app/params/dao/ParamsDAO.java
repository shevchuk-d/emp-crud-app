package com.emp.app.params.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;

public interface ParamsDAO {

	public void addDBObject(Params p);
	public void updateDBObject(Params p);
	public List<Params> listDBObjects();

	public Params getDBObjectById(long id);
	public void removeDBObject(long id);

	public List<Object[]> listExtendedDBObjects();
}
