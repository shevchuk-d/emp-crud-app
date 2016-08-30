package com.emp.app.params.dao;

import java.util.List;

import com.emp.app.objects.model.DBObject;
import com.emp.app.params.model.Params;

public interface ParamsDAO {

	void addParams(Params p);
	void updateParams(Params p);
	List<Params> listParams();

	Params getParamsById(long id);
	void removeParams(long id);


}
