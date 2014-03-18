CREATE TABLE TBLRepresentative (
  'representative_id' int(11) NOT NULL AUTO_INCREMENT,
  'first_name' varchar(256) DEFAULT NULL,
  'last_name' varchar(256) DEFAULT NULL,
  'email' varchar(256) DEFAULT NULL,
  PRIMARY KEY ('representative_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;