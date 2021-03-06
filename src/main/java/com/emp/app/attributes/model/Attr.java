package com.emp.app.attributes.model;

import com.emp.app.objecttypes.model.DBObjectType;
import com.emp.app.params.model.Params;

import javax.persistence.*;
import java.util.List;


@Entity(name="Attributes")
@Table(name="new_employees.Attributes")
public class Attr {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "object_type_id" )
	private DBObjectType dbObjectType;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attr_id")
	private long attrId;

	@Column(name="name")
	private String name;

    @Column(name="object_type_id", nullable = false, updatable = false, insertable = false )
	private long objectTypeId;

	public long getId() {
		return attrId;
	}

	public void setId(long id) {
		this.attrId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getObjectTypeId() {
		return objectTypeId;
	}

	public void setObjectTypeId(long objectTypeId) {
		this.objectTypeId = objectTypeId;
	}
	
	@Override
	public String toString(){
		return "id="+attrId+", name="+name+", ot_id="+objectTypeId;
	}

	public DBObjectType getDbObjectType() {
		return dbObjectType;
	}

	public void setDbObjectType(DBObjectType dbObjectType) {
		this.dbObjectType = dbObjectType;
	}

	@OneToMany(mappedBy="paramsPK.attrId")
	private List<Params> paramsList;

	public List<Params> getParamsList() {
		return paramsList;
	}

	public void setParamsList(List<Params> paramsList) {
		this.paramsList = paramsList;
	}
}
