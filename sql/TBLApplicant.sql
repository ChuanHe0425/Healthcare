CREATE TABLE TBLApplicant (
  'applicant_id' int(11) NOT NULL AUTO_INCREMENT,
  'user_id' int(11) DEFAULT NULL,
  'first_name' varchar(256) DEFAULT NULL,
  'last_name' varchar(256) DEFAULT NULL,
  'street_number' varchar(10) DEFAULT NULL,
  'street_name' varchar(256) DEFAULT NULL,
  'city' varchar(256) DEFAULT NULL,
  'state' varchar(2) DEFAULT NULL,
  'zipcode' varchar(5) DEFAULT NULL,
  'phone_number' varchar(10) DEFAULT NULL,
  'email' varchar(256) DEFAULT NULL,
  PRIMARY KEY ('applicant_id'),
  KEY 'fk_user_id' ('user_id'),
  CONSTRAINT 'fk_user_id' FOREIGN KEY ('user_id') REFERENCES 'TBLProfile' ('user_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;