package com.emp.app.params.model;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objecttypes.model.DBObjectType;

import javax.persistence.*;


@Entity(name="Params")
@Table(name="new_employees.Params")
public class Params {

	@EmbeddedId
	private ParamsPK paramsPK;

	@Column(name="value")
	private String value;

	public String getName() {
		return value;
	}

	public void setName(String value) {
		this.value = value;
	}


	public ParamsPK getParamsPK() {
		return paramsPK;
	}

	public void setParamsPK(ParamsPK paramsPK) {
		this.paramsPK = paramsPK;
	}
}
