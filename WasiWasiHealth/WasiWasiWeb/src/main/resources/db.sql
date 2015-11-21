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
	
