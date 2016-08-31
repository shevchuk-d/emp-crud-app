package com.emp.app.params.model;

import com.emp.app.attributes.model.Attr;
import com.emp.app.objects.model.DBObject;

import javax.persistence.*;


@Entity(name="Params")
@Table(name="new_employees.Params")
public class Params {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name="object_id", insertable=false, updatable=false)
	@MapsId("objectId")
	private DBObject dbObject;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name="attr_id", insertable=false, updatable=false)
	@MapsId("attrId")
	private Attr attr;

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

	public DBObject getDbObject() {
		return dbObject;
	}

	public void setDbObject(DBObject dbObject) {
		this.dbObject = dbObject;
	}

	public Attr getAttr() {
		return attr;
	}

	public void setAttr(Attr attr) {
		this.attr = attr;
	}
}
