package com.emp.app.employees.departments.model;

import javax.persistence.*;

/**
 * Created by dmsh0216 on 8/16/2016.
 */
@Entity
@Table(name="DEPARTMENTS")
public class Departments {
    @Id
    @Column(name="DEPT_NO")
    private int deptNo;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return "deptNo=" + deptNo + ", name=" + name;
    }
}
