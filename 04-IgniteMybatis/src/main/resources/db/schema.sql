
CREATE TABLE IF NOT EXISTS PUBLIC.student (
	studId INTEGER,
	name VARCHAR,
	email VARCHAR,
	dob Date,
	PRIMARY KEY (studId, name))
WITH "template=replicated,atomicity=ATOMIC,cache_name=student";
-- WITH "template=student,atomicity=ATOMIC,cache_name=student";

CREATE INDEX IF NOT EXISTS STUDENT_NE_INDEX ON PUBLIC.STUDENT (NAME, EMAIL);


CREATE TABLE IF NOT EXISTS PUBLIC.grade (
	studId INTEGER,
	grade DOUBLE,
	PRIMARY KEY (studId))
WITH "template=replicated,atomicity=ATOMIC,cache_name=grade";
