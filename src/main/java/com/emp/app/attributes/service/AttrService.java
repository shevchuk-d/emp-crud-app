package com.emp.app.attributes.service;

import java.util.List;

import com.emp.app.attributes.model.Attr;


public interface AttrService {

	void addAttr(Attr p);
	void updateAttr(Attr p);
	List<Attr> listAttrs();
	Attr getAttrById(long id);
	void removeAttr(long id);

}
