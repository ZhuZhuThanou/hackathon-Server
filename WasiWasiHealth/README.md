## Welcome to WasiWasi Health ##

WasiWasi was created during the Hackathom http://www.devswithoutborders.org/breakpoverty/

This project requires to the following to be installed

1. Maven https://maven.apache.org/
2. PostgreSQL 9.x http://www.postgresql.org/
3. Tomcat http://tomcat.apache.org/

The project uses Java, Spring MVC and JdbcTemplate. Maven is used to structure the project with a parent project and a web module. The Android is not included currently as it requires more work.

- For development, create the database with the following specifications:

```
# Postgresql
# Data name: wasiwasidb
# User Id: wasiwasi
# Pwd: qweasdzxc123

# Revision - 1
create table admin_user ( 
	id				varchar(100) primary key, 
	email			varchar(100) not null, 
	uid				varchar(100) not null,
	pwd				varchar(100) not null );
	
#Revision - 2
create table survey (
	id 				varchar(100) primary key,
	name			varchar(150) not null,
	active 			boolean,
	activation_date	date,
	created_by		varchar(100) not null,
	created_ts		timestamp not null,
	modified_by		varchar(100),
	modified_ts		timestamp
	);
	
#Revision - 3
create table survey_question ( 
	id				varchar(100) primary key, 
	survey_id		varchar(100) not null,
	json_data		text);	
	
create table sms(
	id				varchar(100) primary key,
	json_data		text);
	

```


Oh yeah. This project is open source. 


