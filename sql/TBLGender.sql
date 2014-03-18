CREATE TABLE TBLGender (
	'gender_id' int(11) NOT NULL AUTO_INCREMENT,
	'gender_name' text NOT NULL,
	PRIMARY KEY ('gender_name')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLGender (gender_name)
VALUES ('Female'), ('Male');
