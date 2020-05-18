# Simple-Rest-Service
This serves as a simple rest service which returns json data using a custom json parser.



The Api works as:


"/api/getAll" return all employee model data as a json obj

"/api/getbyid/{empid}" return a json object of employee with id = empid
"/api/getbyname/{empname}" return a json object with list of employees with name matching with empname


used Database : mysql
edit connection properties in : "dbconnection.properties"

===DATABASE CODE==== 

create table employeedb(
employeeid integer primary key,
employeename varchar(20));

insert into employeedb values (105,"aaa");
insert into employeedb values (106,"bba");
insert into employeedb values (107,"bcca");
insert into employeedb values (108,"cdda");
