create database BJM20_DB;

create table students_info
(regno int(10) not null,
 firstname varchar(50),
 middlename varchar(50),
 lastname varchar(50),
 primary key(regno)
);

create table guardian_info
(regno int(10) not null,
 gfirstname varchar(50),
 gmiddlename varchar(50),
 glastname varchar(50),
 primary key(regno)
);

create table students_otherinfo
(regno int(10) not null,
 isadmin varchar(1),
 password varchar(50),
 primary key(regno)
);

create table course_info
(courseid int(10) not null,
 coursename varchar(50),
 primary key(courseid)
);

alter table students_info add column courseid int(10);

