package com.emp.app.objects.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity(name="Objects")
@Table(name="new_employees.Objects")
public class DBObject {

	@Id
	@Column(name="object_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name")
	private String name;

    @Column(name="object_type_id")
	private long objectTypeId;

	@Column(name="old_object_id")
	private String oldObjectId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setObjectTypeId(long object_type_id) {
		this.objectTypeId = object_type_id;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", ot_id="+objectTypeId;
	}

	public String getOldObjectId() {
		return oldObjectId;
	}

	public void setOldObjectId(String oldObjectId) {
		this.oldObjectId = oldObjectId;
	}
}
