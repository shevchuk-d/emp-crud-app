package com.emp.app.params.service;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;

public interface ParamsService {

	public void addDBObject(Params p);
	public void updateDBObject(Params p);
	public List<Params> listDBObjects();
	public Params getDBObjectById(long id);
	public void removeDBObject(long id);

	public List<Object[]> listExtendedDBObjects();
}
