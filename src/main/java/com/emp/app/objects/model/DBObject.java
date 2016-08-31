package com.emp.app.objects.model;


import com.emp.app.objecttypes.model.DBObjectType;
import com.emp.app.params.model.Params;

import javax.persistence.*;
import java.util.List;


@Entity(name="Objects")
@Table(name="new_employees.Objects")
public class DBObject {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name="object_type_id")
	private DBObjectType dbObjectType;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn( name="object_id", insertable=false, updatable=false)
//	private Params params;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="object_id", nullable = false, updatable = false, insertable = false)
	private long objectId;

	@Column(name="name")
	private String name;

    @Column(name="object_type_id", nullable = false, updatable = false, insertable = false )
	private long objectTypeId;

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
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
		return "objectId="+ objectId +", name="+name+", ot_id="+objectTypeId;
	}

	public DBObjectType getDbObjectType() {
		return dbObjectType;
	}

	public void setDbObjectType(DBObjectType dbObjectType) {
		this.dbObjectType = dbObjectType;
	}

	@OneToMany(mappedBy="paramsPK.objectId")
	private List<Params> paramsList;

}
