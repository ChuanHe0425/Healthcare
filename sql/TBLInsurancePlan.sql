CREATE TABLE TBLInsurancePlan (
  'plan_id' int(11) NOT NULL AUTO_INCREMENT,
  'plan_name' varchar(256) DEFAULT NULL,
  'insurance_company_id' int(11) DEFAULT NULL,
  'cost_individual' decimal(10,0) DEFAULT NULL,
  'cost_family_zero' decimal(10,0) DEFAULT NULL,
  'cost_family_one' decimal(10,0) DEFAULT NULL,
  'cost_family_more' decimal(10,0) DEFAULT NULL,
  PRIMARY KEY ('plan_id'),
  KEY 'fk_ins_company' ('insurance_company_id'),
  CONSTRAINT 'fk_ins_company' FOREIGN KEY ('insurance_company_id') REFERENCES 'TBLInsuranceCompany' ('insurance_company_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;