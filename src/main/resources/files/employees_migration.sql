drop TABLE IF EXISTS new_employees.params;
drop TABLE IF EXISTS new_employees.objects;
drop TABLE IF EXISTS new_employees.attributes;
drop TABLE IF EXISTS new_employees.object_types;

-- #################### object_types #########################

CREATE TABLE new_employees.object_types (
    object_type_ID int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    primary key(object_type_id)
)AUTO_INCREMENT=100
;

-- #################### objects #########################

CREATE TABLE new_employees.objects (
    object_ID bigint NOT NULL AUTO_INCREMENT,
    object_type_ID int not null,
    name VARCHAR(255),
    old_object_ID VARCHAR(32) not null,
    foreign KEY (object_type_ID) references new_employees.object_types(object_type_ID),
    PRIMARY KEY (object_ID)
)AUTO_INCREMENT=1000000000000
;

-- #################### attributes #########################

CREATE TABLE new_employees.attributes (
    attr_id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    object_type_id int,
    foreign key (object_type_id) references new_employees.object_types(object_type_id),
    PRIMARY KEY (attr_id)
)AUTO_INCREMENT=1000
;

-- #################### params #########################

CREATE TABLE new_employees.params (
    object_ID bigint,
    attr_id int not null,
    value VARCHAR(255),
    foreign KEY (attr_id) references new_employees.attributes(attr_id),
    foreign KEY (object_ID) references new_employees.objects(object_ID)
)
;

-- #################### filling data into object_types #########################

insert into new_employees.object_types(name) values('Employee');
insert into new_employees.object_types(name) values('Department');

-- #################### filling data into attributes #########################

-- employees
insert into new_employees.attributes(name, object_type_id) values('From Date', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('To Date', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Is Manager', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Department', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Birth Date', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Hire Date', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Gender', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Salary', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Title', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('First Name', (select object_type_id from new_employees.object_types where name = 'Employee'));
insert into new_employees.attributes(name, object_type_id) values('Last Name', (select object_type_id from new_employees.object_types where name = 'Employee'));

-- #################### filling data into objects #########################

insert into new_employees.objects(name, object_type_id, old_object_ID)(
	select * from(
		select concat(e.first_name, " ", e.last_name), (select object_type_id from new_employees.object_types ot where ot.name = 'Employee'), e.emp_no
		from employees.employees e
		union all
		select d.dept_name, (select object_type_id from new_employees.object_types ot where ot.name = 'Department'), d.dept_no
		from employees.departments d
	) name
)
;

-- #################### filling data into params #########################

insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, e.birth_date as 'value'
    from new_employees.objects o
    join employees.employees e
	on (o.old_object_id = e.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Birth Date')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, e.gender as 'value'
    from new_employees.objects o
    join employees.employees e
	on (o.old_object_id = e.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Gender')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, e.hire_date as 'value'
    from new_employees.objects o
    join employees.employees e
	on (o.old_object_id = e.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Hire Date')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, e.gender as 'value'
    from new_employees.objects o
    join employees.employees e
	on (o.old_object_id = e.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'First Name')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, e.hire_date as 'value'
    from new_employees.objects o
    join employees.employees e
	on (o.old_object_id = e.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Last Name')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, s.salary as 'value'
    from new_employees.objects o
    join employees.salaries s
	on (o.old_object_id = s.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Salary')
);
insert into new_employees.params (object_id, attr_id, value) (
    select o.object_id, a.attr_id, dm.dept_no as 'value'
    from new_employees.objects o
    join employees.dept_manager dm
	on (o.old_object_id = dm.emp_no)
	join new_employees.attributes a
	on (o.object_type_id = a.object_type_id and a.name = 'Is Manager')
);
