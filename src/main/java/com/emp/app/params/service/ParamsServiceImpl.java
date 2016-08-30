package com.emp.app.params.service;

import java.util.List;

import com.emp.app.objects.dao.DBObjectDAO;
import com.emp.app.objects.model.DBObject;
import com.emp.app.params.dao.ParamsDAO;
import com.emp.app.params.model.Params;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ParamsServiceImpl implements ParamsService {

	private ParamsDAO paramsDAO;

	public void setParamsDAO(ParamsDAO dbObjectDAO) {
		this.paramsDAO = paramsDAO;
	}

	@Override
	@Transactional
	public void addParams(Params p) {
		this.paramsDAO.addParams(p);
	}

	@Override
	@Transactional
	public void updateParams(Params p) {
		this.paramsDAO.updateParams(p);
	}

	@Override
	@Transactional
	public List<Params> listParams() {
		return this.paramsDAO.listParams();
	}

	@Override
	@Transactional
	public Params getParamsById(long id) {
		return this.paramsDAO.getParamsById(id);
	}

	@Override
	@Transactional
	public void removeParams(long id) {
		this.paramsDAO.removeParams(id);
	}
}
