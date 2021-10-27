DROP SCHEMA IF EXISTS FOG_VALLEY;
CREATE SCHEMA FOG_VALLEY;

USE FOG_VALLEY;

DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
	ID VARCHAR(320),
    PASSWORD VARCHAR(50),
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50)
);

INSERT INTO USER VALUES('michael.d.robideau@gmail.com', 'password', 'Mike', 'Robideau');

DROP TABLE IF EXISTS SAVED_GAME;
CREATE TABLE SAVED_GAME (
	USER_ID VARCHAR(256) PRIMARY KEY,
	UNLOCKED_TRANSCRIPTS BLOB
);

INSERT INTO SAVED_GAME VALUES('michael.d.robideau@gmail.com', '{"professor/abc": {"isNew": true}}');

SELECT * FROM SAVED_GAME;