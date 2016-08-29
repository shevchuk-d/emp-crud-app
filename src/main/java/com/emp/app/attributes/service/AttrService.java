package com.emp.app.attributes.service;

import java.util.List;

import com.emp.app.attributes.model.Attr;


public interface AttrService {

	public void addDBObject(Attr p);
	public void updateDBObject(Attr p);
	public List<Attr> listDBObjects();
	public Attr getDBObjectById(long id);
	public void removeDBObject(long id);

	public List<Object[]> listExtendedDBObjects();
}
