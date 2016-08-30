package com.emp.app.params.model;

import com.emp.app.attributes.model.Attr;
import com.emp.app.objects.model.DBObject;
import com.emp.app.objecttypes.model.DBObjectType;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ParamsPK implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "object_id")
    private DBObject dbObject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "attr_id" )
    private Attr attr;

    @Column(name = "object_id")
    private long objectId;

    @Column(name = "attr_id")
    private long attrId;

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public long getAttrId() {
        return attrId;
    }

    public void setAttrId(long attrId) {
        this.attrId = attrId;
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