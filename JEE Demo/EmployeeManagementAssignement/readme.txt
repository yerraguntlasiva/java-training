create tables (for oracle specific query)
====================
 create table emp2(id number primary key,name varchar2(100),email varchar2(20),password varchar2(20),salary float,permission varchar2(20) default 'user' );
 insert into emp2 values(102,'rahul','rahul@gmail.com','rahul',40000.0,'user');
 insert into emp2 values(101,'srk','srk@gmail.com','srk',50000.0,'admin');
 
 