CREATE DATABASE IF NOT EXISTS jovault;

USE jovault;

CREATE TABLE comedians (
	id INT IDENTITY(1,1) PRIMARY KEY,
	name VARCHAR(255)
);

INSERT INTO comedians (name) VALUES ("John Mulaney");
INSERT INTO comedians (name) VALUES ("Daniel Tosh");
INSERT INTO comedians (name) VALUES ("Aziz Ansari");
INSERT INTO comedians (name) VALUES ("Bo Burnham");
INSERT INTO comedians (name) VALUES ("Bill Burr");
INSERT INTO comedians (name) VALUES ("Mitch Hedberg");
INSERT INTO comedians (name) VALUES ("Josh Blue");
INSERT INTO comedians (name) VALUES ("Lavell Crawford");
INSERT INTO comedians (name) VALUES ("George Carlin");
INSERT INTO comedians (name) VALUES ("Tom Segura");
INSERT INTO comedians (name) VALUES ("Robin Williams");