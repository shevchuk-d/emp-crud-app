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
@Entity
@Table(name="objects")
public class DBObject {

	@Id
	@Column(name="object_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int ot_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountry() {
		return ot_id;
	}

	public void setCountry(int ot_id) {
		this.ot_id = ot_id;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", ot_id="+ot_id;
	}
}
