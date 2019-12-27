DROP TABLE IF EXISTS USER_ROLES CASCADE;
CREATE TABLE USER_ROLES (
	USER_ROLE_ID SERIAL PRIMARY KEY,
	USER_ROLE VARCHAR(150) NOT NULL
);

DROP TABLE IF EXISTS USERS CASCADE;
CREATE TABLE USERS(
	USERS_ID SERIAL PRIMARY KEY,
	USERNAME VARCHAR(100) NOT NULL,
	PW VARCHAR(100) NOT NULL,
	FIRST_NAME VARCHAR(100) NOT NULL,
	LAST_NAME VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	ROLE_ID INTEGER NOT NULL,
	
	FOREIGN KEY (ROLE_ID) REFERENCES USER_ROLES(USER_ROLE_ID)
);

DROP TABLE IF EXISTS REIMB_TYPE CASCADE;
CREATE TABLE REIMB_TYPE(
	REIMB_TYPE_ID SERIAL PRIMARY KEY,
	REIMB_TYPE TEXT
); 

DROP TABLE IF EXISTS REIMB_STATUS CASCADE;
CREATE TABLE REIMB_STATUS(
	STATUS_ID SERIAL PRIMARY KEY,
	REIMB_STATUS VARCHAR(250)
);

DROP TABLE IF EXISTS REIMBURSEMENT CASCADE;
CREATE TABLE REIMBURSEMENT(
	REIMB_ID SERIAL PRIMARY KEY,
	AMOUNT NUMERIC NOT NULL,
	SUBMITTED TIMESTAMP,
	RESOLVED TIMESTAMP,
	DESCRIPTION TEXT,
	RECIEPT BYTEA,
	
	AUTHOR_ID INTEGER NOT NULL,
	RESOLVER INTEGER NOT NULL,
	STATUS_ID INTEGER NOT NULL,
	TYPE_ID INTEGER NOT NULL,
	
	FOREIGN KEY (TYPE_ID) REFERENCES REIMB_TYPE(REIMB_TYPE_ID),
	FOREIGN KEY (STATUS_ID) REFERENCES REIMB_STATUS(STATUS_ID),
	FOREIGN KEY (AUTHOR_ID) REFERENCES USERS(USERS_ID),
	FOREIGN KEY (RESOLVER) REFERENCES USERS(USERS_ID)
);