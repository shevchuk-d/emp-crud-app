package com.emp.app.objecttypes.model;

import com.emp.app.objects.model.DBObject;

import javax.persistence.*;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */
@Entity (name="Object_types")
@Table(name="new_employees.Object_types")
public class DBObjectType {

	@Id
	@Column(name="object_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long objectTypeId;

	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getObjectTypeId() {
		return objectTypeId;
	}

	public void setObjectTypeId(long object_type_id) {
		this.objectTypeId = object_type_id;
	}
	
	@Override
	public String toString(){
		return "name="+name+", ot_id="+objectTypeId;
	}

	@OneToMany(mappedBy="Objects")
	private List<DBObject> listDBObjects ;
}
