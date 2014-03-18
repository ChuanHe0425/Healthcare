CREATE TABLE TBLCustomerType (
  'customer_type_id' int(11) NOT NULL AUTO_INCREMENT,
  'customer_type_text' varchar(256) DEFAULT NULL,
  PRIMARY KEY ('customer_type_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLCustomerType(customer_type_text)
VALUES('Individual'),('Family No Children'),('Family One Child'),('Family More Children');