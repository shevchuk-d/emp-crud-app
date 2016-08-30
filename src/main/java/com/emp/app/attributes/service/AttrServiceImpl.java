package com.emp.app.attributes.service;

import java.util.List;


import com.emp.app.attributes.dao.AttrDAO;
import com.emp.app.attributes.dao.AttrDAOImpl;
import com.emp.app.attributes.model.Attr;
import com.emp.app.objecttypes.dao.DBObjectTypeDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;


@Service
public class AttrServiceImpl implements AttrService {

	private AttrDAO attrDAO;

	@Override
	@Transactional
	public void addAttr(Attr p) {
		this.attrDAO.addAttr(p);
	}

	@Override
	@Transactional
	public void updateAttr(Attr p) {
		this.attrDAO.updateAttr(p);
	}

	@Override
	@Transactional
	@OneToMany(mappedBy = "object_types", cascade = CascadeType.ALL)
	public List<Attr> listAttrs() {
		return this.attrDAO.listAttrs();
	}

	@Override
	@Transactional
	public Attr getAttrById(long id) {
		return this.attrDAO.getAttrById(id);
	}

	@Override
	@Transactional
	public void removeAttr(long id) {
		this.attrDAO.removeAttr(id);
	}


    public void setAttrDAO(AttrDAOImpl attrDAO) {
        this.attrDAO = attrDAO;
    }

    public AttrDAO getAttrDAO() {
        return attrDAO;
    }
}
