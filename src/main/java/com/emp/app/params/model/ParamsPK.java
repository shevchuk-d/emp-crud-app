package com.emp.app.params.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ParamsPK implements Serializable {



    @Column(name = "object_id")
    private long objectId;

    @Column(name = "attr_id", nullable=false)
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


}