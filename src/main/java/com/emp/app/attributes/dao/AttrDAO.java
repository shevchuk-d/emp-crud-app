package com.emp.app.attributes.dao;

import java.util.List;

import com.emp.app.attributes.model.Attr;
import com.emp.app.objects.model.DBObject;

public interface AttrDAO {

	public void addAttr(Attr p);
	public void updateAttr(Attr p);
	public List<Attr> listAttrs();

	public Attr getAttrById(long id);
	public void removeAttr(long id);

}
