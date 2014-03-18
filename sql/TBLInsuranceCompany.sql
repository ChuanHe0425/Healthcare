CREATE TABLE TBLInsuranceCompany (
  'insurance_company_id' int(11) NOT NULL AUTO_INCREMENT,
  'company_name' varchar(256) DEFAULT NULL,
  'city' varchar(256) DEFAULT NULL,
  'state' varchar(2) DEFAULT NULL,
  'representative_id' int(11) DEFAULT NULL,
  PRIMARY KEY ('insurance_company_id'),
  KEY 'fk_rep_id_ins' ('representative_id'),
  CONSTRAINT 'fk_rep_id_ins' FOREIGN KEY ('representative_id') REFERENCES 'TBLRepresentative' ('representative_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;