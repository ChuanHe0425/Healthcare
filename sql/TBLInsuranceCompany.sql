CREATE TABLE TBLInsuranceCompany (
  'insurance_company_id' int(11) NOT NULL AUTO_INCREMENT,
  'company_name' varchar(256) DEFAULT NULL,
  'city' varchar(256) DEFAULT NULL,
  'state' varchar(2) DEFAULT NULL,
  'representative_name' varchar(256) DEFAULT NULL,
  PRIMARY KEY ('insurance_company_id'),
) ENGINE=InnoDB DEFAULT CHARSET=latin1;