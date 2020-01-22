create table PUBLIC.COUNTERS
(
	ID INTEGER not null
		primary key,
	AMOUNT DOUBLE,
	VILLAGE_ID INTEGER,
	constraint FKHYINM74U5U8LX7G4VHV62P8TH
		foreign key (VILLAGE_ID) references VILLAGES (ID)
);

create table PUBLIC.VILLAGES
(
	ID INTEGER not null
		primary key,
	NAME VARCHAR(255)
);

create table PUBLIC.EVENTS
(
	ID VARBINARY not null
		primary key,
	CREATED_ON VARBINARY(255) not null,
	MODIFIED_ON VARBINARY(255) not null,
	PAYLOAD VARCHAR(255),
	STATUS INTEGER not null,
	TYPE VARCHAR(255) not null,
	VERSION INTEGER not null
);

