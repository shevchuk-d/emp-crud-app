package com.emp.app.params.service;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;

public interface ParamsService {

	void addParams(Params p);
	void updateParams(Params p);
	List<Params> listParams(long objectId);
	Params getParamsById(long id);
	void removeParams(long id);
}
