CREATE TABLE TBLGender (
  'gender_id' int(11) NOT NULL AUTO_INCREMENT,
  'gender_name' varchar(8) DEFAULT NULL,
  PRIMARY KEY ('gender_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLGender(gender_name)
VALUES ('female'),('male');