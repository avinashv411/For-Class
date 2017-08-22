SQl Queries for MySQL RDBMS Application:-
==========================================
create database BECE67_DB;

create table students_info
( regno int(10) not null,
  firstname varchar(50),
  middlename varchar(50),
  lastname varchar(50),
  primary key(regno)
);

insert into students_info
values (1, 'Praveen', 'NA', 'D');

Some Usefull Queries:
========================
1. To connect to database:-
----------------------------
   use BECE67_DB;
   
2. To get the list of databases:-
---------------------------------
	show databases;
	
3. To get the list of tables:-
------------------------------
	show tables;
   





