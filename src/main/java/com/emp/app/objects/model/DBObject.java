package com.emp.app.objects.model;

import com.emp.app.attributes.model.Attr;
import com.emp.app.objecttypes.model.DBObjectType;

import javax.persistence.*;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity(name="Objects")
@Table(name="new_employees.Objects")
public class DBObject {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "object_type_id", nullable = false)
	private DBObjectType dbObjectType;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="object_id")
	private long id;

	@Column(name="name")
	private String name;

    @Column(name="object_type_id", nullable = false, updatable = false, insertable = false )
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

	public void setObjectTypeId(long objectTypeId) {
		this.objectTypeId = objectTypeId;
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

	public DBObjectType getDbObjectType() {
		return dbObjectType;
	}

	public void setDbObjectType(DBObjectType dbObjectType) {
		this.dbObjectType = dbObjectType;
	}

	@OneToMany(mappedBy="objectTypeId")
	private List<Attr> listAttrs ;

}
